package com.connectivity.vikray.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//New Entity class added for vikray-PMO by Pawan @18-01-2019
@Entity
@Table(name = "PROJECT", catalog = "vikrayPmo")
@JsonIgnoreProperties(
        value = {"createDate", "modifyDate"},
        allowGetters = true
)
public class Project implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5189170718926722438L;
	
	private long id;
	private String projectName;
	private String projectDescription;
	private UserDetails createdByFk;
	private UserDetails updatedByFk;
	private Date dueDate;
	/*private AccountAddress accountAddressFk;
	private SalesOrderHeader salesOrderHeaderFk;*/
	private String accountAddress;
	private String salesOrder;
	private UserDetails userDetailsFk;
	private Set<ProjectFollower> projectFollowers= new HashSet<ProjectFollower>(0);
	private Set<Phase> phases= new HashSet<Phase>(0);
	private Set<Documents> documents= new HashSet<Documents>(0);
	//private StatusItem projectStatus;
	
	@Column(name = "create_date", nullable = false, updatable = false) 
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createDate;
	
	@Column(name = "modify_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date modifyDate;

	public Project() {
		
	}

	public Project(long id) {
		this.id= id;
	}
	
	public Project(long id, String projectName, String projectDescription, UserDetails createdByFk,
			UserDetails updatedByFk, Date dueDate, String accountAddress, String salesOrder, UserDetails userDetailsFk,
			Set<ProjectFollower> projectFollowers, Set<Phase> phases, Set<Documents> documents, Date createDate,
			Date modifyDate) {
		super();
		this.id = id;
		this.projectName = projectName;
		this.projectDescription = projectDescription;
		this.createdByFk = createdByFk;
		this.updatedByFk = updatedByFk;
		this.dueDate = dueDate;
		this.accountAddress = accountAddress;
		this.salesOrder = salesOrder;
		this.userDetailsFk = userDetailsFk;
		this.projectFollowers = projectFollowers;
		this.phases = phases;
		this.documents = documents;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
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

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DUE_DATE", length = 19)
	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACCOUNT_ADDRESS_FK")
	public AccountAddress getAccountAddressFk() {
		return accountAddressFk;
	}

	public void setAccountAddressFk(AccountAddress accountAddressFk) {
		this.accountAddressFk = accountAddressFk;
	}*/
	
	public String getAccountAddress() {
		return accountAddress;
	}
	
	public void setAccountAddress(String accountAddress) {
		this.accountAddress = accountAddress;
	}

	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SALES_ORDER_FK")
	public SalesOrderHeader getSalesOrderHeaderFk() {
		return salesOrderHeaderFk;
	}

	public void setSalesOrderHeaderFk(SalesOrderHeader salesOrderHeaderFk) {
		this.salesOrderHeaderFk = salesOrderHeaderFk;
	}*/
	
	public String getSalesOrder() {
		return salesOrder;
	}
	
	public void setSalesOrder(String salesOrder) {
		this.salesOrder = salesOrder;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_DETAILS_FK")
	public UserDetails getUserDetailsFk() {
		return userDetailsFk;
	}

	public void setUserDetailsFk(UserDetails userDetailsFk) {
		this.userDetailsFk = userDetailsFk;
	}
    
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "project")
	public Set<ProjectFollower> getProjectFollowers() {
		return projectFollowers;
	}

	public void setProjectFollowers(Set<ProjectFollower> projectFollowers) {
		this.projectFollowers = projectFollowers;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "projectFk")
	public Set<Phase> getPhases() {
		return phases;
	}

	public void setPhases(Set<Phase> phases) {
		this.phases = phases;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "projectFk")
	public Set<Documents> getDocuments() {
		return documents;
	}

	public void setDocuments(Set<Documents> documents) {
		this.documents = documents;
	}

	
/*	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "project_status")
	public StatusItem getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(StatusItem projectStatus) {
		this.projectStatus = projectStatus;
	}*/

	
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
