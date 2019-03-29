package com.connectivity.vikray.serviceImpl;

import java.io.IOException;
import java.net.URI;
import java.security.GeneralSecurityException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskRejectedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.connectivity.vikray.controller.PhaseController;
import com.connectivity.vikray.controller.TaskController;
import com.connectivity.vikray.entity.Documents;
import com.connectivity.vikray.entity.Phase;
import com.connectivity.vikray.entity.Task;
import com.connectivity.vikray.entity.TaskComment;
import com.connectivity.vikray.entity.TaskFollower;
import com.connectivity.vikray.entity.TaskPriority;
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
import com.connectivity.vikray.resource.PhaseResource;
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
	
	// create Task
	public ResponseEntity<ApiResponse> createTask(Task taskfrmclint) {
		
		Task toDb = new Task();
		toDb.setDueDate(taskfrmclint.getDueDate());
		toDb.setGuid(UUID.randomUUID().toString());
		toDb.setTaskName(taskfrmclint.getTaskName());
		toDb.setDescription(taskfrmclint.getDescription());
		toDb.setAccountAddress(taskfrmclint.getAccountAddress());
		if(taskfrmclint.getAssignee() != null)
			toDb.setAssignee(userDetailsRepository.getOne(taskfrmclint.getAssignee().getId()));
		if(taskfrmclint.getDueDate() != null)
			toDb.setDueDate(taskfrmclint.getDueDate());
		if(taskfrmclint.getTaskPriority() != null)
			toDb.setTaskPriority(taskPriorityRepository.getOne(taskfrmclint.getTaskPriority().getId()));
		if (taskfrmclint.getPhaseFk() != null) {
			toDb.setPhaseFk(phaseRepository.getOne(taskfrmclint.getPhaseFk().getId()));
		}
		taskRepository.save(toDb);
		Set<Documents> docs = createDocument(taskfrmclint, toDb);
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
	private Set<Documents> createDocument(Task taskfrmclint, Task task) {
		Set<Documents> docsfrmclint = taskfrmclint.getDocuments();
		Set<Documents> newdocs = new HashSet<Documents>();
		Iterator<Documents> itr = docsfrmclint.iterator();
		while (itr.hasNext()) {
			Documents docsToDb = new Documents();
			docsToDb = itr.next();
			docsToDb.setPath(docsToDb.getPath());
			docsToDb.setTaskFk(docsToDb.getTaskFk());
			documentRepository.save(docsToDb);
			newdocs.add(docsToDb);
		}
		return newdocs;
	}

	// create TaskComments
	private Set<TaskComment> createTaskComments(Task taskfrmclint, Task task) {
		Set<TaskComment> tCommentsFromClient = taskfrmclint.getTaskComments();
		Set<TaskComment> newTask = new HashSet<TaskComment>();
		Iterator<TaskComment> itr = tCommentsFromClient.iterator();
		while (itr.hasNext()) {
			TaskComment tcommentTodb = new TaskComment();
			tcommentTodb = itr.next();
			tcommentTodb.setTask(tcommentTodb.getTask());
			taskCommentRepository.save(tcommentTodb);
			newTask.add(tcommentTodb);
		}
		return newTask;
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
//			taskCcUserRepository.save(taskCcUserToDb);
			newTask.add(taskCcUserToDb);
		}
		return newTask;

	}

	public Task updateTask(Task taskfromClient) {
		Task taskfromDb = taskRepository.getOne(taskfromClient.getId());
		if (taskfromDb == null) {
			return null;
		}


		if (taskfromClient.getTaskPriority() != null) {
			if (taskfromClient.getTaskPriority().getId() == 0) {
				taskfromClient.setTaskPriority(taskfromClient.getTaskPriority());
			} else {
				TaskPriority priorityToDb = taskPriorityRepository.getOne(taskfromClient.getTaskPriority().getId());
			}
		}

		if (taskfromClient.getTaskStatus() != null) {
			if (taskfromClient.getTaskStatus().getId() == 0) {
				taskfromClient.setTaskPriority(taskfromClient.getTaskPriority());
			} else {
				TaskStatus statusToDb = taskStatusRepository.getOne(taskfromClient.getTaskPriority().getId());
			}
		}

		

			taskfromDb.setDueDate(taskfromClient.getDueDate());
			taskfromDb.setGuid(taskfromClient.getGuid());
			taskfromDb.setVerifiedOn(taskfromClient.getVerifiedOn());

			if (taskfromClient.getPhaseFk() != null) {
				if (taskfromClient.getPhaseFk().getId() == 0) {
					taskfromClient.setPhaseFk(taskfromClient.getPhaseFk());
				} else {
					Phase phaseToDb = phaseRepository.getOne(taskfromClient.getPhaseFk().getId());
				}
			}

			taskfromDb.setDescription(taskfromClient.getDescription());
			taskfromDb.setAccountAddress(taskfromClient.getAccountAddress());

			for (Documents documents : taskfromClient.getDocuments()) {
				if (documents.getId() == 0) {
					documents.setTaskFk(taskfromDb);
				} else {
					Documents docFrmDb = documentRepository.getOne(documents.getId());
					// docFrmDb.setDocu(projectFromClient.getDocuments());
				}
			}

			for (TaskComment comment : taskfromClient.getTaskComments()) {
				if (comment.getId() == 0) {
					comment.setTask(taskfromDb);
				} else {
					TaskComment comments = taskCommentRepository.getOne(comment.getId());
					// docFrmDb.setDocu(projectFromClient.getDocuments());
				}
			}

			/*for (TaskCcUser taskCcUser : taskfromClient.getTaskFollowers()) {
				if (taskCcUser.getId() == 0) {
					taskCcUser.setTask(taskfromDb);
				} else {
					TaskCcUser users = taskCcUserRepository.getOne(taskCcUser.getId());
				}
			}*/
			taskfromDb.setEventId(taskfromClient.getEventId());
		try {
			eventImpl.updateEvent(taskfromDb);
		} catch (GeneralSecurityException | IOException e) {
			// TODO Auto-generated catch blocksetTaskUrl
			e.printStackTrace();
		}
		Task updateTask = taskRepository.save(taskfromDb);
		if (updateTask != null) {
			return updateTask;
		} else {
			return null;
		}
	}


	public List<Task> getAllTask() {
		return taskRepository.findAll();
	}
	
	public TaskComment addTaskComment(TaskComment commentsFrmClient) {
		TaskComment toDb= new TaskComment();
		if (commentsFrmClient.getTask() != null) {
			toDb.setTask(taskRepository.getOne(commentsFrmClient.getTask().getId()));
		}
		if(commentsFrmClient.getUserDetails() != null) {
			toDb.setUserDetails(userDetailsRepository.getOne(commentsFrmClient.getUserDetails().getId()));
		}
		toDb.setComment(commentsFrmClient.getComment());
		toDb.setDateTime(commentsFrmClient.getDateTime());
		taskCommentRepository.save(toDb);
		return toDb;
		
	}
	
	public TaskComment updateTaskComment(TaskComment commentsFrmClient) {
		TaskComment fDb= taskCommentRepository.getOne(commentsFrmClient.getId());
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
			}else {
				UserDetails userToDb = userDetailsRepository.getOne(commentsFrmClient.getUserDetails().getId());
			}
		}
		fDb.setComment(commentsFrmClient.getComment());
		fDb.setDateTime(commentsFrmClient.getDateTime());
		TaskComment updateComment = taskCommentRepository.save(fDb);
		if (updateComment != null) {
			return updateComment;
		} else {
			return null;
		}
	}

	public Object getTaskById(Long id) {
		Task fromDb= taskRepository.getOne(id);
		return fromDb;
	}

	public Object getTaskByCreatorUser() {
		long id= LoggedInUser.getCurrentUserId();
		return taskRepository.findById(id);
	}
	
}
