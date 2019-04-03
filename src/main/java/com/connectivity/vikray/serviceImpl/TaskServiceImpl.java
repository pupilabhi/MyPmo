package com.connectivity.vikray.serviceImpl;

import java.io.IOException;
import java.net.URI;
import java.security.GeneralSecurityException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.xml.stream.events.Comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.connectivity.vikray.controller.TaskController;
import com.connectivity.vikray.entity.Documents;
import com.connectivity.vikray.entity.Phase;
import com.connectivity.vikray.entity.Task;
import com.connectivity.vikray.entity.TaskComment;
import com.connectivity.vikray.entity.TaskFollower;
import com.connectivity.vikray.entity.TaskStatus;
import com.connectivity.vikray.entity.UserDetails;
import com.connectivity.vikray.payload.ApiResponse;
import com.connectivity.vikray.repository.DocumentRepository;
import com.connectivity.vikray.repository.DomainRepository;
import com.connectivity.vikray.repository.PhaseRepository;
import com.connectivity.vikray.repository.TaskCommentRepository;
import com.connectivity.vikray.repository.TaskPriorityRepository;
import com.connectivity.vikray.repository.TaskRepository;
import com.connectivity.vikray.repository.TaskStatusRepository;
import com.connectivity.vikray.repository.UserDetailsRepository;
import com.connectivity.vikray.resource.TaskResource;
import com.connectivity.vikray.util.EventImpl;
import com.connectivity.vikray.util.LoggedInUser;

@Repository
public class TaskServiceImpl {

	@Autowired
	EventImpl eventImpl;

	@Autowired
	TaskRepository taskRepository;

	@Autowired
	DomainRepository domainRepository;

	@Autowired
	TaskPriorityRepository taskPriorityRepository;

	@Autowired
	UserDetailsRepository userDetailsRepository;

	@Autowired
	PhaseRepository phaseRepository;

	@Autowired
	DocumentRepository documentRepository;

	@Autowired
	TaskCommentRepository taskCommentRepository;

	@Autowired
	TaskStatusRepository taskStatusRepository;

	@Autowired
	LoggedInUser currentUser;

	@Autowired
	TaskPriorityRepository priorityRepo;

	protected static final SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm a yyyy");

	// create Task
	public ResponseEntity<ApiResponse> createTask(Task taskfrmclint) {

		Task toDb = new Task();
		toDb.setDueDate(taskfrmclint.getDueDate());
		toDb.setGuid(UUID.randomUUID().toString());
		toDb.setTaskName(taskfrmclint.getTaskName());
		toDb.setDescription(taskfrmclint.getDescription());
		toDb.setAccountAddress(taskfrmclint.getAccountAddress());
		Phase pFrmDb = phaseRepository.getOne(taskfrmclint.getPhaseFk().getId());
		if(!pFrmDb.getTaskStatus().isEmpty()) {
			List<TaskStatus> taskStatus = pFrmDb.getTaskStatus();
			for(TaskStatus ts : taskStatus) {
				if(ts.getConstByName().equals("TO DO")) {
					toDb.setCurrentStatus(taskStatusRepository.getOne(ts.getId()));
				}
			}
		}
		
		if (taskfrmclint.getAssignee() != null)
			toDb.setAssignee(userDetailsRepository.getOne(taskfrmclint.getAssignee().getId()));
		if (taskfrmclint.getDueDate() != null)
			toDb.setDueDate(taskfrmclint.getDueDate());
		if (taskfrmclint.getTaskPriority() != null)
			toDb.setTaskPriority(taskPriorityRepository.getOne(taskfrmclint.getTaskPriority().getId()));
		if (taskfrmclint.getPhaseFk() != null) {
			toDb.setPhaseFk(phaseRepository.getOne(taskfrmclint.getPhaseFk().getId()));
		}
		taskRepository.save(toDb);
		Set<Documents> docs = createUpdateDocument(taskfrmclint, toDb);
		toDb.setDocuments(docs);
		Set<TaskFollower> taskFollowers = createTaskFollower(taskfrmclint, toDb);
		toDb.setTaskFollowers(taskFollowers);
		try {
			eventImpl.createEvent(toDb);
		} catch (GeneralSecurityException | IOException e) {
			e.printStackTrace();
		}
		URI uri = MvcUriComponentsBuilder.fromController(TaskController.class).path("/{id}")
				.buildAndExpand(toDb.getId()).toUri();
		return ResponseEntity.created(uri).body(new ApiResponse(true, "", new TaskResource(toDb)));
	}

