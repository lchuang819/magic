package com.apps.accounting.entitymodel;

import java.util.Date;

/**
 * GlAccount generated by MyEclipse Persistence Tools
 */

public class GlAccount extends com.magic.entitymodel.GenericEntity implements
		java.io.Serializable {

	// Fields

	private String glAccountId;

	private String glAccountTypeId;

	private String glAccountClassId;

	private String glResourceTypeId;

	private String glXbrlClassId;

	private String parentGlAccountId;

	private String accountCode;

	private String accountName;

	private String description;

	private String productId;

	private Double postedBalance;

	private Date lastUpdatedStamp;

	private Date lastUpdatedTxStamp;

	private Date createdStamp;

	private Date createdTxStamp;

	// Constructors

	/** default constructor */
	public GlAccount() {
	}

	/** minimal constructor */
	public GlAccount(String glAccountId) {
		this.glAccountId = glAccountId;
	}

	/** full constructor */
	public GlAccount(String glAccountId, String glAccountTypeId,
			String glAccountClassId, String glResourceTypeId,
			String glXbrlClassId, String parentGlAccountId, String accountCode,
			String accountName, String description, String productId,
			Double postedBalance, Date lastUpdatedStamp,
			Date lastUpdatedTxStamp, Date createdStamp, Date createdTxStamp) {
		this.glAccountId = glAccountId;
		this.glAccountTypeId = glAccountTypeId;
		this.glAccountClassId = glAccountClassId;
		this.glResourceTypeId = glResourceTypeId;
		this.glXbrlClassId = glXbrlClassId;
		this.parentGlAccountId = parentGlAccountId;
		this.accountCode = accountCode;
		this.accountName = accountName;
		this.description = description;
		this.productId = productId;
		this.postedBalance = postedBalance;
		this.lastUpdatedStamp = lastUpdatedStamp;
		this.lastUpdatedTxStamp = lastUpdatedTxStamp;
		this.createdStamp = createdStamp;
		this.createdTxStamp = createdTxStamp;
	}

	// Property accessors

	public String getGlAccountId() {
		return this.glAccountId;
	}

	public void setGlAccountId(String glAccountId) {
		this.glAccountId = glAccountId;
	}

	public String getGlAccountTypeId() {
		return this.glAccountTypeId;
	}

	public void setGlAccountTypeId(String glAccountTypeId) {
		this.glAccountTypeId = glAccountTypeId;
	}

	public String getGlAccountClassId() {
		return this.glAccountClassId;
	}

	public void setGlAccountClassId(String glAccountClassId) {
		this.glAccountClassId = glAccountClassId;
	}

	public String getGlResourceTypeId() {
		return this.glResourceTypeId;
	}

	public void setGlResourceTypeId(String glResourceTypeId) {
		this.glResourceTypeId = glResourceTypeId;
	}

	public String getGlXbrlClassId() {
		return this.glXbrlClassId;
	}

	public void setGlXbrlClassId(String glXbrlClassId) {
		this.glXbrlClassId = glXbrlClassId;
	}

	public String getParentGlAccountId() {
		return this.parentGlAccountId;
	}

	public void setParentGlAccountId(String parentGlAccountId) {
		this.parentGlAccountId = parentGlAccountId;
	}

	public String getAccountCode() {
		return this.accountCode;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	public String getAccountName() {
		return this.accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProductId() {
		return this.productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Double getPostedBalance() {
		return this.postedBalance;
	}

	public void setPostedBalance(Double postedBalance) {
		this.postedBalance = postedBalance;
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