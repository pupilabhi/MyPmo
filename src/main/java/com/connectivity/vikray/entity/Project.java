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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PROJECT", catalog = "vikrayPmo")
@EntityListeners(AuditingEntityListener.class)
public class Project extends Auditable<Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5189170718926722438L;

	private long id;
	private String projectName;
	private String projectDescription;
	private Date dueDate;
	private String accountAddress;
	private String salesOrder;
	private UserDetails owner;
	private Set<ProjectFollower> projectFollowers = new HashSet<ProjectFollower>(0);
	private Set<Phase> phases = new HashSet<Phase>(0);
	private Set<Documents> documents = new HashSet<Documents>(0);
	private StatusItem projectStatus;
	private String guid;
	
	private String customerName;
	private String custStateName;
	private long customerId;


	public String getCustStateName() {
		return custStateName;
	}

	public void setCustStateName(String custStateName) {
		this.custStateName = custStateName;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	@Column(name = "customer_name")
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Column
	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public Project() {

	}

	public Project(long id) {
		this.id = id;
	}

	

	public Project(Project project) {
		this.projectName = project.getProjectName();
		this.projectDescription = project.getProjectDescription();
		this.dueDate = project.getDueDate();
		this.accountAddress = project.getAccountAddress();
		this.salesOrder = project.getSalesOrder();
		if(project.getOwner()!=null)
			this.owner = project.getOwner();
		this.projectFollowers = project.getProjectFollowers();
		this.phases = project.getPhases();
	}
	public Project(Project project,long id) {
		this.id = id;
		this.projectName = project.getProjectName();
		this.projectDescription = project.getProjectDescription();
		this.dueDate = project.getDueDate();
		this.accountAddress = project.getAccountAddress();
		this.salesOrder = project.getSalesOrder();
		if(project.getOwner()!=null)
			this.owner = project.getOwner();
		this.projectFollowers = project.getProjectFollowers();
		this.phases = project.getPhases();
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


	public String getAccountAddress() {
		return accountAddress;
	}

	public void setAccountAddress(String accountAddress) {
		this.accountAddress = accountAddress;
	}

	public String getSalesOrder() {
		return salesOrder;
	}

	public void setSalesOrder(String salesOrder) {
		this.salesOrder = salesOrder;
	}

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "OWNER_FK")
	public UserDetails getOwner() {
		return owner;
	}

	public void setOwner(UserDetails owner) {
		this.owner = owner;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "project",cascade= CascadeType.DETACH)
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "projectFk", cascade = CascadeType.ALL)
	public Set<Documents> getDocuments() {
		return documents;
	}

	public void setDocuments(Set<Documents> documents) {
		this.documents = documents;
	}
	
	@OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name = "project_status")
	public StatusItem getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(StatusItem projectStatus) {
		this.projectStatus = projectStatus;
	}

	
}
