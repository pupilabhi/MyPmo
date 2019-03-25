package com.connectivity.vikray.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
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

@Entity
@Table(name = "PHASE", catalog = "vikrayPmo")
@EntityListeners(AuditingEntityListener.class)
public class Phase extends Auditable<Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private String phaseName;
	private Date dueDate;
	private Project projectFk;
	private String accountAddress;
	private Set<Documents> documents = new HashSet<Documents>(0);
	private Set<PhaseFollower> phaseFollowers = new HashSet<PhaseFollower>(0);
	private Set<Task> tasks = new HashSet<Task>(0);
	private StatusItem phaseStatus;
	private String guid;
	private String phaseDescription;
	
	
	
	@Column
	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public Phase() {

	}

	public Phase(long id) {
		this.id = id;
	}

	public Phase(long id, String phaseName, Date dueDate,
			Project projectFk, String accountAddress, Set<Documents> documents,
			Set<PhaseFollower> phaseFollowers, Set<Task> tasks) {
		super();
		this.id = id;
		this.phaseName = phaseName;
		this.dueDate = dueDate;
		this.projectFk = projectFk;
		this.accountAddress = accountAddress;
		this.documents = documents;
		this.phaseFollowers = phaseFollowers;
		this.tasks = tasks;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setPhaseName(String phaseName) {
		this.phaseName = phaseName;
	}

	@Column(name = "PHASE_NAME")
	public String getPhaseName() {
		return phaseName;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DUE_DATE", length = 19)
	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROJECT_FK")
	@JsonBackReference(value = "project_ref")
	public Project getProjectFk() {
		return projectFk;
	}

	public void setProjectFk(Project projectFk) {
		this.projectFk = projectFk;
	}

	@Column(name = "ACCOUNT_ADDRESS")
	public String getAccountAddress() {
		return accountAddress;
	}

	public void setAccountAddress(String accountAddress) {
		this.accountAddress = accountAddress;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "phaseFk")
	public Set<Documents> getDocuments() {
		return documents;
	}

	public void setDocuments(Set<Documents> documents) {
		this.documents = documents;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "phaseFk")
	public Set<PhaseFollower> getPhaseFollowers() {
		return phaseFollowers;
	}

	public void setPhaseFollowers(Set<PhaseFollower> phaseFollowers) {
		this.phaseFollowers = phaseFollowers;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "phaseFk")
	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "phase_status")
	public StatusItem getPhaseStatus() {
		return phaseStatus;
	}

	public void setPhaseStatus(StatusItem phaseStatus) {
		this.phaseStatus = phaseStatus;
	}

	@Column
	public String getPhaseDescription() {
		return phaseDescription;
	}

	public void setPhaseDescription(String phaseDescription) {
		this.phaseDescription = phaseDescription;
	}

	
}
