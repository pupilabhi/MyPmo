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
 * QuoteItem generated by hbm2java
 */
@Entity
@Table(name = "QUOTE_ITEM", catalog = "namcrm")
public class QuoteItem implements java.io.Serializable {

	private long id;
	private InvoiceItem invoiceItem;
	private OrderItem orderItem;
	private QuoteHeader quoteHeader;
	private int deliveredQuantity;
	private double extendedPrice;
	private double glp;
	private double incomingUnitPrice;
	private double incomingUnitPricePerDay;
	private boolean isServiceItem;
	private String itemDescription;
	private String itemHeader;
	private String itemName;
	private double marginPercentage;
	private double outGoingUnitPrice;
	private int pendingDeliveredQuantity;
	private double priceWithTax;
	private long purchaseOrderId;
	private int quantity;
	private String serviceDuration;
	private double taxPercentage;
	private String taxType;
	private String uom;
	private Integer quoteitemsIntegerIdx;
	private boolean isInvoicedItem;
	private double profit;
	private String slNo;
	private double taxamount;
	private double sgstRate;
	private double igstRate;
	private double cgstRate;
	private double cgstAmount;
	private String hsnCode;
	private double igstAmount;
	private double sgstAmount;
	private String productType;
	private long productId;
	private Date serviceStartDate;
	private Date serviceEndDate;
	private int pendingDcQunatity;
	private int dcQuantity;
	private Set<DeliveryChallanItem> deliveryChallanItems = new HashSet<DeliveryChallanItem>(0);
	private Set<OrderItem> orderItems = new HashSet<OrderItem>(0);
	private Set<InvoiceItem> invoiceItems = new HashSet<InvoiceItem>(0);

	public QuoteItem() {
	}

	public QuoteItem(long id, int deliveredQuantity, double extendedPrice, double glp, double incomingUnitPrice,
			double incomingUnitPricePerDay, boolean isServiceItem, double marginPercentage, double outGoingUnitPrice,
			int pendingDeliveredQuantity, double priceWithTax, long purchaseOrderId, int quantity, double taxPercentage,
			boolean isInvoicedItem, double profit, double taxamount, double sgstRate, double igstRate, double cgstRate,
			double cgstAmount, double igstAmount, double sgstAmount, long productId, int pendingDcQunatity,
			int dcQuantity) {
		this.id = id;
		this.deliveredQuantity = deliveredQuantity;
		this.extendedPrice = extendedPrice;
		this.glp = glp;
		this.incomingUnitPrice = incomingUnitPrice;
		this.incomingUnitPricePerDay = incomingUnitPricePerDay;
		this.isServiceItem = isServiceItem;
		this.marginPercentage = marginPercentage;
		this.outGoingUnitPrice = outGoingUnitPrice;
		this.pendingDeliveredQuantity = pendingDeliveredQuantity;
		this.priceWithTax = priceWithTax;
		this.purchaseOrderId = purchaseOrderId;
		this.quantity = quantity;
		this.taxPercentage = taxPercentage;
		this.isInvoicedItem = isInvoicedItem;
		this.profit = profit;
		this.taxamount = taxamount;
		this.sgstRate = sgstRate;
		this.igstRate = igstRate;
		this.cgstRate = cgstRate;
		this.cgstAmount = cgstAmount;
		this.igstAmount = igstAmount;
		this.sgstAmount = sgstAmount;
		this.productId = productId;
		this.pendingDcQunatity = pendingDcQunatity;
		this.dcQuantity = dcQuantity;
	}

