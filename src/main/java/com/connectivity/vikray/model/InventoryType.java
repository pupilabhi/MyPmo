package com.connectivity.vikray.model;
// Generated 6 Dec, 2018 11:37:25 AM by Hibernate Tools 5.2.11.Final

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

/**
 * InventoryType generated by hbm2java
 */
@Entity
@Table(name = "INVENTORY_TYPE", catalog = "namcrm")
public class InventoryType implements java.io.Serializable {

	private long id;
	private Domain domain;
	private String description;
	private String inventoryType;
	private Set<InventoryItem> inventoryItems = new HashSet<InventoryItem>(0);
	private Set<InventoryItem> inventoryItems_1 = new HashSet<InventoryItem>(0);

	public InventoryType() {
	}

	public InventoryType(long id) {
		this.id = id;
	}

	public InventoryType(long id, Domain domain, String description, String inventoryType,
			Set<InventoryItem> inventoryItems, Set<InventoryItem> inventoryItems_1) {
		this.id = id;
		this.domain = domain;
		this.description = description;
		this.inventoryType = inventoryType;
		this.inventoryItems = inventoryItems;
		this.inventoryItems_1 = inventoryItems_1;
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
	@JoinColumn(name = "DOMAIN_FK")
	public Domain getDomain() {
		return this.domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}

	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "INVENTORY_TYPE")
	public String getInventoryType() {
		return this.inventoryType;
	}

	public void setInventoryType(String inventoryType) {
		this.inventoryType = inventoryType;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "inventoryType")
	public Set<InventoryItem> getInventoryItems() {
		return this.inventoryItems;
	}

	public void setInventoryItems(Set<InventoryItem> inventoryItems) {
		this.inventoryItems = inventoryItems;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "inventoryType")
	public Set<InventoryItem> getInventoryItems_1() {
		return this.inventoryItems_1;
	}

	public void setInventoryItems_1(Set<InventoryItem> inventoryItems_1) {
		this.inventoryItems_1 = inventoryItems_1;
	}

}
