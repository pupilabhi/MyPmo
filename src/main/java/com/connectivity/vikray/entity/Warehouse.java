package com.connectivity.vikray.entity;
// Generated 27 Dec, 2018 3:06:26 PM by Hibernate Tools 5.2.11.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Warehouse generated by hbm2java
 */
@Entity
@Table(name = "WAREHOUSE", catalog = "namcrm")
public class Warehouse implements java.io.Serializable {

	private long id;
	private AccountDetail accountDetail;
	private Domain domain;
	private UserDetails userDetails;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String country;
	private String state;
	private String zipCode;
	private String name;
	private String description;
	private Date createdDate;
	private Set<GrnItem> grnItems = new HashSet<GrnItem>(0);
	private Set<InventoryItem> inventoryItems = new HashSet<InventoryItem>(0);

	public Warehouse() {
	}

	public Warehouse(long id) {
		this.id = id;
	}

	public Warehouse(long id, AccountDetail accountDetail, Domain domain, UserDetails userDetails, String addressLine1,
			String addressLine2, String city, String country, String state, String zipCode, String name,
			String description, Date createdDate, Set<GrnItem> grnItems, Set<InventoryItem> inventoryItems) {
		this.id = id;
		this.accountDetail = accountDetail;
		this.domain = domain;
		this.userDetails = userDetails;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.country = country;
		this.state = state;
		this.zipCode = zipCode;
		this.name = name;
		this.description = description;
		this.createdDate = createdDate;
		this.grnItems = grnItems;
		this.inventoryItems = inventoryItems;
	}

	@Id

	@Column(name = "ID", unique = true, nullable = false)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACCOUNT_FK")
	public AccountDetail getAccountDetail() {
		return this.accountDetail;
	}

	public void setAccountDetail(AccountDetail accountDetail) {
		this.accountDetail = accountDetail;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DOMAIN_FK")
	public Domain getDomain() {
		return this.domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CREATED_BY_USER_FK")
	public UserDetails getUserDetails() {
		return this.userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	@Column(name = "ADDRESS_LINE1")
	public String getAddressLine1() {
		return this.addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	@Column(name = "ADDRESS_LINE2")
	public String getAddressLine2() {
		return this.addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	@Column(name = "CITY")
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "COUNTRY")
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "STATE")
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "ZIP_CODE")
	public String getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Column(name = "NAME")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE", length = 19)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "warehouse")
	public Set<GrnItem> getGrnItems() {
		return this.grnItems;
	}

	public void setGrnItems(Set<GrnItem> grnItems) {
		this.grnItems = grnItems;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "warehouse")
	public Set<InventoryItem> getInventoryItems() {
		return this.inventoryItems;
	}

	public void setInventoryItems(Set<InventoryItem> inventoryItems) {
		this.inventoryItems = inventoryItems;
	}

}
