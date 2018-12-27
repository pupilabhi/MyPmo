package com.connectivity.vikray.entity;
// Generated 27 Dec, 2018 3:06:26 PM by Hibernate Tools 5.2.11.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * IndustryType generated by hbm2java
 */
@Entity
@Table(name = "INDUSTRY_TYPE", catalog = "namcrm")
public class IndustryType implements java.io.Serializable {

	private long id;
	private String description;
	private Set<AccountDetail> accountDetails = new HashSet<AccountDetail>(0);

	public IndustryType() {
	}

	public IndustryType(long id) {
		this.id = id;
	}

	public IndustryType(long id, String description, Set<AccountDetail> accountDetails) {
		this.id = id;
		this.description = description;
		this.accountDetails = accountDetails;
	}

	@Id

	@Column(name = "ID", unique = true, nullable = false)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "industryType")
	public Set<AccountDetail> getAccountDetails() {
		return this.accountDetails;
	}

	public void setAccountDetails(Set<AccountDetail> accountDetails) {
		this.accountDetails = accountDetails;
	}

}
