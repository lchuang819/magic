package com.magic.entitymodel;

import java.util.Date;

/**
 * BuildUserType entity.
 * 
 * @author MyEclipse Persistence Tools
 */
public class BuildUserType extends GenericEntity implements
		java.io.Serializable {
	// Fields

	private String userTypeId;
	private String enabled;
	private String description;
	private Date lastUpdatedStamp;
	private Date lastUpdatedTxStamp;
	private Date createdStamp;
	private Date createdTxStamp;
	
	// Constructors

	/** default constructor */
	public BuildUserType() {
	}

	/** minimal constructor */
	public BuildUserType(String userTypeId) {
		this.userTypeId = userTypeId;
	}



	/**
	 * @param userTypeId
	 * @param enabled
	 * @param description
	 * @param lastUpdatedStamp
	 * @param lastUpdatedTxStamp
	 * @param createdStamp
	 * @param createdTxStamp
	 */
	public BuildUserType(String userTypeId, String enabled, String description,
			Date lastUpdatedStamp, Date lastUpdatedTxStamp, Date createdStamp,
			Date createdTxStamp) {
		super();
		this.userTypeId = userTypeId;
		this.enabled = enabled;
		this.description = description;
		this.lastUpdatedStamp = lastUpdatedStamp;
		this.lastUpdatedTxStamp = lastUpdatedTxStamp;
		this.createdStamp = createdStamp;
		this.createdTxStamp = createdTxStamp;
	}

	/**
	 * @return the userTypeId
	 */
	public String getUserTypeId() {
		return userTypeId;
	}

	/**
	 * @param userTypeId the userTypeId to set
	 */
	public void setUserTypeId(String userTypeId) {
		this.userTypeId = userTypeId;
	}

	/**
	 * @return the enabled
	 */
	public String getEnabled() {
		return enabled;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the lastUpdatedStamp
	 */
	public Date getLastUpdatedStamp() {
		return lastUpdatedStamp;
	}

	/**
	 * @param lastUpdatedStamp the lastUpdatedStamp to set
	 */
	public void setLastUpdatedStamp(Date lastUpdatedStamp) {
		this.lastUpdatedStamp = lastUpdatedStamp;
	}

	/**
	 * @return the lastUpdatedTxStamp
	 */
	public Date getLastUpdatedTxStamp() {
		return lastUpdatedTxStamp;
	}

	/**
	 * @param lastUpdatedTxStamp the lastUpdatedTxStamp to set
	 */
	public void setLastUpdatedTxStamp(Date lastUpdatedTxStamp) {
		this.lastUpdatedTxStamp = lastUpdatedTxStamp;
	}

	/**
	 * @return the createdStamp
	 */
	public Date getCreatedStamp() {
		return createdStamp;
	}

	/**
	 * @param createdStamp the createdStamp to set
	 */
	public void setCreatedStamp(Date createdStamp) {
		this.createdStamp = createdStamp;
	}

	/**
	 * @return the createdTxStamp
	 */
	public Date getCreatedTxStamp() {
		return createdTxStamp;
	}

	/**
	 * @param createdTxStamp the createdTxStamp to set
	 */
	public void setCreatedTxStamp(Date createdTxStamp) {
		this.createdTxStamp = createdTxStamp;
	}
	
}
