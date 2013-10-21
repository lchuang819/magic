package com.apps.product.entitymodel;

import java.util.Date;

/**
 * ProductPrice generated by MyEclipse Persistence Tools
 */

public class ProductPrice extends com.magic.entitymodel.GenericEntity implements
		java.io.Serializable {

	// Fields

	private ProductPriceId id;

	private Date thruDate;

	private Double price;

	private String termUomId;

	private String customPriceCalcService;

	private Date createdDate;

	private String createdByUserLogin;

	private Date lastModifiedDate;

	private String lastModifiedByUserLogin;

	private Date lastUpdatedStamp;

	private Date lastUpdatedTxStamp;

	private Date createdStamp;

	private Date createdTxStamp;

	// Constructors

	/** default constructor */
	public ProductPrice() {
	}

	/** minimal constructor */
	public ProductPrice(ProductPriceId id) {
		this.id = id;
	}

	/** full constructor */
	public ProductPrice(ProductPriceId id, Date thruDate, Double price,
			String termUomId, String customPriceCalcService, Date createdDate,
			String createdByUserLogin, Date lastModifiedDate,
			String lastModifiedByUserLogin, Date lastUpdatedStamp,
			Date lastUpdatedTxStamp, Date createdStamp, Date createdTxStamp) {
		this.id = id;
		this.thruDate = thruDate;
		this.price = price;
		this.termUomId = termUomId;
		this.customPriceCalcService = customPriceCalcService;
		this.createdDate = createdDate;
		this.createdByUserLogin = createdByUserLogin;
		this.lastModifiedDate = lastModifiedDate;
		this.lastModifiedByUserLogin = lastModifiedByUserLogin;
		this.lastUpdatedStamp = lastUpdatedStamp;
		this.lastUpdatedTxStamp = lastUpdatedTxStamp;
		this.createdStamp = createdStamp;
		this.createdTxStamp = createdTxStamp;
	}

	// Property accessors

	public ProductPriceId getId() {
		return this.id;
	}

	public void setId(ProductPriceId id) {
		this.id = id;
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

	public String getTermUomId() {
		return this.termUomId;
	}

	public void setTermUomId(String termUomId) {
		this.termUomId = termUomId;
	}

	public String getCustomPriceCalcService() {
		return this.customPriceCalcService;
	}

	public void setCustomPriceCalcService(String customPriceCalcService) {
		this.customPriceCalcService = customPriceCalcService;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedByUserLogin() {
		return this.createdByUserLogin;
	}

	public void setCreatedByUserLogin(String createdByUserLogin) {
		this.createdByUserLogin = createdByUserLogin;
	}

	public Date getLastModifiedDate() {
		return this.lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getLastModifiedByUserLogin() {
		return this.lastModifiedByUserLogin;
	}

	public void setLastModifiedByUserLogin(String lastModifiedByUserLogin) {
		this.lastModifiedByUserLogin = lastModifiedByUserLogin;
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