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
 * GrnHeader generated by hbm2java
 */
@Entity
@Table(name = "GRN_HEADER", catalog = "namcrm")
public class GrnHeader implements java.io.Serializable {

	private long id;
	private AccountDetail accountDetailByVendorFk;
	private AccountDetail accountDetailByCustomerFk;
	private CrmType crmType;
	private Domain domain;
	private Organisation organisation;
	private PersonDetail personDetail;
	private PurchaseOrderHeader purchaseOrderHeader;
	private StatusItem statusItem;
	private UserDetails userDetailsByCreatedByUserFk;
	private UserDetails userDetailsByLastModifiedByUserFk;
	private Date createdDate;
	private Double freightInferred;
	private String grnName;
	private String guid;
	private Date lastModifiedDate;
	private Double miscellaneousAmount;
	private Date vendorInvoiceDate;
	private String vendorInvoiceNo;
	private String remarks;
	private boolean recurring;
	private Set<GrnItem> grnItems = new HashSet<GrnItem>(0);
	private Set<Payable> payables = new HashSet<Payable>(0);
	private Set<Activity> activities = new HashSet<Activity>(0);
	private Set<PurchaseEntry> purchaseEntries = new HashSet<PurchaseEntry>(0);

	public GrnHeader() {
	}

	public GrnHeader(long id, boolean recurring) {
		this.id = id;
		this.recurring = recurring;
	}

	public GrnHeader(long id, AccountDetail accountDetailByVendorFk, AccountDetail accountDetailByCustomerFk,
			CrmType crmType, Domain domain, Organisation organisation, PersonDetail personDetail,
			PurchaseOrderHeader purchaseOrderHeader, StatusItem statusItem, UserDetails userDetailsByCreatedByUserFk,
			UserDetails userDetailsByLastModifiedByUserFk, Date createdDate, Double freightInferred, String grnName,
			String guid, Date lastModifiedDate, Double miscellaneousAmount, Date vendorInvoiceDate,
			String vendorInvoiceNo, String remarks, boolean recurring, Set<GrnItem> grnItems, Set<Payable> payables,
			Set<Activity> activities, Set<PurchaseEntry> purchaseEntries) {
		this.id = id;
		this.accountDetailByVendorFk = accountDetailByVendorFk;
		this.accountDetailByCustomerFk = accountDetailByCustomerFk;
		this.crmType = crmType;
		this.domain = domain;
		this.organisation = organisation;
		this.personDetail = personDetail;
		this.purchaseOrderHeader = purchaseOrderHeader;
		this.statusItem = statusItem;
		this.userDetailsByCreatedByUserFk = userDetailsByCreatedByUserFk;
		this.userDetailsByLastModifiedByUserFk = userDetailsByLastModifiedByUserFk;
		this.createdDate = createdDate;
		this.freightInferred = freightInferred;
		this.grnName = grnName;
		this.guid = guid;
		this.lastModifiedDate = lastModifiedDate;
		this.miscellaneousAmount = miscellaneousAmount;
		this.vendorInvoiceDate = vendorInvoiceDate;
		this.vendorInvoiceNo = vendorInvoiceNo;
		this.remarks = remarks;
		this.recurring = recurring;
		this.grnItems = grnItems;
		this.payables = payables;
		this.activities = activities;
		this.purchaseEntries = purchaseEntries;
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
	@JoinColumn(name = "VENDOR_FK")
	public AccountDetail getAccountDetailByVendorFk() {
		return this.accountDetailByVendorFk;
	}

	public void setAccountDetailByVendorFk(AccountDetail accountDetailByVendorFk) {
		this.accountDetailByVendorFk = accountDetailByVendorFk;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CUSTOMER_FK")
	public AccountDetail getAccountDetailByCustomerFk() {
		return this.accountDetailByCustomerFk;
	}

	public void setAccountDetailByCustomerFk(AccountDetail accountDetailByCustomerFk) {
		this.accountDetailByCustomerFk = accountDetailByCustomerFk;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GRN_TYPE_FK")
	public CrmType getCrmType() {
		return this.crmType;
	}

	public void setCrmType(CrmType crmType) {
		this.crmType = crmType;
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
	@JoinColumn(name = "ORG_FK")
	public Organisation getOrganisation() {
		return this.organisation;
	}

	public void setOrganisation(Organisation organisation) {
		this.organisation = organisation;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VENDOR_CONTACT_FK")
	public PersonDetail getPersonDetail() {
		return this.personDetail;
	}

	public void setPersonDetail(PersonDetail personDetail) {
		this.personDetail = personDetail;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PO_FK")
	public PurchaseOrderHeader getPurchaseOrderHeader() {
		return this.purchaseOrderHeader;
	}

	public void setPurchaseOrderHeader(PurchaseOrderHeader purchaseOrderHeader) {
		this.purchaseOrderHeader = purchaseOrderHeader;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STATUS_FK")
	public StatusItem getStatusItem() {
		return this.statusItem;
	}

	public void setStatusItem(StatusItem statusItem) {
		this.statusItem = statusItem;
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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE", length = 19)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "FREIGHT_INFERRED", precision = 22, scale = 0)
	public Double getFreightInferred() {
		return this.freightInferred;
	}

	public void setFreightInferred(Double freightInferred) {
		this.freightInferred = freightInferred;
	}

	@Column(name = "GRN_NAME")
	public String getGrnName() {
		return this.grnName;
	}

	public void setGrnName(String grnName) {
		this.grnName = grnName;
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

	@Column(name = "MISCELLANEOUS_AMOUNT", precision = 22, scale = 0)
	public Double getMiscellaneousAmount() {
		return this.miscellaneousAmount;
	}

	public void setMiscellaneousAmount(Double miscellaneousAmount) {
		this.miscellaneousAmount = miscellaneousAmount;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "VENDOR_INVOICE_DATE", length = 19)
	public Date getVendorInvoiceDate() {
		return this.vendorInvoiceDate;
	}

	public void setVendorInvoiceDate(Date vendorInvoiceDate) {
		this.vendorInvoiceDate = vendorInvoiceDate;
	}

	@Column(name = "VENDOR_INVOICE_NO")
	public String getVendorInvoiceNo() {
		return this.vendorInvoiceNo;
	}

	public void setVendorInvoiceNo(String vendorInvoiceNo) {
		this.vendorInvoiceNo = vendorInvoiceNo;
	}

	@Column(name = "REMARKS", length = 65535)
	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Column(name = "RECURRING", nullable = false)
	public boolean isRecurring() {
		return this.recurring;
	}

	public void setRecurring(boolean recurring) {
		this.recurring = recurring;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "grnHeader")
	public Set<GrnItem> getGrnItems() {
		return this.grnItems;
	}

	public void setGrnItems(Set<GrnItem> grnItems) {
		this.grnItems = grnItems;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "grnHeader")
	public Set<Payable> getPayables() {
		return this.payables;
	}

	public void setPayables(Set<Payable> payables) {
		this.payables = payables;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "grnHeader")
	public Set<Activity> getActivities() {
		return this.activities;
	}

	public void setActivities(Set<Activity> activities) {
		this.activities = activities;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "grnHeader")
	public Set<PurchaseEntry> getPurchaseEntries() {
		return this.purchaseEntries;
	}

	public void setPurchaseEntries(Set<PurchaseEntry> purchaseEntries) {
		this.purchaseEntries = purchaseEntries;
	}

}
