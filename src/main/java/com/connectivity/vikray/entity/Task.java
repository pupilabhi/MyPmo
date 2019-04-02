package com.connectivity.vikray.entity;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * 
 */
@Entity
@Table(name = "TASK", catalog = "vikrayPmo")
@EntityListeners(AuditingEntityListener.class)
public class Task extends Auditable<Long> implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;
	private String taskName;
	private String description;
	private TaskPriority taskPriority;
	private UserDetails assignee;
	private Date dueDate;
	private Date completedOn;
	private Date verifiedOn;
	private UserDetails verifiedBy;
	private Phase phaseFk;
	private String accountAddress;
	private Set<Documents> documents = new HashSet<Documents>(0);
	private List<TaskComment> taskComments = new ArrayList<TaskComment>(0);
	private Set<TaskFollower> taskFollowers = new HashSet<TaskFollower>(0);
	private Domain domain;
	private String eventId;
	private String guid;
	private TaskStatus currentStatus;
	

	
	public Task() {
	}

	public Task(long id) {
		this.id = id;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}


	public String getAccountAddress() {
		return accountAddress;
	}

	public void setAccountAddress(String accountAddress) {
		this.accountAddress = accountAddress;
	}


	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DOMAIN_FK")
	@JsonBackReference(value = "domain_ref")
	public Domain getDomain() {
		return this.domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TASK_PRIORITY_FK")
	public TaskPriority getTaskPriority() {
		return this.taskPriority;
	}

	public void setTaskPriority(TaskPriority taskPriority) {
		this.taskPriority = taskPriority;
	}

	


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DUE_DATE", length = 19)
	public Date getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	@Column(name = "GUID")
	public String getGuid() {
		return this.guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	@Column(name = "TASK_NAME")
	public String getTaskName() {
		return this.taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "VERIFIED_ON", length = 19)
	public Date getVerifiedOn() {
		return this.verifiedOn;
	}

	public void setVerifiedOn(Date verifiedOn) {
		this.verifiedOn = verifiedOn;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "task")
	public List<TaskComment> getTaskComments() {
		return this.taskComments;
	}

	public void setTaskComments(List<TaskComment> taskComments) {
		this.taskComments = taskComments;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "taskFk")
	public Set<Documents> getDocuments() {
		return documents;
	}

	public void setDocuments(Set<Documents> documents) {
		this.documents = documents;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "Phase_FK")
	@JsonBackReference(value = "phase_ref")
	public Phase getPhaseFk() {
		return phaseFk;
	}

	public void setPhaseFk(Phase phaseFk) {
		this.phaseFk = phaseFk;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getEventId() {
		return eventId;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "assignee_fk")
	public UserDetails getAssignee() {
		return assignee;
	}

	public void setAssignee(UserDetails assignee) {
		this.assignee = assignee;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "completed_on")
	public Date getCompletedOn() {
		return completedOn;
	}

	public void setCompletedOn(Date completedOn) {
		this.completedOn = completedOn;
	}

	
	@OneToMany(mappedBy = "task" , fetch = FetchType.LAZY)
	public Set<TaskFollower> getTaskFollowers() {
		return taskFollowers;
	}

	public void setTaskFollowers(Set<TaskFollower> taskFollowers) {
		this.taskFollowers = taskFollowers;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "verified_by")
	public UserDetails getVerifiedBy() {
		return verifiedBy;
	}

	public void setVerifiedBy(UserDetails verifiedBy) {
		this.verifiedBy = verifiedBy;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "current_status_fk")
	public TaskStatus getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(TaskStatus currentStatus) {
		this.currentStatus = currentStatus;
	}
	
	
	
}
