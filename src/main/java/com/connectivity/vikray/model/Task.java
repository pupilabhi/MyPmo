package com.connectivity.vikray.model;
// Generated 6 Dec, 2018 11:37:25 AM by Hibernate Tools 5.2.11.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Task generated by hbm2java
 */
@Entity
@Table(name = "TASK", catalog = "namcrm")
public class Task implements java.io.Serializable {

	private long id;
	private BusinessDeal businessDeal;
	private Domain domain;
	private TaskPriority taskPriority;
	private TaskStatus taskStatus;
	private UserDetails userDetailsByCreatorUserFk;
	private UserDetails userDetailsByAssigneeUserFk;
	private Date completedOn;
	private Date createdOn;
	private Date dueDate;
	private String guid;
	private Date lastUpdatedOn;
	private String taskName;
	private String taskUrl;
	private Date verifiedOn;

	public Task() {
	}

	public Task(long id) {
		this.id = id;
	}

	public Task(long id, BusinessDeal businessDeal, Domain domain, TaskPriority taskPriority, TaskStatus taskStatus,
			UserDetails userDetailsByCreatorUserFk, UserDetails userDetailsByAssigneeUserFk, Date completedOn,
			Date createdOn, Date dueDate, String guid, Date lastUpdatedOn, String taskName, String taskUrl,
			Date verifiedOn) {
		this.id = id;
		this.businessDeal = businessDeal;
		this.domain = domain;
		this.taskPriority = taskPriority;
		this.taskStatus = taskStatus;
		this.userDetailsByCreatorUserFk = userDetailsByCreatorUserFk;
		this.userDetailsByAssigneeUserFk = userDetailsByAssigneeUserFk;
		this.completedOn = completedOn;
		this.createdOn = createdOn;
		this.dueDate = dueDate;
		this.guid = guid;
		this.lastUpdatedOn = lastUpdatedOn;
		this.taskName = taskName;
		this.taskUrl = taskUrl;
		this.verifiedOn = verifiedOn;
	}

	@Id

	@Column(name = "ID", unique = true, nullable = false)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DEAL_FK")
	public BusinessDeal getBusinessDeal() {
		return this.businessDeal;
	}

	public void setBusinessDeal(BusinessDeal businessDeal) {
		this.businessDeal = businessDeal;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DOMAIN_FK")
	public Domain getDomain() {
		return this.domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TASK_PRIORITY_FK")
	public TaskPriority getTaskPriority() {
		return this.taskPriority;
	}

	public void setTaskPriority(TaskPriority taskPriority) {
		this.taskPriority = taskPriority;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TASK_STATUS_FK")
	public TaskStatus getTaskStatus() {
		return this.taskStatus;
	}

	public void setTaskStatus(TaskStatus taskStatus) {
		this.taskStatus = taskStatus;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CREATOR_USER_FK")
	public UserDetails getUserDetailsByCreatorUserFk() {
		return this.userDetailsByCreatorUserFk;
	}

	public void setUserDetailsByCreatorUserFk(UserDetails userDetailsByCreatorUserFk) {
		this.userDetailsByCreatorUserFk = userDetailsByCreatorUserFk;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ASSIGNEE_USER_FK")
	public UserDetails getUserDetailsByAssigneeUserFk() {
		return this.userDetailsByAssigneeUserFk;
	}

	public void setUserDetailsByAssigneeUserFk(UserDetails userDetailsByAssigneeUserFk) {
		this.userDetailsByAssigneeUserFk = userDetailsByAssigneeUserFk;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "COMPLETED_ON", length = 19)
	public Date getCompletedOn() {
		return this.completedOn;
	}

	public void setCompletedOn(Date completedOn) {
		this.completedOn = completedOn;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_ON", length = 19)
	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_UPDATED_ON", length = 19)
	public Date getLastUpdatedOn() {
		return this.lastUpdatedOn;
	}

	public void setLastUpdatedOn(Date lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}

	@Column(name = "TASK_NAME")
	public String getTaskName() {
		return this.taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	@Column(name = "TASK_URL")
	public String getTaskUrl() {
		return this.taskUrl;
	}

	public void setTaskUrl(String taskUrl) {
		this.taskUrl = taskUrl;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "VERIFIED_ON", length = 19)
	public Date getVerifiedOn() {
		return this.verifiedOn;
	}

	public void setVerifiedOn(Date verifiedOn) {
		this.verifiedOn = verifiedOn;
	}

}