	public QuoteItem(long id, InvoiceItem invoiceItem, OrderItem orderItem, QuoteHeader quoteHeader,
			int deliveredQuantity, double extendedPrice, double glp, double incomingUnitPrice,
			double incomingUnitPricePerDay, boolean isServiceItem, String itemDescription, String itemHeader,
			String itemName, double marginPercentage, double outGoingUnitPrice, int pendingDeliveredQuantity,
			double priceWithTax, long purchaseOrderId, int quantity, String serviceDuration, double taxPercentage,
			String taxType, String uom, Integer quoteitemsIntegerIdx, boolean isInvoicedItem, double profit,
			String slNo, double taxamount, double sgstRate, double igstRate, double cgstRate, double cgstAmount,
			String hsnCode, double igstAmount, double sgstAmount, String productType, long productId,
			Date serviceStartDate, Date serviceEndDate, int pendingDcQunatity, int dcQuantity,
			Set<DeliveryChallanItem> deliveryChallanItems, Set<OrderItem> orderItems, Set<InvoiceItem> invoiceItems) {
		this.id = id;
		this.invoiceItem = invoiceItem;
		this.orderItem = orderItem;
		this.quoteHeader = quoteHeader;
		this.deliveredQuantity = deliveredQuantity;
		this.extendedPrice = extendedPrice;
		this.glp = glp;
		this.incomingUnitPrice = incomingUnitPrice;
		this.incomingUnitPricePerDay = incomingUnitPricePerDay;
		this.isServiceItem = isServiceItem;
		this.itemDescription = itemDescription;
		this.itemHeader = itemHeader;
		this.itemName = itemName;
		this.marginPercentage = marginPercentage;
		this.outGoingUnitPrice = outGoingUnitPrice;
		this.pendingDeliveredQuantity = pendingDeliveredQuantity;
		this.priceWithTax = priceWithTax;
		this.purchaseOrderId = purchaseOrderId;
		this.quantity = quantity;
		this.serviceDuration = serviceDuration;
		this.taxPercentage = taxPercentage;
		this.taxType = taxType;
		this.uom = uom;
		this.quoteitemsIntegerIdx = quoteitemsIntegerIdx;
		this.isInvoicedItem = isInvoicedItem;
		this.profit = profit;
		this.slNo = slNo;
		this.taxamount = taxamount;
		this.sgstRate = sgstRate;
		this.igstRate = igstRate;
		this.cgstRate = cgstRate;
		this.cgstAmount = cgstAmount;
		this.hsnCode = hsnCode;
		this.igstAmount = igstAmount;
		this.sgstAmount = sgstAmount;
		this.productType = productType;
		this.productId = productId;
		this.serviceStartDate = serviceStartDate;
		this.serviceEndDate = serviceEndDate;
		this.pendingDcQunatity = pendingDcQunatity;
		this.dcQuantity = dcQuantity;
		this.deliveryChallanItems = deliveryChallanItems;
		this.orderItems = orderItems;
		this.invoiceItems = invoiceItems;
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
	@JoinColumn(name = "INVOICE_ITEM")
	public InvoiceItem getInvoiceItem() {
		return this.invoiceItem;
	}

	public void setInvoiceItem(InvoiceItem invoiceItem) {
		this.invoiceItem = invoiceItem;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORDER_ITEM_FK")
	public OrderItem getOrderItem() {
		return this.orderItem;
	}

	public void setOrderItem(OrderItem orderItem) {
		this.orderItem = orderItem;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "QUOTE_ID")
	public QuoteHeader getQuoteHeader() {
		return this.quoteHeader;
	}

	public void setQuoteHeader(QuoteHeader quoteHeader) {
		this.quoteHeader = quoteHeader;
	}

	@Column(name = "DELIVERED_QUANTITY", nullable = false)
	public int getDeliveredQuantity() {
		return this.deliveredQuantity;
	}

	public void setDeliveredQuantity(int deliveredQuantity) {
		this.deliveredQuantity = deliveredQuantity;
	}

	@Column(name = "EXTENDED_PRICE", nullable = false, precision = 22, scale = 0)
	public double getExtendedPrice() {
		return this.extendedPrice;
	}

	public void setExtendedPrice(double extendedPrice) {
		this.extendedPrice = extendedPrice;
	}

	@Column(name = "GLP", nullable = false, precision = 22, scale = 0)
	public double getGlp() {
		return this.glp;
	}

	public void setGlp(double glp) {
		this.glp = glp;
	}

	@Column(name = "INCOMING_UNIT_PRICE", nullable = false, precision = 22, scale = 0)
	public double getIncomingUnitPrice() {
		return this.incomingUnitPrice;
	}

	public void setIncomingUnitPrice(double incomingUnitPrice) {
		this.incomingUnitPrice = incomingUnitPrice;
	}

	@Column(name = "INCOMING_UNIT_PRICE_PER_DAY", nullable = false, precision = 22, scale = 0)
	public double getIncomingUnitPricePerDay() {
		return this.incomingUnitPricePerDay;
	}

	public void setIncomingUnitPricePerDay(double incomingUnitPricePerDay) {
		this.incomingUnitPricePerDay = incomingUnitPricePerDay;
	}

	@Column(name = "IS_SERVICE_ITEM", nullable = false)
	public boolean isIsServiceItem() {
		return this.isServiceItem;
	}

	public void setIsServiceItem(boolean isServiceItem) {
		this.isServiceItem = isServiceItem;
	}

	@Column(name = "ITEM_DESCRIPTION", length = 16777215)
	public String getItemDescription() {
		return this.itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	@Column(name = "ITEM_HEADER")
	public String getItemHeader() {
		return this.itemHeader;
	}

	public void setItemHeader(String itemHeader) {
		this.itemHeader = itemHeader;
	}

	@Column(name = "ITEM_NAME")
	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	@Column(name = "MARGIN_PERCENTAGE", nullable = false, precision = 22, scale = 0)
	public double getMarginPercentage() {
		return this.marginPercentage;
	}

	public void setMarginPercentage(double marginPercentage) {
		this.marginPercentage = marginPercentage;
	}

	@Column(name = "OUT-GOING_UNIT_PRICE", nullable = false, precision = 22, scale = 0)
	public double getOutGoingUnitPrice() {
		return this.outGoingUnitPrice;
	}

	public void setOutGoingUnitPrice(double outGoingUnitPrice) {
		this.outGoingUnitPrice = outGoingUnitPrice;
	}

	@Column(name = "PENDING_DELIVERED_QUANTITY", nullable = false)
	public int getPendingDeliveredQuantity() {
		return this.pendingDeliveredQuantity;
	}

	public void setPendingDeliveredQuantity(int pendingDeliveredQuantity) {
		this.pendingDeliveredQuantity = pendingDeliveredQuantity;
	}

	@Column(name = "PRICE_WITH_TAX", nullable = false, precision = 22, scale = 0)
	public double getPriceWithTax() {
		return this.priceWithTax;
	}

	public void setPriceWithTax(double priceWithTax) {
		this.priceWithTax = priceWithTax;
	}

	@Column(name = "PURCHASE_ORDER_ID", nullable = false)
	public long getPurchaseOrderId() {
		return this.purchaseOrderId;
	}

	public void setPurchaseOrderId(long purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}

	@Column(name = "QUANTITY", nullable = false)
	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Column(name = "SERVICE_DURATION")
	public String getServiceDuration() {
		return this.serviceDuration;
	}

	public void setServiceDuration(String serviceDuration) {
		this.serviceDuration = serviceDuration;
	}

	@Column(name = "TAX_PERCENTAGE", nullable = false, precision = 22, scale = 0)
	public double getTaxPercentage() {
		return this.taxPercentage;
	}

	public void setTaxPercentage(double taxPercentage) {
		this.taxPercentage = taxPercentage;
	}

	@Column(name = "TAX_TYPE")
	public String getTaxType() {
		return this.taxType;
	}

	public void setTaxType(String taxType) {
		this.taxType = taxType;
	}

	@Column(name = "UOM")
	public String getUom() {
		return this.uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	@Column(name = "QUOTEITEMS_INTEGER_IDX")
	public Integer getQuoteitemsIntegerIdx() {
		return this.quoteitemsIntegerIdx;
	}

	public void setQuoteitemsIntegerIdx(Integer quoteitemsIntegerIdx) {
		this.quoteitemsIntegerIdx = quoteitemsIntegerIdx;
	}

	@Column(name = "IS_INVOICED_ITEM", nullable = false)
	public boolean isIsInvoicedItem() {
		return this.isInvoicedItem;
	}

	public void setIsInvoicedItem(boolean isInvoicedItem) {
		this.isInvoicedItem = isInvoicedItem;
	}

	@Column(name = "PROFIT", nullable = false, precision = 22, scale = 0)
	public double getProfit() {
		return this.profit;
	}

	public void setProfit(double profit) {
		this.profit = profit;
	}

	@Column(name = "SL_NO")
	public String getSlNo() {
		return this.slNo;
	}

	public void setSlNo(String slNo) {
		this.slNo = slNo;
	}

	@Column(name = "TAXAMOUNT", nullable = false, precision = 22, scale = 0)
	public double getTaxamount() {
		return this.taxamount;
	}

	public void setTaxamount(double taxamount) {
		this.taxamount = taxamount;
	}

	@Column(name = "SGST_RATE", nullable = false, precision = 22, scale = 0)
	public double getSgstRate() {
		return this.sgstRate;
	}

	public void setSgstRate(double sgstRate) {
		this.sgstRate = sgstRate;
	}

	@Column(name = "IGST_RATE", nullable = false, precision = 22, scale = 0)
	public double getIgstRate() {
		return this.igstRate;
	}

	public void setIgstRate(double igstRate) {
		this.igstRate = igstRate;
	}

	@Column(name = "CGST_RATE", nullable = false, precision = 22, scale = 0)
	public double getCgstRate() {
		return this.cgstRate;
	}

	public void setCgstRate(double cgstRate) {
		this.cgstRate = cgstRate;
	}

	@Column(name = "CGST_AMOUNT", nullable = false, precision = 22, scale = 0)
	public double getCgstAmount() {
		return this.cgstAmount;
	}

	public void setCgstAmount(double cgstAmount) {
		this.cgstAmount = cgstAmount;
	}

	@Column(name = "HSN_CODE")
	public String getHsnCode() {
		return this.hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}

	@Column(name = "IGST_AMOUNT", nullable = false, precision = 22, scale = 0)
	public double getIgstAmount() {
		return this.igstAmount;
	}

	public void setIgstAmount(double igstAmount) {
		this.igstAmount = igstAmount;
	}

	@Column(name = "SGST_AMOUNT", nullable = false, precision = 22, scale = 0)
	public double getSgstAmount() {
		return this.sgstAmount;
	}

	public void setSgstAmount(double sgstAmount) {
		this.sgstAmount = sgstAmount;
	}

	@Column(name = "PRODUCT_TYPE")
	public String getProductType() {
		return this.productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	@Column(name = "PRODUCT_ID", nullable = false)
	public long getProductId() {
		return this.productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "SERVICE_START_DATE", length = 19)
	public Date getServiceStartDate() {
		return this.serviceStartDate;
	}

	public void setServiceStartDate(Date serviceStartDate) {
		this.serviceStartDate = serviceStartDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "SERVICE_END_DATE", length = 19)
	public Date getServiceEndDate() {
		return this.serviceEndDate;
	}

	public void setServiceEndDate(Date serviceEndDate) {
		this.serviceEndDate = serviceEndDate;
	}

	@Column(name = "PENDING_DC_QUNATITY", nullable = false)
	public int getPendingDcQunatity() {
		return this.pendingDcQunatity;
	}

	public void setPendingDcQunatity(int pendingDcQunatity) {
		this.pendingDcQunatity = pendingDcQunatity;
	}

	@Column(name = "DC_QUANTITY", nullable = false)
	public int getDcQuantity() {
		return this.dcQuantity;
	}

	public void setDcQuantity(int dcQuantity) {
		this.dcQuantity = dcQuantity;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "quoteItem")
	public Set<DeliveryChallanItem> getDeliveryChallanItems() {
		return this.deliveryChallanItems;
	}

	public void setDeliveryChallanItems(Set<DeliveryChallanItem> deliveryChallanItems) {
		this.deliveryChallanItems = deliveryChallanItems;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "quoteItem")
	public Set<OrderItem> getOrderItems() {
		return this.orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "quoteItem")
	public Set<InvoiceItem> getInvoiceItems() {
		return this.invoiceItems;
	}

	public void setInvoiceItems(Set<InvoiceItem> invoiceItems) {
		this.invoiceItems = invoiceItems;
	}

}
