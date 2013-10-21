package com.apps.catalog.entitymodel;

import java.util.Date;

/**
 * ProductCategoryType generated by MyEclipse Persistence Tools
 */

public class ProductCategoryType extends com.magic.entitymodel.GenericEntity
		implements java.io.Serializable {

	// Fields

	private String productCategoryTypeId;

	private String parentTypeId;

	private String hasTable;

	private String description;

	private Date lastUpdatedStamp;

	private Date lastUpdatedTxStamp;

	private Date createdStamp;

	private Date createdTxStamp;

	// Constructors

	/** default constructor */
	public ProductCategoryType() {
	}

	/** minimal constructor */
	public ProductCategoryType(String productCategoryTypeId) {
		this.productCategoryTypeId = productCategoryTypeId;
	}

	/** full constructor */
	public ProductCategoryType(String productCategoryTypeId,
			String parentTypeId, String hasTable, String description,
			Date lastUpdatedStamp, Date lastUpdatedTxStamp, Date createdStamp,
			Date createdTxStamp) {
		this.productCategoryTypeId = productCategoryTypeId;
		this.parentTypeId = parentTypeId;
		this.hasTable = hasTable;
		this.description = description;
		this.lastUpdatedStamp = lastUpdatedStamp;
		this.lastUpdatedTxStamp = lastUpdatedTxStamp;
		this.createdStamp = createdStamp;
		this.createdTxStamp = createdTxStamp;
	}

	// Property accessors

	public String getProductCategoryTypeId() {
		return this.productCategoryTypeId;
	}

	public void setProductCategoryTypeId(String productCategoryTypeId) {
		this.productCategoryTypeId = productCategoryTypeId;
	}

	public String getParentTypeId() {
		return this.parentTypeId;
	}

	public void setParentTypeId(String parentTypeId) {
		this.parentTypeId = parentTypeId;
	}

	public String getHasTable() {
		return this.hasTable;
	}

	public void setHasTable(String hasTable) {
		this.hasTable = hasTable;
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