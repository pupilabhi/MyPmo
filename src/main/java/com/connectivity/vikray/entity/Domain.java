package com.connectivity.vikray.entity;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * Domain Entity for tenant
 */
@Entity
@Table(name = "DOMAIN", catalog = "vikrayPmo")
@EntityListeners(AuditingEntityListener.class)
public class Domain extends Auditable<String> implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private String domainName;
	private String sparkTeamId;
	private Set<UserDetails> userDetailses = new HashSet<UserDetails>(0);
	private Set<Task> tasks = new HashSet<Task>(0);

	public Domain() {
	}

	public Domain(long id) {
		this.id = id;
	}

	public Domain(long id, String domainName, String sparkTeamId, Set<UserDetails> userDetailses, Set<Task> tasks) {
		super();
		this.id = id;
		this.domainName = domainName;
		this.sparkTeamId = sparkTeamId;
		this.userDetailses = userDetailses;
		this.tasks = tasks;
	}

	@Id

	@Column(name = "ID", unique = true, nullable = false)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "DOMAIN_NAME")
	public String getDomainName() {
		return this.domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	@Column(name = "SPARK_TEAM_ID")
	public String getSparkTeamId() {
		return this.sparkTeamId;
	}

	public void setSparkTeamId(String sparkTeamId) {
		this.sparkTeamId = sparkTeamId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "domain")
	public Set<UserDetails> getUserDetailses() {
		return this.userDetailses;
	}

	public void setUserDetailses(Set<UserDetails> userDetailses) {
		this.userDetailses = userDetailses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "domain")
	public Set<Task> getTasks() {
		return this.tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

}
