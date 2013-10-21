package com.apps.product.entitymodel;

import java.util.Date;

import com.magic.entitymodel.GenericEntity;

/**
 * CostComponent generated by MyEclipse Persistence Tools
 */

public class CostComponent extends GenericEntity
		implements java.io.Serializable {

	// Fields

	private String costComponentId;

	private String costComponentTypeId;

	private String productId;

	private String productFeatureId;

	private String partyId;

	private String geoId;

	private String workEffortId;

	private String costComponentCalcId;

	private Date fromDate;

	private Date thruDate;

	private Double cost;

	private String costUomId;

	private Date lastUpdatedStamp;

	private Date lastUpdatedTxStamp;

	private Date createdStamp;

	private Date createdTxStamp;

	// Constructors

	/** default constructor */
	public CostComponent() {
	}

	/** minimal constructor */
	public CostComponent(String costComponentId) {
		this.costComponentId = costComponentId;
	}

	/** full constructor */
	public CostComponent(String costComponentId, String costComponentTypeId,
			String productId, String productFeatureId, String partyId,
			String geoId, String workEffortId, String costComponentCalcId,
			Date fromDate, Date thruDate, Double cost, String costUomId,
			Date lastUpdatedStamp, Date lastUpdatedTxStamp, Date createdStamp,
			Date createdTxStamp) {
		this.costComponentId = costComponentId;
		this.costComponentTypeId = costComponentTypeId;
		this.productId = productId;
		this.productFeatureId = productFeatureId;
		this.partyId = partyId;
		this.geoId = geoId;
		this.workEffortId = workEffortId;
		this.costComponentCalcId = costComponentCalcId;
		this.fromDate = fromDate;
		this.thruDate = thruDate;
		this.cost = cost;
		this.costUomId = costUomId;
		this.lastUpdatedStamp = lastUpdatedStamp;
		this.lastUpdatedTxStamp = lastUpdatedTxStamp;
		this.createdStamp = createdStamp;
		this.createdTxStamp = createdTxStamp;
	}

	// Property accessors

	public String getCostComponentId() {
		return this.costComponentId;
	}

	public void setCostComponentId(String costComponentId) {
		this.costComponentId = costComponentId;
	}

	public String getCostComponentTypeId() {
		return this.costComponentTypeId;
	}

	public void setCostComponentTypeId(String costComponentTypeId) {
		this.costComponentTypeId = costComponentTypeId;
	}

	public String getProductId() {
		return this.productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductFeatureId() {
		return this.productFeatureId;
	}

	public void setProductFeatureId(String productFeatureId) {
		this.productFeatureId = productFeatureId;
	}

	public String getPartyId() {
		return this.partyId;
	}

	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}

	public String getGeoId() {
		return this.geoId;
	}

	public void setGeoId(String geoId) {
		this.geoId = geoId;
	}

	public String getWorkEffortId() {
		return this.workEffortId;
	}

	public void setWorkEffortId(String workEffortId) {
		this.workEffortId = workEffortId;
	}

	public String getCostComponentCalcId() {
		return this.costComponentCalcId;
	}

	public void setCostComponentCalcId(String costComponentCalcId) {
		this.costComponentCalcId = costComponentCalcId;
	}

	public Date getFromDate() {
		return this.fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getThruDate() {
		return this.thruDate;
	}

	public void setThruDate(Date thruDate) {
		this.thruDate = thruDate;
	}

	public Double getCost() {
		return this.cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public String getCostUomId() {
		return this.costUomId;
	}

	public void setCostUomId(String costUomId) {
		this.costUomId = costUomId;
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