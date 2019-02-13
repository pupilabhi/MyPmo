	package com.connectivity.vikray.entity;

import java.io.Serializable;

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

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "DOCUMENTS", catalog = "vikrayPmo")
@EntityListeners(AuditingEntityListener.class)
public class Documents extends Auditable<Long> implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1864896037038317087L;
	
	private long id;
	private String path;
	private Project projectFk;
	private Phase phaseFk;
	private Task taskFk;
	private String docType;
	
	
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

	@Column(name = "doc_type")
	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	
	
	
}
