package com.apps.order.entitymodel;

import java.util.Date;

/**
 * OrderHeader generated by MyEclipse Persistence Tools
 */

public class OrderHeader extends com.magic.entitymodel.GenericEntity implements
		java.io.Serializable {

	// Fields

	private String orderId;

	private String orderTypeId;

	private String orderName;

	private String externalId;

	private String salesChannelEnumId;

	private Date orderDate;

	private String priority;

	private Date entryDate;

	private String visitId;

	private String statusId;

	private String createdBy;

	private String firstAttemptOrderId;

	private String currencyUom;

	private String syncStatusId;

	private String billingAccountId;

	private String originFacilityId;

	private String webSiteId;

	private String productStoreId;

	private String terminalId;

	private String transactionId;

	private String autoOrderShoppingListId;

	private String needsInventoryIssuance;

	private String isRushOrder;

	private String internalCode;

	private Double remainingSubTotal;

	private Double grandTotal;

	private Date lastUpdatedStamp;

	private Date lastUpdatedTxStamp;

	private Date createdStamp;

	private Date createdTxStamp;

	// Constructors

	/** default constructor */
	public OrderHeader() {
	}

	/** minimal constructor */
	public OrderHeader(String orderId) {
		this.orderId = orderId;
	}

	/** full constructor */
	public OrderHeader(String orderId, String orderTypeId, String orderName,
			String externalId, String salesChannelEnumId, Date orderDate,
			String priority, Date entryDate, String visitId, String statusId,
			String createdBy, String firstAttemptOrderId, String currencyUom,
			String syncStatusId, String billingAccountId,
			String originFacilityId, String webSiteId, String productStoreId,
			String terminalId, String transactionId,
			String autoOrderShoppingListId, String needsInventoryIssuance,
			String isRushOrder, String internalCode, Double remainingSubTotal,
			Double grandTotal, Date lastUpdatedStamp, Date lastUpdatedTxStamp,
			Date createdStamp, Date createdTxStamp) {
		this.orderId = orderId;
		this.orderTypeId = orderTypeId;
		this.orderName = orderName;
		this.externalId = externalId;
		this.salesChannelEnumId = salesChannelEnumId;
		this.orderDate = orderDate;
		this.priority = priority;
		this.entryDate = entryDate;
		this.visitId = visitId;
		this.statusId = statusId;
		this.createdBy = createdBy;
		this.firstAttemptOrderId = firstAttemptOrderId;
		this.currencyUom = currencyUom;
		this.syncStatusId = syncStatusId;
		this.billingAccountId = billingAccountId;
		this.originFacilityId = originFacilityId;
		this.webSiteId = webSiteId;
		this.productStoreId = productStoreId;
		this.terminalId = terminalId;
		this.transactionId = transactionId;
		this.autoOrderShoppingListId = autoOrderShoppingListId;
		this.needsInventoryIssuance = needsInventoryIssuance;
		this.isRushOrder = isRushOrder;
		this.internalCode = internalCode;
		this.remainingSubTotal = remainingSubTotal;
		this.grandTotal = grandTotal;
		this.lastUpdatedStamp = lastUpdatedStamp;
		this.lastUpdatedTxStamp = lastUpdatedTxStamp;
		this.createdStamp = createdStamp;
		this.createdTxStamp = createdTxStamp;
	}

	// Property accessors

	public String getOrderId() {
		return this.orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderTypeId() {
		return this.orderTypeId;
	}

	public void setOrderTypeId(String orderTypeId) {
		this.orderTypeId = orderTypeId;
	}

	public String getOrderName() {
		return this.orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getExternalId() {
		return this.externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public String getSalesChannelEnumId() {
		return this.salesChannelEnumId;
	}

	public void setSalesChannelEnumId(String salesChannelEnumId) {
		this.salesChannelEnumId = salesChannelEnumId;
	}

	public Date getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getPriority() {
		return this.priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Date getEntryDate() {
		return this.entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public String getVisitId() {
		return this.visitId;
	}

	public void setVisitId(String visitId) {
		this.visitId = visitId;
	}

	public String getStatusId() {
		return this.statusId;
	}

	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getFirstAttemptOrderId() {
		return this.firstAttemptOrderId;
	}

	public void setFirstAttemptOrderId(String firstAttemptOrderId) {
		this.firstAttemptOrderId = firstAttemptOrderId;
	}

	public String getCurrencyUom() {
		return this.currencyUom;
	}

	public void setCurrencyUom(String currencyUom) {
		this.currencyUom = currencyUom;
	}

	public String getSyncStatusId() {
		return this.syncStatusId;
	}

	public void setSyncStatusId(String syncStatusId) {
		this.syncStatusId = syncStatusId;
	}

	public String getBillingAccountId() {
		return this.billingAccountId;
	}

	public void setBillingAccountId(String billingAccountId) {
		this.billingAccountId = billingAccountId;
	}

	public String getOriginFacilityId() {
		return this.originFacilityId;
	}

	public void setOriginFacilityId(String originFacilityId) {
		this.originFacilityId = originFacilityId;
	}

	public String getWebSiteId() {
		return this.webSiteId;
	}

	public void setWebSiteId(String webSiteId) {
		this.webSiteId = webSiteId;
	}

	public String getProductStoreId() {
		return this.productStoreId;
	}

	public void setProductStoreId(String productStoreId) {
		this.productStoreId = productStoreId;
	}

	public String getTerminalId() {
		return this.terminalId;
	}

	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	public String getTransactionId() {
		return this.transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getAutoOrderShoppingListId() {
		return this.autoOrderShoppingListId;
	}

	public void setAutoOrderShoppingListId(String autoOrderShoppingListId) {
		this.autoOrderShoppingListId = autoOrderShoppingListId;
	}

	public String getNeedsInventoryIssuance() {
		return this.needsInventoryIssuance;
	}

	public void setNeedsInventoryIssuance(String needsInventoryIssuance) {
		this.needsInventoryIssuance = needsInventoryIssuance;
	}

	public String getIsRushOrder() {
		return this.isRushOrder;
	}

	public void setIsRushOrder(String isRushOrder) {
		this.isRushOrder = isRushOrder;
	}

	public String getInternalCode() {
		return this.internalCode;
	}

	public void setInternalCode(String internalCode) {
		this.internalCode = internalCode;
	}

	public Double getRemainingSubTotal() {
		return this.remainingSubTotal;
	}

	public void setRemainingSubTotal(Double remainingSubTotal) {
		this.remainingSubTotal = remainingSubTotal;
	}

	public Double getGrandTotal() {
		return this.grandTotal;
	}

	public void setGrandTotal(Double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public Date getLastUpdatedStamp() {
		return this.lastUpdatedStamp;
	}

	public void setLastUpdatedStamp(Date lastUpdatedStamp) {
		this.lastUpdatedStamp = lastUpdatedStamp;
	}

	public Date getLastUpdatedTxStamp() {
		return this.lastUpdatedTxStamp;
	}

	public void setLastUpdatedTxStamp(Date lastUpdatedTxStamp) {
		this.lastUpdatedTxStamp = lastUpdatedTxStamp;
	}

	public Date getCreatedStamp() {
		return this.createdStamp;
	}

	public void setCreatedStamp(Date createdStamp) {
		this.createdStamp = createdStamp;
	}

	public Date getCreatedTxStamp() {
		return this.createdTxStamp;
	}

	public void setCreatedTxStamp(Date createdTxStamp) {
		this.createdTxStamp = createdTxStamp;
	}

}