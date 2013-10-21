package com.apps.order.entitymodel;

import java.util.Date;

/**
 * OrderStatus generated by MyEclipse Persistence Tools
 */

public class OrderStatus extends com.magic.entitymodel.GenericEntity implements
		java.io.Serializable {

	// Fields

	private String orderStatusId;

	private String statusId;

	private String orderId;

	private String orderItemSeqId;

	private String orderPaymentPreferenceId;

	private Date statusDatetime;

	private String statusUserLogin;

	private String changeReason;

	private Date lastUpdatedStamp;

	private Date lastUpdatedTxStamp;

	private Date createdStamp;

	private Date createdTxStamp;

	// Constructors

	/** default constructor */
	public OrderStatus() {
	}

	/** minimal constructor */
	public OrderStatus(String orderStatusId) {
		this.orderStatusId = orderStatusId;
	}

	/** full constructor */
	public OrderStatus(String orderStatusId, String statusId, String orderId,
			String orderItemSeqId, String orderPaymentPreferenceId,
			Date statusDatetime, String statusUserLogin, String changeReason,
			Date lastUpdatedStamp, Date lastUpdatedTxStamp, Date createdStamp,
			Date createdTxStamp) {
		this.orderStatusId = orderStatusId;
		this.statusId = statusId;
		this.orderId = orderId;
		this.orderItemSeqId = orderItemSeqId;
		this.orderPaymentPreferenceId = orderPaymentPreferenceId;
		this.statusDatetime = statusDatetime;
		this.statusUserLogin = statusUserLogin;
		this.changeReason = changeReason;
		this.lastUpdatedStamp = lastUpdatedStamp;
		this.lastUpdatedTxStamp = lastUpdatedTxStamp;
		this.createdStamp = createdStamp;
		this.createdTxStamp = createdTxStamp;
	}

	// Property accessors

	public String getOrderStatusId() {
		return this.orderStatusId;
	}

	public void setOrderStatusId(String orderStatusId) {
		this.orderStatusId = orderStatusId;
	}

	public String getStatusId() {
		return this.statusId;
	}

	public void setStatusId(String statusId) {
		this.statusId = statusId;
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

	public String getOrderPaymentPreferenceId() {
		return this.orderPaymentPreferenceId;
	}

	public void setOrderPaymentPreferenceId(String orderPaymentPreferenceId) {
		this.orderPaymentPreferenceId = orderPaymentPreferenceId;
	}

	public Date getStatusDatetime() {
		return this.statusDatetime;
	}

	public void setStatusDatetime(Date statusDatetime) {
		this.statusDatetime = statusDatetime;
	}

	public String getStatusUserLogin() {
		return this.statusUserLogin;
	}

	public void setStatusUserLogin(String statusUserLogin) {
		this.statusUserLogin = statusUserLogin;
	}

	public String getChangeReason() {
		return this.changeReason;
	}

	public void setChangeReason(String changeReason) {
		this.changeReason = changeReason;
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