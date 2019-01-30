package com.connectivity.vikray.entity;

import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


// New Entity class added for vikray-PMO by Pawan @18-01-2019
@Entity
@Table(name = "PHASE", catalog = "vikrayPmo")
@JsonIgnoreProperties(
        value = {"createDate", "modifyon"},
        allowGetters = true
)
public class Phase implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private String phaseName;
	private UserDetails createdByFk;
	private UserDetails updatedByFk;
	private Date dueDate;
	private Project projectFk;
	private UserDetails userDetailsFk;
	//private AccountAddress accountAddressFk;
	private String accountAddress;
	private Set<Documents> documents= new HashSet<Documents>(0);
	private Set<PhaseFollower> phaseFollowers= new HashSet<PhaseFollower>(0);
	private Set<Task> tasks= new HashSet<Task>(0);
	
	@Column(name = "create_date", nullable = false, updatable = false) 
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createDate;
	
	@Column(name = "modify_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date modifyDate;

	 public Phase() {
	 
	 }
	 
	 public Phase(long id) {
		 this.id= id;
	 }

	public Phase(long id, String phaseName, UserDetails createdByFk, UserDetails updatedByFk, Date dueDate,
			Project projectFk, UserDetails userDetailsFk, String accountAddress, Set<Documents> documents,
			Set<PhaseFollower> phaseFollowers, Set<Task> tasks, Date createDate, Date modifyDate) {
		super();
		this.id = id;
		this.phaseName = phaseName;
		this.createdByFk = createdByFk;
		this.updatedByFk = updatedByFk;
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

	public void setPhaseName(String phaseName) {
		this.phaseName = phaseName;
	}
	
	@Column(name="PHASE_NAME")
	public String getPhaseName() {
		return phaseName;
	}
	
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name= "CREATED_BYFK")
	public UserDetails getCreatedByFk() {
		return createdByFk;
	}

	public void setCreatedByFk(UserDetails createdByFk) {
		this.createdByFk = createdByFk;
	}

	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name= "UPDATED_BYFK")
	public UserDetails getUpdatedByFk() {
		return updatedByFk;
	}

	public void setUpdatedByFk(UserDetails updatedByFk) {
		this.updatedByFk = updatedByFk;
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
	@JsonBackReference(value="project_ref")
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
