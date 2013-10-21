/**
 * Powered by Chuang.Liu @2011-9-29
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.magic.entitymodel;

import java.util.Date;

/**
 * @author lchuang
 * @2011-9-29
 */
public class CountryCode implements java.io.Serializable{

	private String countryCode;
	private String countryAbbr;
	private String countryNumber;
	private String countryName;
	private Date lastUpdatedStamp;
	private Date lastUpdatedTxStamp;
	private Date createdStamp;
	private Date createdTxStamp;
	public CountryCode(String countryCode, String countryAbbr,
			String countryNumber, String countryName, Date lastUpdatedStamp,
			Date lastUpdatedTxStamp, Date createdStamp, Date createdTxStamp) {
		super();
		this.countryCode = countryCode;
		this.countryAbbr = countryAbbr;
		this.countryNumber = countryNumber;
		this.countryName = countryName;
		this.lastUpdatedStamp = lastUpdatedStamp;
		this.lastUpdatedTxStamp = lastUpdatedTxStamp;
		this.createdStamp = createdStamp;
		this.createdTxStamp = createdTxStamp;
	}
	
	public CountryCode() {
	}
	
	public CountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}
	/**
	 * @param countryCode the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	/**
	 * @return the countryAbbr
	 */
	public String getCountryAbbr() {
		return countryAbbr;
	}
	/**
	 * @param countryAbbr the countryAbbr to set
	 */
	public void setCountryAbbr(String countryAbbr) {
		this.countryAbbr = countryAbbr;
	}
	/**
	 * @return the countryNumber
	 */
	public String getCountryNumber() {
		return countryNumber;
	}
	/**
	 * @param countryNumber the countryNumber to set
	 */
	public void setCountryNumber(String countryNumber) {
		this.countryNumber = countryNumber;
	}
	/**
	 * @return the countryName
	 */
	public String getCountryName() {
		return countryName;
	}
	/**
	 * @param countryName the countryName to set
	 */
	public void setCountryName(String countryName) {
		this.countryName = countryName;
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