	// create Documents
	private Set<Documents> createUpdateDocument(Task taskfrmclint, Task task) {
		Set<Documents> docsfrmclint = taskfrmclint.getDocuments();
		Set<Documents> newdocs = new HashSet<Documents>();
		Iterator<Documents> itr = docsfrmclint.iterator();
		while (itr.hasNext()) {
			Documents doc = itr.next();
			if (doc.getId() == 0) {
				Documents docsToDb = new Documents();
				docsToDb.setPath(doc.getPath());
				docsToDb.setTaskFk(doc.getTaskFk());
				documentRepository.save(doc);
				newdocs.add(doc);
			} else {
				Documents frmDb = documentRepository.getOne(doc.getId());
				frmDb.setPath(doc.getPath());
				frmDb.setTaskFk(doc.getTaskFk());
				documentRepository.save(frmDb);
				newdocs.add(frmDb);
			}

		}
		return newdocs;
	}

	// createTaskCCUser
	private Set<TaskFollower> createTaskFollower(Task taskfrmclint, Task task) {
		Set<TaskFollower> taskCcUsers = taskfrmclint.getTaskFollowers();
		Set<TaskFollower> newTask = new HashSet<TaskFollower>();
		Iterator<TaskFollower> itr = taskCcUsers.iterator();
		while (itr.hasNext()) {
			TaskFollower taskCcUserToDb = new TaskFollower();
			taskCcUserToDb = itr.next();
			taskCcUserToDb.setTask(taskCcUserToDb.getTask());
			newTask.add(taskCcUserToDb);
		}
		return newTask;

	}

