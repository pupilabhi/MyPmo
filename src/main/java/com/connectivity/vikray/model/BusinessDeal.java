package com.connectivity.vikray.model;
// Generated 6 Dec, 2018 11:37:25 AM by Hibernate Tools 5.2.11.Final

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
import javax.persistence.UniqueConstraint;

/**
 * BusinessDeal generated by hbm2java
 */
@Entity
@Table(name = "BUSINESS_DEAL", catalog = "namcrm", uniqueConstraints = @UniqueConstraint(columnNames = "DEAL_NAME"))
public class BusinessDeal implements java.io.Serializable {

	private long id;
	private AccountDetail accountDetail;
	private CrmType crmTypeByBuTypeFk;
	private CrmType crmTypeByCrmTypeFk;
	private Currency currency;
	private DealActivity dealActivity;
	private DealSource dealSource;
	private Domain domain;
	private PersonDetail personDetail;
	private QuoteHeader quoteHeader;
	private SalesOrderHeader salesOrderHeader;
	private StatusItem statusItem;
	private UserDetails userDetailsByCreatedBy;
	private UserDetails userDetailsByLastModifiedBy;
	private UserDetails userDetailsBySponsorUserFk;
	private UserDetails userDetailsByOwnerFk;
	private double convertionRate;
	private Date dateCreated;
	private String dealName;
	private double estimatedAmount;
	private String guid;
	private String remarks;
	private int lastSaleCommitWeek;
	private Date lastUpsidedOn;
	private Date lastModifiedOn;
	private String lostReason;
	private Date estimatedClosureDate;
	private long businessVerticle;
	private int lastSaleCommitYear;
	private Set<PurchaseOrderHeader> purchaseOrderHeaders = new HashSet<PurchaseOrderHeader>(0);
	private Set<Task> tasks = new HashSet<Task>(0);
	private Set<DealActivity> dealActivities = new HashSet<DealActivity>(0);
	private Set<DealActivity> dealActivities_1 = new HashSet<DealActivity>(0);
	private Set<QuoteHeader> quoteHeaders = new HashSet<QuoteHeader>(0);
	private Set<PurchaseOrderHeader> purchaseOrderHeaders_1 = new HashSet<PurchaseOrderHeader>(0);
	private Set<QuoteHeader> quoteHeaders_1 = new HashSet<QuoteHeader>(0);
	private Set<Task> tasks_1 = new HashSet<Task>(0);

	public BusinessDeal() {
	}

	public BusinessDeal(long id, double convertionRate, double estimatedAmount, int lastSaleCommitWeek,
			long businessVerticle, int lastSaleCommitYear) {
		this.id = id;
		this.convertionRate = convertionRate;
		this.estimatedAmount = estimatedAmount;
		this.lastSaleCommitWeek = lastSaleCommitWeek;
		this.businessVerticle = businessVerticle;
		this.lastSaleCommitYear = lastSaleCommitYear;
	}

