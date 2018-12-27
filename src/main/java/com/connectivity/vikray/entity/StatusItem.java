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
 * StatusItem generated by hbm2java
 */
@Entity
@Table(name = "STATUS_ITEM", catalog = "namcrm")
public class StatusItem implements java.io.Serializable {

	private long id;
	private String constByName;
	private String name;
	private Integer sequenceId;
	private String statusTypeId;
	private float winProbability;
	private Set<BusinessDeal> businessDeals = new HashSet<BusinessDeal>(0);
	private Set<InvoiceHeader> invoiceHeaders = new HashSet<InvoiceHeader>(0);
	private Set<PurchaseEntry> purchaseEntries = new HashSet<PurchaseEntry>(0);
	private Set<PurchaseOrderHeader> purchaseOrderHeaders = new HashSet<PurchaseOrderHeader>(0);
	private Set<QuoteHeader> quoteHeaders = new HashSet<QuoteHeader>(0);
	private Set<DeliveryChallan> deliveryChallans = new HashSet<DeliveryChallan>(0);
	private Set<GrnHeader> grnHeaders = new HashSet<GrnHeader>(0);
	private Set<SalesOrderHeader> salesOrderHeaders = new HashSet<SalesOrderHeader>(0);
	private Set<BusinessDealHistory> businessDealHistories = new HashSet<BusinessDealHistory>(0);

	public StatusItem() {
	}

	public StatusItem(long id, float winProbability) {
		this.id = id;
		this.winProbability = winProbability;
	}

	public StatusItem(long id, String constByName, String name, Integer sequenceId, String statusTypeId,
			float winProbability, Set<BusinessDeal> businessDeals, Set<InvoiceHeader> invoiceHeaders,
			Set<PurchaseEntry> purchaseEntries, Set<PurchaseOrderHeader> purchaseOrderHeaders,
			Set<QuoteHeader> quoteHeaders, Set<DeliveryChallan> deliveryChallans, Set<GrnHeader> grnHeaders,
			Set<SalesOrderHeader> salesOrderHeaders, Set<BusinessDealHistory> businessDealHistories) {
		this.id = id;
		this.constByName = constByName;
		this.name = name;
		this.sequenceId = sequenceId;
		this.statusTypeId = statusTypeId;
		this.winProbability = winProbability;
		this.businessDeals = businessDeals;
		this.invoiceHeaders = invoiceHeaders;
		this.purchaseEntries = purchaseEntries;
		this.purchaseOrderHeaders = purchaseOrderHeaders;
		this.quoteHeaders = quoteHeaders;
		this.deliveryChallans = deliveryChallans;
		this.grnHeaders = grnHeaders;
		this.salesOrderHeaders = salesOrderHeaders;
		this.businessDealHistories = businessDealHistories;
	}

	@Id

	@Column(name = "ID", unique = true, nullable = false)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "CONST_BY_NAME")
	public String getConstByName() {
		return this.constByName;
	}

	public void setConstByName(String constByName) {
		this.constByName = constByName;
	}

	@Column(name = "NAME")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "SEQUENCE_ID")
	public Integer getSequenceId() {
		return this.sequenceId;
	}

	public void setSequenceId(Integer sequenceId) {
		this.sequenceId = sequenceId;
	}

	@Column(name = "STATUS_TYPE_ID")
	public String getStatusTypeId() {
		return this.statusTypeId;
	}

	public void setStatusTypeId(String statusTypeId) {
		this.statusTypeId = statusTypeId;
	}

	@Column(name = "WIN_PROBABILITY", nullable = false, precision = 12, scale = 0)
	public float getWinProbability() {
		return this.winProbability;
	}

	public void setWinProbability(float winProbability) {
		this.winProbability = winProbability;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "statusItem")
	public Set<BusinessDeal> getBusinessDeals() {
		return this.businessDeals;
	}

	public void setBusinessDeals(Set<BusinessDeal> businessDeals) {
		this.businessDeals = businessDeals;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "statusItem")
	public Set<InvoiceHeader> getInvoiceHeaders() {
		return this.invoiceHeaders;
	}

	public void setInvoiceHeaders(Set<InvoiceHeader> invoiceHeaders) {
		this.invoiceHeaders = invoiceHeaders;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "statusItem")
	public Set<PurchaseEntry> getPurchaseEntries() {
		return this.purchaseEntries;
	}

	public void setPurchaseEntries(Set<PurchaseEntry> purchaseEntries) {
		this.purchaseEntries = purchaseEntries;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "statusItem")
	public Set<PurchaseOrderHeader> getPurchaseOrderHeaders() {
		return this.purchaseOrderHeaders;
	}

	public void setPurchaseOrderHeaders(Set<PurchaseOrderHeader> purchaseOrderHeaders) {
		this.purchaseOrderHeaders = purchaseOrderHeaders;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "statusItem")
	public Set<QuoteHeader> getQuoteHeaders() {
		return this.quoteHeaders;
	}

	public void setQuoteHeaders(Set<QuoteHeader> quoteHeaders) {
		this.quoteHeaders = quoteHeaders;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "statusItem")
	public Set<DeliveryChallan> getDeliveryChallans() {
		return this.deliveryChallans;
	}

	public void setDeliveryChallans(Set<DeliveryChallan> deliveryChallans) {
		this.deliveryChallans = deliveryChallans;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "statusItem")
	public Set<GrnHeader> getGrnHeaders() {
		return this.grnHeaders;
	}

	public void setGrnHeaders(Set<GrnHeader> grnHeaders) {
		this.grnHeaders = grnHeaders;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "statusItem")
	public Set<SalesOrderHeader> getSalesOrderHeaders() {
		return this.salesOrderHeaders;
	}

	public void setSalesOrderHeaders(Set<SalesOrderHeader> salesOrderHeaders) {
		this.salesOrderHeaders = salesOrderHeaders;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "statusItem")
	public Set<BusinessDealHistory> getBusinessDealHistories() {
		return this.businessDealHistories;
	}

	public void setBusinessDealHistories(Set<BusinessDealHistory> businessDealHistories) {
		this.businessDealHistories = businessDealHistories;
	}

}