	public ResponseEntity<ApiResponse> updateTask(Task taskfromClient) {
		Task taskfromDb = taskRepository.getOne(taskfromClient.getId());
		UserDetails loggedInUser = currentUser.getCurrentUser();
		if (taskfromDb == null) {
			return null;
		}
		if (taskfromClient.getTaskPriority() != null) {
			if (taskfromDb.getTaskPriority().getId() != taskfromClient.getTaskPriority().getId()) {
				_processTaskPriority(taskfromDb, taskfromClient, loggedInUser);
			}
		if(taskfromClient.getCurrentStatus() != null) {
			if (taskfromDb.getCurrentStatus().getId() != taskfromClient.getCurrentStatus().getId()) {
				_processTaskStatus(taskfromDb, taskfromClient, loggedInUser);
			}
		}
			taskfromDb.setDueDate(taskfromClient.getDueDate());
			taskfromDb.setGuid(taskfromClient.getGuid());
			taskfromDb.setVerifiedOn(taskfromClient.getVerifiedOn());
			taskfromDb.setDescription(taskfromClient.getDescription());
			taskfromDb.setAccountAddress(taskfromClient.getAccountAddress());

			for (Documents document : taskfromClient.getDocuments()) {
				if (document.getId() == 0) {
					Documents newDoc = new Documents();
					newDoc.setTaskFk(taskfromDb);
					newDoc.setPath(document.getPath());
					newDoc.setDocType(document.getDocType());
					documentRepository.save(newDoc);
				} else {
					Documents docFrmDb = documentRepository.getOne(document.getId());
					docFrmDb.setPath(document.getPath());
					docFrmDb.setDocType(document.getDocType());
				}
			}
			taskfromDb.setEventId(taskfromClient.getEventId());
			try {
				eventImpl.updateEvent(taskfromDb);
			} catch (GeneralSecurityException | IOException e) {
				e.printStackTrace();
			}
		}
		Task updatedTask = taskRepository.save(taskfromDb);
		if (updatedTask == null) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Update Failed", null),
					HttpStatus.EXPECTATION_FAILED);
		} else {
			URI uri = MvcUriComponentsBuilder.fromController(TaskController.class).path("/{id}")
					.buildAndExpand(updatedTask.getId()).toUri();
			return ResponseEntity.created(uri).body(new ApiResponse(true, "", new TaskResource(updatedTask)));
		}

	}

	public void _processTaskPriority(Task taskfromDb, Task taskfromClient, UserDetails loggedInUser) {

		taskfromDb.setTaskPriority(priorityRepo.getOne(taskfromClient.getTaskPriority().getId()));
		TaskComment comment = new TaskComment();
		comment.setDateTime(System.currentTimeMillis());
		comment.setUserDetails(loggedInUser);
		comment.setComment("Priority changed to " + taskfromDb.getTaskPriority().getName() + " on "
				+ format.format(new Date(System.currentTimeMillis())) + " by " + loggedInUser.getFirstName() + ".");
		taskfromDb.getTaskComments().add(0, comment);
		comment.setTask(taskfromDb);
	}

	public void _processTaskStatus(Task taskfromDb, Task taskfromClient, UserDetails loggedInUser) {
		TaskStatus ts = taskStatusRepository.getOne(taskfromClient.getId());
		
		taskfromDb.setCurrentStatus(ts);
		TaskComment comment = new TaskComment();
		comment.setComment("Task Moved to sttaus "+ts.getLabel()+" status on "
				+ format.format(new Date(System.currentTimeMillis()))+" by "+ loggedInUser.getFirstName());
//		comment.set
	}

	public void _verifyTask(Task taskfromDb, Task taskfromClient, UserDetails loggedInUser) {
		TaskStatus newStatus = new TaskStatus();
		taskStatusRepository.save(newStatus);
		newStatus.setConstByName("VERIFIED");
		newStatus.setLabel("Verified");
		newStatus.setPhase(phaseRepository.getOne(taskfromDb.getPhaseFk().getId()));
		taskfromDb.setCurrentStatus(newStatus);;
	}
	public List<Task> getAllTask() {
		return taskRepository.findAll();
	}

	public ResponseEntity<ApiResponse> addTaskComment(TaskComment commentsFrmClient) {
		TaskComment toDb = new TaskComment();
		Task task = null;
		if (commentsFrmClient.getTask() != null) {
			task = taskRepository.getOne(commentsFrmClient.getTask().getId());
			task.getTaskComments().add(0, toDb);
			toDb.setTask(task);
		}
		if (commentsFrmClient.getUserDetails() != null) {
			toDb.setUserDetails(userDetailsRepository.getOne(commentsFrmClient.getUserDetails().getId()));
		}
		toDb.setComment(commentsFrmClient.getComment());
		toDb.setDateTime(System.currentTimeMillis());
		taskCommentRepository.save(toDb);
		URI uri = MvcUriComponentsBuilder.fromController(TaskController.class).path("/").build().toUri();
		return ResponseEntity.created(uri).body(new ApiResponse(true, "", toDb));

	}

	public ResponseEntity<ApiResponse> updateTaskComment(TaskComment commentsFrmClient) {
		TaskComment fDb = taskCommentRepository.getOne(commentsFrmClient.getId());
		if (fDb == null) {
			return null;
		}
		if (commentsFrmClient.getTask() != null) {
			if (commentsFrmClient.getTask().getId() == 0) {
				commentsFrmClient.setTask(commentsFrmClient.getTask());
			} else {
				TaskComment taskToDb = taskCommentRepository.getOne(commentsFrmClient.getTask().getId());
			}
		}

		if (commentsFrmClient.getUserDetails() != null) {
			if (commentsFrmClient.getUserDetails().getId() == 0) {
				commentsFrmClient.setUserDetails(commentsFrmClient.getUserDetails());
			} else {
				UserDetails userToDb = userDetailsRepository.getOne(commentsFrmClient.getUserDetails().getId());
			}
		}
		fDb.setComment(commentsFrmClient.getComment());
		fDb.setDateTime(commentsFrmClient.getDateTime());
		TaskComment updateComment = taskCommentRepository.save(fDb);
		if (updateComment == null) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Update Failed", null),
					HttpStatus.EXPECTATION_FAILED);
		} else {
			URI uri = MvcUriComponentsBuilder.fromController(TaskController.class).path("/{id}")
					.buildAndExpand(updateComment.getId()).toUri();
			return ResponseEntity.created(uri).body(new ApiResponse(true, "", updateComment));
		}
	}

	public ResponseEntity<ApiResponse> getTaskById(Long id) {
		Task fromDb = taskRepository.getOne(id);
		return null;
	}

	public ResponseEntity<ApiResponse> getTaskByCreatorUser() {
		long id = currentUser.getCurrentUser().getId();
		return null;
//		return taskRepository.findById(id);
	}

	public ResponseEntity<ApiResponse> getTaskByGuid(String guid) {
		if (taskRepository.existsByGuid(guid)) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Task not found by guid : " + guid, null),
					HttpStatus.EXPECTATION_FAILED);
		}
		Task task = taskRepository.findByGuid(guid);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(guid).toUri();
		return ResponseEntity.created(uri).body(new ApiResponse(true, "", task));
	}

	public ResponseEntity<ApiResponse> creatStatus(TaskStatus status) {
		TaskStatus newStatus = null;
		newStatus = new TaskStatus();
		newStatus.setLabel(status.getLabel());
		newStatus.setConstByName(status.getLabel().toUpperCase());
		newStatus.setPhase(phaseRepository.getOne(status.getPhase().getId()));
		TaskStatus createdStatus = taskStatusRepository.save(newStatus);
		if (createdStatus == null) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Falied to create Status", null),
					HttpStatus.ACCEPTED);
		}

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
		return ResponseEntity.created(uri).body(new ApiResponse(true, "", newStatus));

	}

}