	public BusinessDeal(long id, AccountDetail accountDetail, CrmType crmTypeByBuTypeFk, CrmType crmTypeByCrmTypeFk,
			Currency currency, DealActivity dealActivity, DealSource dealSource, Domain domain,
			PersonDetail personDetail, QuoteHeader quoteHeader, SalesOrderHeader salesOrderHeader,
			StatusItem statusItem, UserDetails userDetailsByCreatedBy, UserDetails userDetailsByLastModifiedBy,
			UserDetails userDetailsBySponsorUserFk, UserDetails userDetailsByOwnerFk, double convertionRate,
			Date dateCreated, String dealName, double estimatedAmount, String guid, String remarks,
			int lastSaleCommitWeek, Date lastUpsidedOn, Date lastModifiedOn, String lostReason,
			Date estimatedClosureDate, long businessVerticle, int lastSaleCommitYear,
			Set<PurchaseOrderHeader> purchaseOrderHeaders, Set<Task> tasks, Set<DealActivity> dealActivities,
			Set<DealActivity> dealActivities_1, Set<QuoteHeader> quoteHeaders,
			Set<PurchaseOrderHeader> purchaseOrderHeaders_1, Set<QuoteHeader> quoteHeaders_1, Set<Task> tasks_1) {
		this.id = id;
		this.accountDetail = accountDetail;
		this.crmTypeByBuTypeFk = crmTypeByBuTypeFk;
		this.crmTypeByCrmTypeFk = crmTypeByCrmTypeFk;
		this.currency = currency;
		this.dealActivity = dealActivity;
		this.dealSource = dealSource;
		this.domain = domain;
		this.personDetail = personDetail;
		this.quoteHeader = quoteHeader;
		this.salesOrderHeader = salesOrderHeader;
		this.statusItem = statusItem;
		this.userDetailsByCreatedBy = userDetailsByCreatedBy;
		this.userDetailsByLastModifiedBy = userDetailsByLastModifiedBy;
		this.userDetailsBySponsorUserFk = userDetailsBySponsorUserFk;
		this.userDetailsByOwnerFk = userDetailsByOwnerFk;
		this.convertionRate = convertionRate;
		this.dateCreated = dateCreated;
		this.dealName = dealName;
		this.estimatedAmount = estimatedAmount;
		this.guid = guid;
		this.remarks = remarks;
		this.lastSaleCommitWeek = lastSaleCommitWeek;
		this.lastUpsidedOn = lastUpsidedOn;
		this.lastModifiedOn = lastModifiedOn;
		this.lostReason = lostReason;
		this.estimatedClosureDate = estimatedClosureDate;
		this.businessVerticle = businessVerticle;
		this.lastSaleCommitYear = lastSaleCommitYear;
		this.purchaseOrderHeaders = purchaseOrderHeaders;
		this.tasks = tasks;
		this.dealActivities = dealActivities;
		this.dealActivities_1 = dealActivities_1;
		this.quoteHeaders = quoteHeaders;
		this.purchaseOrderHeaders_1 = purchaseOrderHeaders_1;
		this.quoteHeaders_1 = quoteHeaders_1;
		this.tasks_1 = tasks_1;
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
	@JoinColumn(name = "BU_TYPE_FK")
	public CrmType getCrmTypeByBuTypeFk() {
		return this.crmTypeByBuTypeFk;
	}

	public void setCrmTypeByBuTypeFk(CrmType crmTypeByBuTypeFk) {
		this.crmTypeByBuTypeFk = crmTypeByBuTypeFk;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CRM_TYPE_FK")
	public CrmType getCrmTypeByCrmTypeFk() {
		return this.crmTypeByCrmTypeFk;
	}

	public void setCrmTypeByCrmTypeFk(CrmType crmTypeByCrmTypeFk) {
		this.crmTypeByCrmTypeFk = crmTypeByCrmTypeFk;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CURRENCY_FK")
	public Currency getCurrency() {
		return this.currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DEAL_ACTIVITY_FK")
	public DealActivity getDealActivity() {
		return this.dealActivity;
	}

	public void setDealActivity(DealActivity dealActivity) {
		this.dealActivity = dealActivity;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SOURCE_FK")
	public DealSource getDealSource() {
		return this.dealSource;
	}

	public void setDealSource(DealSource dealSource) {
		this.dealSource = dealSource;
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
	@JoinColumn(name = "CONTACT_FK")
	public PersonDetail getPersonDetail() {
		return this.personDetail;
	}

	public void setPersonDetail(PersonDetail personDetail) {
		this.personDetail = personDetail;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "QUOTE_FK")
	public QuoteHeader getQuoteHeader() {
		return this.quoteHeader;
	}

	public void setQuoteHeader(QuoteHeader quoteHeader) {
		this.quoteHeader = quoteHeader;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SALES_ORDER_FK")
	public SalesOrderHeader getSalesOrderHeader() {
		return this.salesOrderHeader;
	}

	public void setSalesOrderHeader(SalesOrderHeader salesOrderHeader) {
		this.salesOrderHeader = salesOrderHeader;
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
	@JoinColumn(name = "CREATED_BY")
	public UserDetails getUserDetailsByCreatedBy() {
		return this.userDetailsByCreatedBy;
	}

	public void setUserDetailsByCreatedBy(UserDetails userDetailsByCreatedBy) {
		this.userDetailsByCreatedBy = userDetailsByCreatedBy;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LAST_MODIFIED_BY")
	public UserDetails getUserDetailsByLastModifiedBy() {
		return this.userDetailsByLastModifiedBy;
	}

	public void setUserDetailsByLastModifiedBy(UserDetails userDetailsByLastModifiedBy) {
		this.userDetailsByLastModifiedBy = userDetailsByLastModifiedBy;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SPONSOR_USER_FK")
	public UserDetails getUserDetailsBySponsorUserFk() {
		return this.userDetailsBySponsorUserFk;
	}

	public void setUserDetailsBySponsorUserFk(UserDetails userDetailsBySponsorUserFk) {
		this.userDetailsBySponsorUserFk = userDetailsBySponsorUserFk;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OWNER_FK")
	public UserDetails getUserDetailsByOwnerFk() {
		return this.userDetailsByOwnerFk;
	}

	public void setUserDetailsByOwnerFk(UserDetails userDetailsByOwnerFk) {
		this.userDetailsByOwnerFk = userDetailsByOwnerFk;
	}

	@Column(name = "CONVERTION_RATE", nullable = false, precision = 22, scale = 0)
	public double getConvertionRate() {
		return this.convertionRate;
	}

	public void setConvertionRate(double convertionRate) {
		this.convertionRate = convertionRate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_CREATED", length = 19)
	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Column(name = "DEAL_NAME", unique = true)
	public String getDealName() {
		return this.dealName;
	}

	public void setDealName(String dealName) {
		this.dealName = dealName;
	}

	@Column(name = "ESTIMATED_AMOUNT", nullable = false, precision = 22, scale = 0)
	public double getEstimatedAmount() {
		return this.estimatedAmount;
	}

	public void setEstimatedAmount(double estimatedAmount) {
		this.estimatedAmount = estimatedAmount;
	}

	@Column(name = "GUID")
	public String getGuid() {
		return this.guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	@Column(name = "REMARKS", length = 16777215)
	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Column(name = "LAST_SALE_COMMIT_WEEK", nullable = false)
	public int getLastSaleCommitWeek() {
		return this.lastSaleCommitWeek;
	}

	public void setLastSaleCommitWeek(int lastSaleCommitWeek) {
		this.lastSaleCommitWeek = lastSaleCommitWeek;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_UPSIDED_ON", length = 19)
	public Date getLastUpsidedOn() {
		return this.lastUpsidedOn;
	}

	public void setLastUpsidedOn(Date lastUpsidedOn) {
		this.lastUpsidedOn = lastUpsidedOn;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_MODIFIED_ON", length = 19)
	public Date getLastModifiedOn() {
		return this.lastModifiedOn;
	}

	public void setLastModifiedOn(Date lastModifiedOn) {
		this.lastModifiedOn = lastModifiedOn;
	}

	@Column(name = "LOST_REASON")
	public String getLostReason() {
		return this.lostReason;
	}

	public void setLostReason(String lostReason) {
		this.lostReason = lostReason;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ESTIMATED_CLOSURE_DATE", length = 19)
	public Date getEstimatedClosureDate() {
		return this.estimatedClosureDate;
	}

	public void setEstimatedClosureDate(Date estimatedClosureDate) {
		this.estimatedClosureDate = estimatedClosureDate;
	}

	@Column(name = "BUSINESS_VERTICLE", nullable = false)
	public long getBusinessVerticle() {
		return this.businessVerticle;
	}

	public void setBusinessVerticle(long businessVerticle) {
		this.businessVerticle = businessVerticle;
	}

	@Column(name = "LAST_SALE_COMMIT_YEAR", nullable = false)
	public int getLastSaleCommitYear() {
		return this.lastSaleCommitYear;
	}

	public void setLastSaleCommitYear(int lastSaleCommitYear) {
		this.lastSaleCommitYear = lastSaleCommitYear;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "businessDeal")
	public Set<PurchaseOrderHeader> getPurchaseOrderHeaders() {
		return this.purchaseOrderHeaders;
	}

	public void setPurchaseOrderHeaders(Set<PurchaseOrderHeader> purchaseOrderHeaders) {
		this.purchaseOrderHeaders = purchaseOrderHeaders;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "businessDeal")
	public Set<Task> getTasks() {
		return this.tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "businessDeal")
	public Set<DealActivity> getDealActivities() {
		return this.dealActivities;
	}

	public void setDealActivities(Set<DealActivity> dealActivities) {
		this.dealActivities = dealActivities;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "businessDeal")
	public Set<DealActivity> getDealActivities_1() {
		return this.dealActivities_1;
	}

	public void setDealActivities_1(Set<DealActivity> dealActivities_1) {
		this.dealActivities_1 = dealActivities_1;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "businessDeal")
	public Set<QuoteHeader> getQuoteHeaders() {
		return this.quoteHeaders;
	}

	public void setQuoteHeaders(Set<QuoteHeader> quoteHeaders) {
		this.quoteHeaders = quoteHeaders;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "businessDeal")
	public Set<PurchaseOrderHeader> getPurchaseOrderHeaders_1() {
		return this.purchaseOrderHeaders_1;
	}

	public void setPurchaseOrderHeaders_1(Set<PurchaseOrderHeader> purchaseOrderHeaders_1) {
		this.purchaseOrderHeaders_1 = purchaseOrderHeaders_1;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "businessDeal")
	public Set<QuoteHeader> getQuoteHeaders_1() {
		return this.quoteHeaders_1;
	}

	public void setQuoteHeaders_1(Set<QuoteHeader> quoteHeaders_1) {
		this.quoteHeaders_1 = quoteHeaders_1;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "businessDeal")
	public Set<Task> getTasks_1() {
		return this.tasks_1;
	}

	public void setTasks_1(Set<Task> tasks_1) {
		this.tasks_1 = tasks_1;
	}

}
