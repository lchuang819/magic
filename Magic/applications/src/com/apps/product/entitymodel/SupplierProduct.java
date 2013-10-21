package com.apps.product.entitymodel;

import java.util.Date;

import com.magic.entitymodel.GenericEntity;

/**
 * SupplierProduct generated by MyEclipse Persistence Tools
 */

public class SupplierProduct extends GenericEntity implements java.io.Serializable {

	// Fields

	private SupplierProductId id;

	private Date availableThruDate;

	private String supplierPrefOrderId;

	private String supplierRatingTypeId;

	private Double standardLeadTimeDays;

	private Double orderQtyIncrements;

	private Double unitsIncluded;

	private String quantityUomId;

	private String agreementId;

	private String agreementItemSeqId;

	private Double lastPrice;

	private String supplierProductName;

	private String supplierProductId;

	private String canDropShip;

	private Double supplierCommissionPerc;

	private String comments;

	private Date lastUpdatedStamp;

	private Date lastUpdatedTxStamp;

	private Date createdStamp;

	private Date createdTxStamp;

	// Constructors

	/** default constructor */
	public SupplierProduct() {
	}

	/** minimal constructor */
	public SupplierProduct(SupplierProductId id) {
		this.id = id;
	}

	/** full constructor */
	public SupplierProduct(SupplierProductId id, Date availableThruDate,
			String supplierPrefOrderId, String supplierRatingTypeId,
			Double standardLeadTimeDays, Double orderQtyIncrements,
			Double unitsIncluded, String quantityUomId, String agreementId,
			String agreementItemSeqId, Double lastPrice,
			String supplierProductName, String supplierProductId,
			String canDropShip, Double supplierCommissionPerc, String comments,
			Date lastUpdatedStamp, Date lastUpdatedTxStamp, Date createdStamp,
			Date createdTxStamp) {
		this.id = id;
		this.availableThruDate = availableThruDate;
		this.supplierPrefOrderId = supplierPrefOrderId;
		this.supplierRatingTypeId = supplierRatingTypeId;
		this.standardLeadTimeDays = standardLeadTimeDays;
		this.orderQtyIncrements = orderQtyIncrements;
		this.unitsIncluded = unitsIncluded;
		this.quantityUomId = quantityUomId;
		this.agreementId = agreementId;
		this.agreementItemSeqId = agreementItemSeqId;
		this.lastPrice = lastPrice;
		this.supplierProductName = supplierProductName;
		this.supplierProductId = supplierProductId;
		this.canDropShip = canDropShip;
		this.supplierCommissionPerc = supplierCommissionPerc;
		this.comments = comments;
		this.lastUpdatedStamp = lastUpdatedStamp;
		this.lastUpdatedTxStamp = lastUpdatedTxStamp;
		this.createdStamp = createdStamp;
		this.createdTxStamp = createdTxStamp;
	}

	// Property accessors

	public SupplierProductId getId() {
		return this.id;
	}

	public void setId(SupplierProductId id) {
		this.id = id;
	}

	public Date getAvailableThruDate() {
		return this.availableThruDate;
	}

	public void setAvailableThruDate(Date availableThruDate) {
		this.availableThruDate = availableThruDate;
	}

	public String getSupplierPrefOrderId() {
		return this.supplierPrefOrderId;
	}

	public void setSupplierPrefOrderId(String supplierPrefOrderId) {
		this.supplierPrefOrderId = supplierPrefOrderId;
	}

	public String getSupplierRatingTypeId() {
		return this.supplierRatingTypeId;
	}

	public void setSupplierRatingTypeId(String supplierRatingTypeId) {
		this.supplierRatingTypeId = supplierRatingTypeId;
	}

	public Double getStandardLeadTimeDays() {
		return this.standardLeadTimeDays;
	}

	public void setStandardLeadTimeDays(Double standardLeadTimeDays) {
		this.standardLeadTimeDays = standardLeadTimeDays;
	}

	public Double getOrderQtyIncrements() {
		return this.orderQtyIncrements;
	}

	public void setOrderQtyIncrements(Double orderQtyIncrements) {
		this.orderQtyIncrements = orderQtyIncrements;
	}

	public Double getUnitsIncluded() {
		return this.unitsIncluded;
	}

	public void setUnitsIncluded(Double unitsIncluded) {
		this.unitsIncluded = unitsIncluded;
	}

	public String getQuantityUomId() {
		return this.quantityUomId;
	}

	public void setQuantityUomId(String quantityUomId) {
		this.quantityUomId = quantityUomId;
	}

	public String getAgreementId() {
		return this.agreementId;
	}

	public void setAgreementId(String agreementId) {
		this.agreementId = agreementId;
	}

	public String getAgreementItemSeqId() {
		return this.agreementItemSeqId;
	}

	public void setAgreementItemSeqId(String agreementItemSeqId) {
		this.agreementItemSeqId = agreementItemSeqId;
	}

	public Double getLastPrice() {
		return this.lastPrice;
	}

	public void setLastPrice(Double lastPrice) {
		this.lastPrice = lastPrice;
	}

	public String getSupplierProductName() {
		return this.supplierProductName;
	}

	public void setSupplierProductName(String supplierProductName) {
		this.supplierProductName = supplierProductName;
	}

	public String getSupplierProductId() {
		return this.supplierProductId;
	}

	public void setSupplierProductId(String supplierProductId) {
		this.supplierProductId = supplierProductId;
	}

	public String getCanDropShip() {
		return this.canDropShip;
	}

	public void setCanDropShip(String canDropShip) {
		this.canDropShip = canDropShip;
	}

	public Double getSupplierCommissionPerc() {
		return this.supplierCommissionPerc;
	}

	public void setSupplierCommissionPerc(Double supplierCommissionPerc) {
		this.supplierCommissionPerc = supplierCommissionPerc;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
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