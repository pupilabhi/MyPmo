	package com.connectivity.vikray.entity;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "DOCUMENTS", catalog = "vikrayPmo")
//@EntityListeners(AuditingEntityListener.class)
//@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class Documents extends Auditable<String> implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1864896037038317087L;
	
	private long id;
	private String path;
	private Project projectFk;
	private Phase phaseFk;
	private Task taskFk;
	
//	private Date createdAt;
//	private Date updatedAt;
	
	public Documents() {
		
	}
	
	public Documents(long id) {
		this.id= id;
	}

	

	public Documents(long id, String path, Project projectFk, Phase phaseFk, Task taskFk) {
		super();
		this.id = id;
		this.path = path;
		this.projectFk = projectFk;
		this.phaseFk = phaseFk;
		this.taskFk = taskFk;
	}

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
	@JsonBackReference
	public Project getProjectFk() {
		return projectFk;
	}

	public void setProjectFk(Project projectFk) {
		this.projectFk = projectFk;
	}

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "phaseFk")
	@JsonBackReference(value="phase_ref")
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

/*	@Column(nullable = true, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Column(nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
*/	
	
	
}
