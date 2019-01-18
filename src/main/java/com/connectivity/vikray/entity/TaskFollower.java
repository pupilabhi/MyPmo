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


//New Entity class added for vikray-PMO by Pawan @18-01-2019
@Entity
@Table(name = "TASK_FOLLOWER", catalog = "namcrm")
public class TaskFollower {

	private long id;
	private Task task;
	private UserDetails userDetails;
	
	public TaskFollower() {
		
	}
	
	public TaskFollower(long id) {
		this.id= id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TASK_FK")
	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_FK")
	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	
	
}
