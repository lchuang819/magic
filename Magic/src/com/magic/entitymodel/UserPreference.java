package com.magic.entitymodel;

import java.sql.Timestamp;


/**
 * UserPreference entity. @author MyEclipse Persistence Tools
 */

public class UserPreference  implements java.io.Serializable {


    // Fields    

     private UserPreferenceId id;
     private String userPrefGroupTypeId;
     private String userPrefValue;
     private String userPrefDataType;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public UserPreference() {
    }

	/** minimal constructor */
    public UserPreference(UserPreferenceId id) {
        this.id = id;
    }
    
    /** full constructor */
    public UserPreference(UserPreferenceId id, String userPrefGroupTypeId, String userPrefValue, String userPrefDataType, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.id = id;
        this.userPrefGroupTypeId = userPrefGroupTypeId;
        this.userPrefValue = userPrefValue;
        this.userPrefDataType = userPrefDataType;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public UserPreferenceId getId() {
        return this.id;
    }
    
    public void setId(UserPreferenceId id) {
        this.id = id;
    }

    public String getUserPrefGroupTypeId() {
        return this.userPrefGroupTypeId;
    }
    
    public void setUserPrefGroupTypeId(String userPrefGroupTypeId) {
        this.userPrefGroupTypeId = userPrefGroupTypeId;
    }

    public String getUserPrefValue() {
        return this.userPrefValue;
    }
    
    public void setUserPrefValue(String userPrefValue) {
        this.userPrefValue = userPrefValue;
    }

    public String getUserPrefDataType() {
        return this.userPrefDataType;
    }
    
    public void setUserPrefDataType(String userPrefDataType) {
        this.userPrefDataType = userPrefDataType;
    }

    public Timestamp getLastUpdatedStamp() {
        return this.lastUpdatedStamp;
    }
    
    public void setLastUpdatedStamp(Timestamp lastUpdatedStamp) {
        this.lastUpdatedStamp = lastUpdatedStamp;
    }

    public Timestamp getLastUpdatedTxStamp() {
        return this.lastUpdatedTxStamp;
    }
    
    public void setLastUpdatedTxStamp(Timestamp lastUpdatedTxStamp) {
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
    }

    public Timestamp getCreatedStamp() {
        return this.createdStamp;
    }
    
    public void setCreatedStamp(Timestamp createdStamp) {
        this.createdStamp = createdStamp;
    }

    public Timestamp getCreatedTxStamp() {
        return this.createdTxStamp;
    }
    
    public void setCreatedTxStamp(Timestamp createdTxStamp) {
        this.createdTxStamp = createdTxStamp;
    }
   








}