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
 * InventoryItem generated by hbm2java
 */
@Entity
@Table(name = "INVENTORY_ITEM", catalog = "namcrm")
public class InventoryItem implements java.io.Serializable {

	private long id;
	private Domain domain;
	private InventoryType inventoryType;
	private Product product;
	private UserDetails userDetailsByCreatedByUserFk;
	private UserDetails userDetailsByLastModifiedByUserFk;
	private Warehouse warehouse;
	private Date createdDate;
	private String guid;
	private Date lastModifiedDate;
	private int quantity;
	private double unitPrice;
	private String uom;
	private int mitquantity;
	private String itemname;
	private int reservedquantity;
	private String slNo;
	private double totalPrice;
	private String itemdescription;
	private Set<DeliveryChallanItem> deliveryChallanItems = new HashSet<DeliveryChallanItem>(0);
	private Set<Activity> activities = new HashSet<Activity>(0);
	private Set<ReserveActivity> reserveActivities = new HashSet<ReserveActivity>(0);
	private Set<OrderItem> orderItems = new HashSet<OrderItem>(0);
	private Set<InvoiceHistory> invoiceHistories = new HashSet<InvoiceHistory>(0);
	private Set<GrnItem> grnItems = new HashSet<GrnItem>(0);
	private Set<InvoiceItem> invoiceItems = new HashSet<InvoiceItem>(0);
	private Set<InventoryUniqueItem> inventoryUniqueItems = new HashSet<InventoryUniqueItem>(0);

	public InventoryItem() {
	}

	public InventoryItem(long id, int quantity, double unitPrice, int mitquantity, int reservedquantity,
			double totalPrice) {
		this.id = id;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.mitquantity = mitquantity;
		this.reservedquantity = reservedquantity;
		this.totalPrice = totalPrice;
	}

	public InventoryItem(long id, Domain domain, InventoryType inventoryType, Product product,
			UserDetails userDetailsByCreatedByUserFk, UserDetails userDetailsByLastModifiedByUserFk,
			Warehouse warehouse, Date createdDate, String guid, Date lastModifiedDate, int quantity, double unitPrice,
			String uom, int mitquantity, String itemname, int reservedquantity, String slNo, double totalPrice,
			String itemdescription, Set<DeliveryChallanItem> deliveryChallanItems, Set<Activity> activities,
			Set<ReserveActivity> reserveActivities, Set<OrderItem> orderItems, Set<InvoiceHistory> invoiceHistories,
			Set<GrnItem> grnItems, Set<InvoiceItem> invoiceItems, Set<InventoryUniqueItem> inventoryUniqueItems) {
		this.id = id;
		this.domain = domain;
		this.inventoryType = inventoryType;
		this.product = product;
		this.userDetailsByCreatedByUserFk = userDetailsByCreatedByUserFk;
		this.userDetailsByLastModifiedByUserFk = userDetailsByLastModifiedByUserFk;
		this.warehouse = warehouse;
		this.createdDate = createdDate;
		this.guid = guid;
		this.lastModifiedDate = lastModifiedDate;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.uom = uom;
		this.mitquantity = mitquantity;
		this.itemname = itemname;
		this.reservedquantity = reservedquantity;
		this.slNo = slNo;
		this.totalPrice = totalPrice;
		this.itemdescription = itemdescription;
		this.deliveryChallanItems = deliveryChallanItems;
		this.activities = activities;
		this.reserveActivities = reserveActivities;
		this.orderItems = orderItems;
		this.invoiceHistories = invoiceHistories;
		this.grnItems = grnItems;
		this.invoiceItems = invoiceItems;
		this.inventoryUniqueItems = inventoryUniqueItems;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "INVENTORY_TYPE_FK")
	public InventoryType getInventoryType() {
		return this.inventoryType;
	}

