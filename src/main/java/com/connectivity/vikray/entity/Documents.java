package com.connectivity.vikray.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
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
@Table(name = "PHASE", catalog = "namcrm")
public class Documents implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1864896037038317087L;
	private long id;
	private String path;
	private Project projectFk;
//	private CrmType crmTypeFk;
	private Phase phaseFk;
	private Task taskFk;
	
	public Documents() {
		
	}
	
	public Documents(long id) {
		this.id= id;
	}

	

	public Documents(long id, String path, Project projectFk, /*CrmType crmTypeFk,*/ Phase phaseFk, Task taskFk) {
		super();
		this.id = id;
		this.path = path;
		this.projectFk = projectFk;
	//	this.crmTypeFk = crmTypeFk;
		this.phaseFk = phaseFk;
		this.taskFk = taskFk;
	}

/*	public CrmType getCrmTypeFk() {
		return crmTypeFk;
	}

	public void setCrmTypeFk(CrmType crmTypeFk) {
		this.crmTypeFk = crmTypeFk;
	}*/

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "project_Fk")
	public Project getProjectFk() {
		return projectFk;
	}

	public void setProjectFk(Project projectFk) {
		this.projectFk = projectFk;
	}

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "phaseFk")
	public Phase getPhaseFk() {
		return phaseFk;
	}

	public void setPhaseFk(Phase phaseFk) {
		this.phaseFk = phaseFk;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TASK_FK")
	public Task getTaskFk() {
		return taskFk;
	}
	
	public void setTaskFk(Task taskFk) {
		this.taskFk = taskFk;
	}
	
}
