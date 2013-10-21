package com.apps.product.entitymodel;

import java.util.Date;

/**
 * ProductPricePurpose generated by MyEclipse Persistence Tools
 */

public class ProductPricePurpose extends com.magic.entitymodel.GenericEntity
		implements java.io.Serializable {

	// Fields

	private String productPricePurposeId;

	private String description;

	private Date lastUpdatedStamp;

	private Date lastUpdatedTxStamp;

	private Date createdStamp;

	private Date createdTxStamp;

	// Constructors

	/** default constructor */
	public ProductPricePurpose() {
	}

	/** minimal constructor */
	public ProductPricePurpose(String productPricePurposeId) {
		this.productPricePurposeId = productPricePurposeId;
	}

	/** full constructor */
	public ProductPricePurpose(String productPricePurposeId,
			String description, Date lastUpdatedStamp, Date lastUpdatedTxStamp,
			Date createdStamp, Date createdTxStamp) {
		this.productPricePurposeId = productPricePurposeId;
		this.description = description;
		this.lastUpdatedStamp = lastUpdatedStamp;
		this.lastUpdatedTxStamp = lastUpdatedTxStamp;
		this.createdStamp = createdStamp;
		this.createdTxStamp = createdTxStamp;
	}

	// Property accessors

	public String getProductPricePurposeId() {
		return this.productPricePurposeId;
	}

	public void setProductPricePurposeId(String productPricePurposeId) {
		this.productPricePurposeId = productPricePurposeId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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