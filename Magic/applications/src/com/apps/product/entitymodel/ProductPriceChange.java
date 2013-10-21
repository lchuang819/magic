package com.apps.product.entitymodel;

import java.util.Date;

/**
 * ProductPriceChange generated by MyEclipse Persistence Tools
 */

public class ProductPriceChange extends com.magic.entitymodel.GenericEntity
		implements java.io.Serializable {

	// Fields

	private String productPriceChangeId;

	private String productId;

	private String productPriceTypeId;

	private String productPricePurposeId;

	private String currencyUomId;

	private String productStoreGroupId;

	private Date fromDate;

	private Date thruDate;

	private Double price;

	private Double oldPrice;

	private Date changedDate;

	private String changedByUserLogin;

	private Date lastUpdatedStamp;

	private Date lastUpdatedTxStamp;

	private Date createdStamp;

	private Date createdTxStamp;

	// Constructors

	/** default constructor */
	public ProductPriceChange() {
	}

	/** minimal constructor */
	public ProductPriceChange(String productPriceChangeId) {
		this.productPriceChangeId = productPriceChangeId;
	}

	/** full constructor */
	public ProductPriceChange(String productPriceChangeId, String productId,
			String productPriceTypeId, String productPricePurposeId,
			String currencyUomId, String productStoreGroupId, Date fromDate,
			Date thruDate, Double price, Double oldPrice, Date changedDate,
			String changedByUserLogin, Date lastUpdatedStamp,
			Date lastUpdatedTxStamp, Date createdStamp, Date createdTxStamp) {
		this.productPriceChangeId = productPriceChangeId;
		this.productId = productId;
		this.productPriceTypeId = productPriceTypeId;
		this.productPricePurposeId = productPricePurposeId;
		this.currencyUomId = currencyUomId;
		this.productStoreGroupId = productStoreGroupId;
		this.fromDate = fromDate;
		this.thruDate = thruDate;
		this.price = price;
		this.oldPrice = oldPrice;
		this.changedDate = changedDate;
		this.changedByUserLogin = changedByUserLogin;
		this.lastUpdatedStamp = lastUpdatedStamp;
		this.lastUpdatedTxStamp = lastUpdatedTxStamp;
		this.createdStamp = createdStamp;
		this.createdTxStamp = createdTxStamp;
	}

	// Property accessors

	public String getProductPriceChangeId() {
		return this.productPriceChangeId;
	}

	public void setProductPriceChangeId(String productPriceChangeId) {
		this.productPriceChangeId = productPriceChangeId;
	}

	public String getProductId() {
		return this.productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductPriceTypeId() {
		return this.productPriceTypeId;
	}

	public void setProductPriceTypeId(String productPriceTypeId) {
		this.productPriceTypeId = productPriceTypeId;
	}

	public String getProductPricePurposeId() {
		return this.productPricePurposeId;
	}

	public void setProductPricePurposeId(String productPricePurposeId) {
		this.productPricePurposeId = productPricePurposeId;
	}

	public String getCurrencyUomId() {
		return this.currencyUomId;
	}

	public void setCurrencyUomId(String currencyUomId) {
		this.currencyUomId = currencyUomId;
	}

	public String getProductStoreGroupId() {
		return this.productStoreGroupId;
	}

	public void setProductStoreGroupId(String productStoreGroupId) {
		this.productStoreGroupId = productStoreGroupId;
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

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getOldPrice() {
		return this.oldPrice;
	}

	public void setOldPrice(Double oldPrice) {
		this.oldPrice = oldPrice;
	}

	public Date getChangedDate() {
		return this.changedDate;
	}

	public void setChangedDate(Date changedDate) {
		this.changedDate = changedDate;
	}

	public String getChangedByUserLogin() {
		return this.changedByUserLogin;
	}

	public void setChangedByUserLogin(String changedByUserLogin) {
		this.changedByUserLogin = changedByUserLogin;
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