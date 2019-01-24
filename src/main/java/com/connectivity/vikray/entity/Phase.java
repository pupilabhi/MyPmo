package com.connectivity.vikray.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


// New Entity class added for vikray-PMO by Pawan @18-01-2019
@Entity
@Table(name = "PHASE", catalog = "vikrayPmo")
@JsonIgnoreProperties(
        value = {"createdAt", "updatedAt"},
        allowGetters = true
)
public class Phase {
	
	private long id;
	private Date createdBy;
	private Date updatedBy;
	private Date dueDate;
	private Project projectFk;
	private UserDetails userDetailsFk;
	//private AccountAddress accountAddressFk;
	private String accountAddress;
	private Set<Documents> documents= new HashSet<Documents>(0);
	private Set<PhaseFollower> phaseFollowers= new HashSet<PhaseFollower>(0);
	private Set<Task> tasks= new HashSet<Task>(0);
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date")
	private Date createDate;
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modify_date")
	private Date modifyDate;

	 public Phase() {
	 
	 }
	 
	 public Phase(long id) {
		 this.id= id;
	 }

	public Phase(long id, Date createdBy, Date updatedBy, Date dueDate, Project projectFk, UserDetails userDetailsFk,
			String accountAddress, Set<Documents> documents, Set<PhaseFollower> phaseFollowers, Set<Task> tasks,
			Date createDate, Date modifyDate) {
		super();
		this.id = id;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.dueDate = dueDate;
		this.projectFk = projectFk;
		this.userDetailsFk = userDetailsFk;
		this.accountAddress = accountAddress;
		this.documents = documents;
		this.phaseFollowers = phaseFollowers;
		this.tasks = tasks;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Date createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Date updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROJECT_FK")
	public Project getProjectFk() {
		return projectFk;
	}

	public void setProjectFk(Project projectFk) {
		this.projectFk = projectFk;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_DETAILS_FK")
	public UserDetails getUserDetailsFk() {
		return userDetailsFk;
	}

	public void setUserDetailsFk(UserDetails userDetailsFk) {
		this.userDetailsFk = userDetailsFk;
	}

/*	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACCOUNT_ADDRESS_FK")
	public AccountAddress getAccountAddressFk() {
		return accountAddressFk;
	}

	public void setAccountAddressFk(AccountAddress accountAddressFk) {
		this.accountAddressFk = accountAddressFk;
	}*/
	
	
	@Column(name="ACCOUNT_ADDRESS")
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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	
}
