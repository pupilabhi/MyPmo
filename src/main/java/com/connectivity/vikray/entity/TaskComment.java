package com.connectivity.vikray.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * 
 */
@Entity
@Table(name = "TASK_COMMENT")
public class TaskComment implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private Task task;
	private UserDetails userDetails;
	private String comment;
	private long dateTime;
	

	public TaskComment() {
	}

	public TaskComment(long id, long dateTime) {
		this.id = id;
		this.dateTime = dateTime;
	}

	public TaskComment(long id, Task task, UserDetails userDetails, String comment, long dateTime) {
		super();
		this.id = id;
		this.task = task;
		this.userDetails = userDetails;
		this.comment = comment;
		this.dateTime = dateTime;
	}

	@Id
	@Column(name = "ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TASK_FK")
	@JsonBackReference(value="t_ref")
	public Task getTask() {
		return this.task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_FK")
	@JsonBackReference(value="u_ref")
	public UserDetails getUserDetails() {
		return this.userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	@Column(name = "COMMENT", length = 16777215)
	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Column(name = "DATE_TIME", nullable = false)
	public long getDateTime() {
		return this.dateTime;
	}

	public void setDateTime(long dateTime) {
		this.dateTime = dateTime;
	}


}
