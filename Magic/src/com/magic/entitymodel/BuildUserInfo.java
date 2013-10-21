package com.magic.entitymodel;

import java.util.Date;

/**
 * BuildUserInfo entity.
 * 
 * @author MyEclipse Persistence Tools
 */
public class BuildUserInfo implements
		java.io.Serializable {

	private String userId;
	private String nickName;
	private String userNo;
	private String description;
	private String enabled;
	private String reputationValue;
	private String prestigeValue;
	private String goldValue;
	private String silverValue;
	private String copperValue;
	private String expValue;
	private String levelValue;
	private String registerDate;
	private String sex;
	private String email;
	private String userAddress;
	private String postalCode;
	private String mobileTelNo;
	private String phoneNo;
	private Date lastUpdatedStamp;
	private Date lastUpdatedTxStamp;
	private Date createdStamp;
	private Date createdTxStamp;
	private String userTypeId;
	// Constructors

	/** default constructor */
	public BuildUserInfo() {
	}

	/** minimal constructor */
	public BuildUserInfo(String userId) {
		this.userId = userId;
	}


	/**
	 * @param userId
	 * @param nickName
	 * @param userNo
	 * @param description
	 * @param enabled
	 * @param reputationValue
	 * @param prestigeValue
	 * @param goldValue
	 * @param silverValue
	 * @param copperValue
	 * @param expValue
	 * @param levelValue
	 * @param registerDate
	 * @param sex
	 * @param email
	 * @param userAddress
	 * @param postalCode
	 * @param mobileTelNo
	 * @param phoneNo
	 * @param lastUpdatedStamp
	 * @param lastUpdatedTxStamp
	 * @param createdStamp
	 * @param createdTxStamp
	 * @param userTypeId
	 */
	public BuildUserInfo(String userId, String nickName, String userNo,
			String description, String enabled, String reputationValue,
			String prestigeValue, String goldValue, String silverValue,
			String copperValue, String expValue, String levelValue,
			String registerDate, String sex, String email, String userAddress,
			String postalCode, String mobileTelNo, String phoneNo,
			Date lastUpdatedStamp, Date lastUpdatedTxStamp, Date createdStamp,
			Date createdTxStamp, String userTypeId) {
		super();
		this.userId = userId;
		this.nickName = nickName;
		this.userNo = userNo;
		this.description = description;
		this.enabled = enabled;
		this.reputationValue = reputationValue;
		this.prestigeValue = prestigeValue;
		this.goldValue = goldValue;
		this.silverValue = silverValue;
		this.copperValue = copperValue;
		this.expValue = expValue;
		this.levelValue = levelValue;
		this.registerDate = registerDate;
		this.sex = sex;
		this.email = email;
		this.userAddress = userAddress;
		this.postalCode = postalCode;
		this.mobileTelNo = mobileTelNo;
		this.phoneNo = phoneNo;
		this.lastUpdatedStamp = lastUpdatedStamp;
		this.lastUpdatedTxStamp = lastUpdatedTxStamp;
		this.createdStamp = createdStamp;
		this.createdTxStamp = createdTxStamp;
		this.userTypeId = userTypeId;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the nickName
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * @param nickName the nickName to set
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * @return the userNo
	 */
	public String getUserNo() {
		return userNo;
	}

	/**
	 * @param userNo the userNo to set
	 */
	public void setUserNo(String userNo) {
		this.userNo = userNo;
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
	 * @return the reputationValue
	 */
	public String getReputationValue() {
		return reputationValue;
	}

	/**
	 * @param reputationValue the reputationValue to set
	 */
	public void setReputationValue(String reputationValue) {
		this.reputationValue = reputationValue;
	}

	/**
	 * @return the prestigeValue
	 */
	public String getPrestigeValue() {
		return prestigeValue;
	}

	/**
	 * @param prestigeValue the prestigeValue to set
	 */
	public void setPrestigeValue(String prestigeValue) {
		this.prestigeValue = prestigeValue;
	}

	/**
	 * @return the goldValue
	 */
	public String getGoldValue() {
		return goldValue;
	}

	/**
	 * @param goldValue the goldValue to set
	 */
	public void setGoldValue(String goldValue) {
		this.goldValue = goldValue;
	}

	/**
	 * @return the silverValue
	 */
	public String getSilverValue() {
		return silverValue;
	}

	/**
	 * @param silverValue the silverValue to set
	 */
	public void setSilverValue(String silverValue) {
		this.silverValue = silverValue;
	}

	/**
	 * @return the copperValue
	 */
	public String getCopperValue() {
		return copperValue;
	}

	/**
	 * @param copperValue the copperValue to set
	 */
	public void setCopperValue(String copperValue) {
		this.copperValue = copperValue;
	}

	/**
	 * @return the expValue
	 */
	public String getExpValue() {
		return expValue;
	}

	/**
	 * @param expValue the expValue to set
	 */
	public void setExpValue(String expValue) {
		this.expValue = expValue;
	}

	/**
	 * @return the levelValue
	 */
	public String getLevelValue() {
		return levelValue;
	}

	/**
	 * @param levelValue the levelValue to set
	 */
	public void setLevelValue(String levelValue) {
		this.levelValue = levelValue;
	}

	/**
	 * @return the registerDate
	 */
	public String getRegisterDate() {
		return registerDate;
	}

	/**
	 * @param registerDate the registerDate to set
	 */
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the userAddress
	 */
	public String getUserAddress() {
		return userAddress;
	}

	/**
	 * @param userAddress the userAddress to set
	 */
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * @return the mobileTelNo
	 */
	public String getMobileTelNo() {
		return mobileTelNo;
	}

	/**
	 * @param mobileTelNo the mobileTelNo to set
	 */
	public void setMobileTelNo(String mobileTelNo) {
		this.mobileTelNo = mobileTelNo;
	}

	/**
	 * @return the phoneNo
	 */
	public String getPhoneNo() {
		return phoneNo;
	}

	/**
	 * @param phoneNo the phoneNo to set
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
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
	
}
