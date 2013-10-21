package com.apps.order.entitymodel;

import java.util.Date;

/**
 * OrderItemPriceInfo generated by MyEclipse Persistence Tools
 */

public class OrderItemPriceInfo extends com.magic.entitymodel.GenericEntity
		implements java.io.Serializable {

	// Fields

	private String orderItemPriceInfoId;

	private String orderId;

	private String orderItemSeqId;

	private String productPriceRuleId;

	private String productPriceActionSeqId;

	private Double modifyAmount;

	private String description;

	private String rateCode;

	private Date lastUpdatedStamp;

	private Date lastUpdatedTxStamp;

	private Date createdStamp;

	private Date createdTxStamp;

	// Constructors

	/** default constructor */
	public OrderItemPriceInfo() {
	}

	/** minimal constructor */
	public OrderItemPriceInfo(String orderItemPriceInfoId) {
		this.orderItemPriceInfoId = orderItemPriceInfoId;
	}

	/** full constructor */
	public OrderItemPriceInfo(String orderItemPriceInfoId, String orderId,
			String orderItemSeqId, String productPriceRuleId,
			String productPriceActionSeqId, Double modifyAmount,
			String description, String rateCode, Date lastUpdatedStamp,
			Date lastUpdatedTxStamp, Date createdStamp, Date createdTxStamp) {
		this.orderItemPriceInfoId = orderItemPriceInfoId;
		this.orderId = orderId;
		this.orderItemSeqId = orderItemSeqId;
		this.productPriceRuleId = productPriceRuleId;
		this.productPriceActionSeqId = productPriceActionSeqId;
		this.modifyAmount = modifyAmount;
		this.description = description;
		this.rateCode = rateCode;
		this.lastUpdatedStamp = lastUpdatedStamp;
		this.lastUpdatedTxStamp = lastUpdatedTxStamp;
		this.createdStamp = createdStamp;
		this.createdTxStamp = createdTxStamp;
	}

	// Property accessors

	public String getOrderItemPriceInfoId() {
		return this.orderItemPriceInfoId;
	}

	public void setOrderItemPriceInfoId(String orderItemPriceInfoId) {
		this.orderItemPriceInfoId = orderItemPriceInfoId;
	}

	public String getOrderId() {
		return this.orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderItemSeqId() {
		return this.orderItemSeqId;
	}

	public void setOrderItemSeqId(String orderItemSeqId) {
		this.orderItemSeqId = orderItemSeqId;
	}

	public String getProductPriceRuleId() {
		return this.productPriceRuleId;
	}

	public void setProductPriceRuleId(String productPriceRuleId) {
		this.productPriceRuleId = productPriceRuleId;
	}

	public String getProductPriceActionSeqId() {
		return this.productPriceActionSeqId;
	}

	public void setProductPriceActionSeqId(String productPriceActionSeqId) {
		this.productPriceActionSeqId = productPriceActionSeqId;
	}

	public Double getModifyAmount() {
		return this.modifyAmount;
	}

	public void setModifyAmount(Double modifyAmount) {
		this.modifyAmount = modifyAmount;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRateCode() {
		return this.rateCode;
	}

	public void setRateCode(String rateCode) {
		this.rateCode = rateCode;
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