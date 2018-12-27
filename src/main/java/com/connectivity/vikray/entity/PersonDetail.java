package com.connectivity.vikray.entity;
// Generated 27 Dec, 2018 3:06:26 PM by Hibernate Tools 5.2.11.Final

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
 * PersonDetail generated by hbm2java
 */
@Entity
@Table(name = "PERSON_DETAIL", catalog = "namcrm")
public class PersonDetail implements java.io.Serializable {

	private long id;
	private AccountDetail accountDetail;
	private Domain domain;
	private RoleType roleType;
	private String firstName;
	private String guid;
	private String lastName;
	private String middleName;
	private String title;
	private Integer perdetailsIntegerIdx;
	private Set<OrderItem> orderItems = new HashSet<OrderItem>(0);
	private Set<PersonAddress> personAddresses = new HashSet<PersonAddress>(0);
	private Set<SalesOrderHeader> salesOrderHeadersForFinanceContactFk = new HashSet<SalesOrderHeader>(0);
	private Set<SalesOrderHeader> salesOrderHeadersForPersonFk = new HashSet<SalesOrderHeader>(0);
	private Set<InvoiceHeader> invoiceHeadersForFinanceContactFk = new HashSet<InvoiceHeader>(0);
	private Set<DeliveryChallan> deliveryChallansForShippingContactFk = new HashSet<DeliveryChallan>(0);
	private Set<InvoiceHeader> invoiceHeadersForPersonFk = new HashSet<InvoiceHeader>(0);
	private Set<GrnHeader> grnHeaders = new HashSet<GrnHeader>(0);
	private Set<PurchaseOrderHeader> purchaseOrderHeaders = new HashSet<PurchaseOrderHeader>(0);
	private Set<SalesOrderHeader> salesOrderHeadersForShippingContactFk = new HashSet<SalesOrderHeader>(0);
	private Set<PersonEmail> personEmails = new HashSet<PersonEmail>(0);
	private Set<BusinessDeal> businessDeals = new HashSet<BusinessDeal>(0);
	private Set<QuoteHeader> quoteHeaders = new HashSet<QuoteHeader>(0);
	private Set<PersonTelephone> personTelephones = new HashSet<PersonTelephone>(0);
	private Set<PurchaseEntry> purchaseEntries = new HashSet<PurchaseEntry>(0);
	private Set<DeliveryChallan> deliveryChallansForPersonFk = new HashSet<DeliveryChallan>(0);

	public PersonDetail() {
	}

	public PersonDetail(long id) {
		this.id = id;
	}

	public PersonDetail(long id, AccountDetail accountDetail, Domain domain, RoleType roleType, String firstName,
			String guid, String lastName, String middleName, String title, Integer perdetailsIntegerIdx,
			Set<OrderItem> orderItems, Set<PersonAddress> personAddresses,
			Set<SalesOrderHeader> salesOrderHeadersForFinanceContactFk,
			Set<SalesOrderHeader> salesOrderHeadersForPersonFk, Set<InvoiceHeader> invoiceHeadersForFinanceContactFk,
			Set<DeliveryChallan> deliveryChallansForShippingContactFk, Set<InvoiceHeader> invoiceHeadersForPersonFk,
			Set<GrnHeader> grnHeaders, Set<PurchaseOrderHeader> purchaseOrderHeaders,
			Set<SalesOrderHeader> salesOrderHeadersForShippingContactFk, Set<PersonEmail> personEmails,
			Set<BusinessDeal> businessDeals, Set<QuoteHeader> quoteHeaders, Set<PersonTelephone> personTelephones,
			Set<PurchaseEntry> purchaseEntries, Set<DeliveryChallan> deliveryChallansForPersonFk) {
		this.id = id;
		this.accountDetail = accountDetail;
		this.domain = domain;
		this.roleType = roleType;
		this.firstName = firstName;
		this.guid = guid;
		this.lastName = lastName;
		this.middleName = middleName;
		this.title = title;
		this.perdetailsIntegerIdx = perdetailsIntegerIdx;
		this.orderItems = orderItems;
		this.personAddresses = personAddresses;
		this.salesOrderHeadersForFinanceContactFk = salesOrderHeadersForFinanceContactFk;
		this.salesOrderHeadersForPersonFk = salesOrderHeadersForPersonFk;
		this.invoiceHeadersForFinanceContactFk = invoiceHeadersForFinanceContactFk;
		this.deliveryChallansForShippingContactFk = deliveryChallansForShippingContactFk;
		this.invoiceHeadersForPersonFk = invoiceHeadersForPersonFk;
		this.grnHeaders = grnHeaders;
		this.purchaseOrderHeaders = purchaseOrderHeaders;
		this.salesOrderHeadersForShippingContactFk = salesOrderHeadersForShippingContactFk;
		this.personEmails = personEmails;
		this.businessDeals = businessDeals;
		this.quoteHeaders = quoteHeaders;
		this.personTelephones = personTelephones;
		this.purchaseEntries = purchaseEntries;
		this.deliveryChallansForPersonFk = deliveryChallansForPersonFk;
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
	@JoinColumn(name = "ROLE_TYPE_FK")
	public RoleType getRoleType() {
		return this.roleType;
	}

	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}

