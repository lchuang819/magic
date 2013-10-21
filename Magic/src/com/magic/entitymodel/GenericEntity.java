/**
 * Powered by Chuang.Liu @2011-10-16
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.magic.entitymodel;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lchuang
 * @2011-10-16
 */
public abstract class GenericEntity implements Serializable {

	private Date lastUpdatedStamp;

	private Date lastUpdatedTxStamp;

	private Date createdStamp;

	private Date createdTxStamp;

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