	public void setInventoryType(InventoryType inventoryType) {
		this.inventoryType = inventoryType;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRODUCT_FK")
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CREATED_BY_USER_FK")
	public UserDetails getUserDetailsByCreatedByUserFk() {
		return this.userDetailsByCreatedByUserFk;
	}

	public void setUserDetailsByCreatedByUserFk(UserDetails userDetailsByCreatedByUserFk) {
		this.userDetailsByCreatedByUserFk = userDetailsByCreatedByUserFk;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LAST_MODIFIED_BY_USER_FK")
	public UserDetails getUserDetailsByLastModifiedByUserFk() {
		return this.userDetailsByLastModifiedByUserFk;
	}

	public void setUserDetailsByLastModifiedByUserFk(UserDetails userDetailsByLastModifiedByUserFk) {
		this.userDetailsByLastModifiedByUserFk = userDetailsByLastModifiedByUserFk;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "WAREHOUSE_FK")
	public Warehouse getWarehouse() {
		return this.warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE", length = 19)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "GUID")
	public String getGuid() {
		return this.guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_MODIFIED_DATE", length = 19)
	public Date getLastModifiedDate() {
		return this.lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	@Column(name = "QUANTITY", nullable = false)
	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Column(name = "UNIT_PRICE", nullable = false, precision = 22, scale = 0)
	public double getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Column(name = "UOM")
	public String getUom() {
		return this.uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	@Column(name = "MITQUANTITY", nullable = false)
	public int getMitquantity() {
		return this.mitquantity;
	}

	public void setMitquantity(int mitquantity) {
		this.mitquantity = mitquantity;
	}

	@Column(name = "ITEMNAME")
	public String getItemname() {
		return this.itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	@Column(name = "RESERVEDQUANTITY", nullable = false)
	public int getReservedquantity() {
		return this.reservedquantity;
	}

	public void setReservedquantity(int reservedquantity) {
		this.reservedquantity = reservedquantity;
	}

	@Column(name = "SL_NO")
	public String getSlNo() {
		return this.slNo;
	}

	public void setSlNo(String slNo) {
		this.slNo = slNo;
	}

	@Column(name = "TOTAL_PRICE", nullable = false, precision = 22, scale = 0)
	public double getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Column(name = "ITEMDESCRIPTION", length = 16777215)
	public String getItemdescription() {
		return this.itemdescription;
	}

	public void setItemdescription(String itemdescription) {
		this.itemdescription = itemdescription;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "inventoryItem")
	public Set<DeliveryChallanItem> getDeliveryChallanItems() {
		return this.deliveryChallanItems;
	}

	public void setDeliveryChallanItems(Set<DeliveryChallanItem> deliveryChallanItems) {
		this.deliveryChallanItems = deliveryChallanItems;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "inventoryItem")
	public Set<Activity> getActivities() {
		return this.activities;
	}

	public void setActivities(Set<Activity> activities) {
		this.activities = activities;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "inventoryItem")
	public Set<ReserveActivity> getReserveActivities() {
		return this.reserveActivities;
	}

	public void setReserveActivities(Set<ReserveActivity> reserveActivities) {
		this.reserveActivities = reserveActivities;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "inventoryItem")
	public Set<OrderItem> getOrderItems() {
		return this.orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "inventoryItem")
	public Set<InvoiceHistory> getInvoiceHistories() {
		return this.invoiceHistories;
	}

	public void setInvoiceHistories(Set<InvoiceHistory> invoiceHistories) {
		this.invoiceHistories = invoiceHistories;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "inventoryItem")
	public Set<GrnItem> getGrnItems() {
		return this.grnItems;
	}

	public void setGrnItems(Set<GrnItem> grnItems) {
		this.grnItems = grnItems;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "inventoryItem")
	public Set<InvoiceItem> getInvoiceItems() {
		return this.invoiceItems;
	}

	public void setInvoiceItems(Set<InvoiceItem> invoiceItems) {
		this.invoiceItems = invoiceItems;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "inventoryItem")
	public Set<InventoryUniqueItem> getInventoryUniqueItems() {
		return this.inventoryUniqueItems;
	}

	public void setInventoryUniqueItems(Set<InventoryUniqueItem> inventoryUniqueItems) {
		this.inventoryUniqueItems = inventoryUniqueItems;
	}

}