	@Column(name = "FIRST_NAME")
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "GUID")
	public String getGuid() {
		return this.guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	@Column(name = "LAST_NAME")
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "MIDDLE_NAME")
	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@Column(name = "TITLE")
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "PERDETAILS_INTEGER_IDX")
	public Integer getPerdetailsIntegerIdx() {
		return this.perdetailsIntegerIdx;
	}

	public void setPerdetailsIntegerIdx(Integer perdetailsIntegerIdx) {
		this.perdetailsIntegerIdx = perdetailsIntegerIdx;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personDetail")
	public Set<OrderItem> getOrderItems() {
		return this.orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personDetail")
	public Set<PersonAddress> getPersonAddresses() {
		return this.personAddresses;
	}

	public void setPersonAddresses(Set<PersonAddress> personAddresses) {
		this.personAddresses = personAddresses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personDetailByFinanceContactFk")
	public Set<SalesOrderHeader> getSalesOrderHeadersForFinanceContactFk() {
		return this.salesOrderHeadersForFinanceContactFk;
	}

	public void setSalesOrderHeadersForFinanceContactFk(Set<SalesOrderHeader> salesOrderHeadersForFinanceContactFk) {
		this.salesOrderHeadersForFinanceContactFk = salesOrderHeadersForFinanceContactFk;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personDetailByPersonFk")
	public Set<SalesOrderHeader> getSalesOrderHeadersForPersonFk() {
		return this.salesOrderHeadersForPersonFk;
	}

	public void setSalesOrderHeadersForPersonFk(Set<SalesOrderHeader> salesOrderHeadersForPersonFk) {
		this.salesOrderHeadersForPersonFk = salesOrderHeadersForPersonFk;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personDetailByFinanceContactFk")
	public Set<InvoiceHeader> getInvoiceHeadersForFinanceContactFk() {
		return this.invoiceHeadersForFinanceContactFk;
	}

	public void setInvoiceHeadersForFinanceContactFk(Set<InvoiceHeader> invoiceHeadersForFinanceContactFk) {
		this.invoiceHeadersForFinanceContactFk = invoiceHeadersForFinanceContactFk;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personDetailByShippingContactFk")
	public Set<DeliveryChallan> getDeliveryChallansForShippingContactFk() {
		return this.deliveryChallansForShippingContactFk;
	}

	public void setDeliveryChallansForShippingContactFk(Set<DeliveryChallan> deliveryChallansForShippingContactFk) {
		this.deliveryChallansForShippingContactFk = deliveryChallansForShippingContactFk;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personDetailByPersonFk")
	public Set<InvoiceHeader> getInvoiceHeadersForPersonFk() {
		return this.invoiceHeadersForPersonFk;
	}

	public void setInvoiceHeadersForPersonFk(Set<InvoiceHeader> invoiceHeadersForPersonFk) {
		this.invoiceHeadersForPersonFk = invoiceHeadersForPersonFk;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personDetail")
	public Set<GrnHeader> getGrnHeaders() {
		return this.grnHeaders;
	}

	public void setGrnHeaders(Set<GrnHeader> grnHeaders) {
		this.grnHeaders = grnHeaders;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personDetail")
	public Set<PurchaseOrderHeader> getPurchaseOrderHeaders() {
		return this.purchaseOrderHeaders;
	}

	public void setPurchaseOrderHeaders(Set<PurchaseOrderHeader> purchaseOrderHeaders) {
		this.purchaseOrderHeaders = purchaseOrderHeaders;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personDetailByShippingContactFk")
	public Set<SalesOrderHeader> getSalesOrderHeadersForShippingContactFk() {
		return this.salesOrderHeadersForShippingContactFk;
	}

	public void setSalesOrderHeadersForShippingContactFk(Set<SalesOrderHeader> salesOrderHeadersForShippingContactFk) {
		this.salesOrderHeadersForShippingContactFk = salesOrderHeadersForShippingContactFk;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personDetail")
	public Set<PersonEmail> getPersonEmails() {
		return this.personEmails;
	}

	public void setPersonEmails(Set<PersonEmail> personEmails) {
		this.personEmails = personEmails;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personDetail")
	public Set<BusinessDeal> getBusinessDeals() {
		return this.businessDeals;
	}

	public void setBusinessDeals(Set<BusinessDeal> businessDeals) {
		this.businessDeals = businessDeals;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personDetail")
	public Set<QuoteHeader> getQuoteHeaders() {
		return this.quoteHeaders;
	}

	public void setQuoteHeaders(Set<QuoteHeader> quoteHeaders) {
		this.quoteHeaders = quoteHeaders;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personDetail")
	public Set<PersonTelephone> getPersonTelephones() {
		return this.personTelephones;
	}

	public void setPersonTelephones(Set<PersonTelephone> personTelephones) {
		this.personTelephones = personTelephones;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personDetail")
	public Set<PurchaseEntry> getPurchaseEntries() {
		return this.purchaseEntries;
	}

	public void setPurchaseEntries(Set<PurchaseEntry> purchaseEntries) {
		this.purchaseEntries = purchaseEntries;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personDetailByPersonFk")
	public Set<DeliveryChallan> getDeliveryChallansForPersonFk() {
		return this.deliveryChallansForPersonFk;
	}

	public void setDeliveryChallansForPersonFk(Set<DeliveryChallan> deliveryChallansForPersonFk) {
		this.deliveryChallansForPersonFk = deliveryChallansForPersonFk;
	}

}
