package com.connectivity.vikray.serviceImpl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.connectivity.vikray.entity.Documents;
import com.connectivity.vikray.entity.Domain;
import com.connectivity.vikray.entity.Phase;
import com.connectivity.vikray.entity.Task;
import com.connectivity.vikray.entity.TaskCcUser;
import com.connectivity.vikray.entity.TaskComment;
import com.connectivity.vikray.entity.TaskPriority;
import com.connectivity.vikray.entity.TaskStatus;
import com.connectivity.vikray.entity.UserDetails;
import com.connectivity.vikray.pojo.ValidResult;
import com.connectivity.vikray.repository.DocumentRepository;
import com.connectivity.vikray.repository.DomainRepository;
import com.connectivity.vikray.repository.PhaseRepository;
import com.connectivity.vikray.repository.TaskCcUserRepository;
import com.connectivity.vikray.repository.TaskCommentRepository;
import com.connectivity.vikray.repository.TaskPriorityRepository;
import com.connectivity.vikray.repository.TaskRepository;
import com.connectivity.vikray.repository.TaskStatusRepository;
import com.connectivity.vikray.repository.UserDetailsRepository;

@Repository
public class TaskServiceImpl {

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
	TaskCcUserRepository taskCcUserRepository;

	@Autowired
	TaskStatusRepository taskStatusRepository;

	// create Task
	public Task createTask(Task taskfrmclint) {
		Task tdob = new Task();
		tdob.setComments(taskfrmclint.getComments());
		tdob.setReplies(taskfrmclint.getReplies());
		if (taskfrmclint.getDomain() != null) {
			tdob.setDomain(domainRepository.getOne(taskfrmclint.getDomain().getId()));
		}

		if (taskfrmclint.getTaskPriority() != null) {
			tdob.setTaskPriority(taskPriorityRepository.getOne(taskfrmclint.getTaskPriority().getId()));
		}

		if (taskfrmclint.getUserDetailsByAssigneeUserFk() != null) {
			tdob.setUserDetailsByAssigneeUserFk(
					userDetailsRepository.getOne(taskfrmclint.getUserDetailsByAssigneeUserFk().getExpertise()));
		}
		if (taskfrmclint.getUserDetailsByCreatorUserFk() != null) {
			tdob.setUserDetailsByCreatorUserFk(
					userDetailsRepository.getOne(taskfrmclint.getUserDetailsByCreatorUserFk().getId()));
		}
		tdob.setDueDate(taskfrmclint.getDueDate());
		tdob.setGuid(taskfrmclint.getGuid());
		tdob.setTaskName(taskfrmclint.getTaskName());
		tdob.setTaskUrl(taskfrmclint.getTaskUrl());
		tdob.setVerifiedOn(taskfrmclint.getVerifiedOn());
		if (taskfrmclint.getPhaseFk() != null) {
			tdob.setPhaseFk(phaseRepository.getOne(taskfrmclint.getPhaseFk().getId()));
		}
		tdob.setDescription(taskfrmclint.getDescription());
		tdob.setInstruction(taskfrmclint.getInstruction());
		tdob.setAccountAddress(taskfrmclint.getAccountAddress());

		Set<Documents> docs = createDocument(taskfrmclint, tdob);
		tdob.setDocuments(docs);
		Set<TaskComment> tcomments = createTaskComments(taskfrmclint, tdob);
		tdob.setTaskComments(tcomments);
		Set<TaskCcUser> taskCcUsers = createTaskCCUser(taskfrmclint, tdob);
		tdob.setTaskCcUsers(taskCcUsers);
		return tdob;
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
	private Set<TaskCcUser> createTaskCCUser(Task taskfrmclint, Task task) {
		Set<TaskCcUser> taskCcUsers = taskfrmclint.getTaskCcUsers();
		Set<TaskCcUser> newTask = new HashSet<TaskCcUser>();
		Iterator<TaskCcUser> itr = taskCcUsers.iterator();
		while (itr.hasNext()) {
			TaskCcUser taskCcUserToDb = new TaskCcUser();
			taskCcUserToDb = itr.next();
			taskCcUserToDb.setTask(taskCcUserToDb.getTask());
			taskCcUserRepository.save(taskCcUserToDb);
			newTask.add(taskCcUserToDb);
		}
		return newTask;

	}

	public Task updateTask(Task taskfromClient) {
		Task taskfromDb = taskRepository.getOne(taskfromClient.getId());
		if (taskfromDb == null) {
			return null;
		}
		taskfromDb.setComments(taskfromClient.getComments());
		taskfromDb.setReplies(taskfromClient.getReplies());
		if (taskfromClient.getDomain() != null) {
			if (taskfromClient.getDomain().getId() == 0) {
				taskfromClient.setDomain(taskfromClient.getDomain());
			} else {
				Domain domainTodb = domainRepository.getOne(taskfromClient.getDomain().getId());
			}
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

		if (taskfromClient.getUserDetailsByAssigneeUserFk() != null) {
			if (taskfromClient.getUserDetailsByAssigneeUserFk().getId() == 0) {
				taskfromClient.setUserDetailsByAssigneeUserFk(taskfromClient.getUserDetailsByAssigneeUserFk());
			} else {
				UserDetails detailsTodb = userDetailsRepository
						.getOne(taskfromClient.getUserDetailsByAssigneeUserFk().getId());

			}

			if (taskfromClient.getUserDetailsByCreatorUserFk() != null) {
				if (taskfromClient.getUserDetailsByCreatorUserFk().getId() == 0) {
					taskfromClient.setUserDetailsByCreatorUserFk(taskfromClient.getUserDetailsByCreatorUserFk());
				} else {
					UserDetails detailsToDb = userDetailsRepository
							.getOne(taskfromClient.getUserDetailsByCreatorUserFk().getId());
				}
			}

			taskfromDb.setDueDate(taskfromClient.getDueDate());
			taskfromDb.setGuid(taskfromClient.getGuid());
			taskfromDb.setTaskUrl(taskfromClient.getTaskUrl());
			taskfromDb.setVerifiedOn(taskfromClient.getVerifiedOn());

			if (taskfromClient.getPhaseFk() != null) {
				if (taskfromClient.getPhaseFk().getId() == 0) {
					taskfromClient.setPhaseFk(taskfromClient.getPhaseFk());
				} else {
					Phase phaseToDb = phaseRepository.getOne(taskfromClient.getPhaseFk().getId());
				}
			}

			taskfromDb.setDescription(taskfromClient.getDescription());
			taskfromDb.setInstruction(taskfromClient.getInstruction());
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

			for (TaskCcUser taskCcUser : taskfromClient.getTaskCcUsers()) {
				if (taskCcUser.getId() == 0) {
					taskCcUser.setTask(taskfromDb);
				} else {
					TaskCcUser users = taskCcUserRepository.getOne(taskCcUser.getId());
				}
			}
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

}
