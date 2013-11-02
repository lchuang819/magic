package com.magic.entitymodel;

import java.sql.Timestamp;


/**
 * UserLoginSession entity. @author MyEclipse Persistence Tools
 */

public class UserLoginSession  implements java.io.Serializable {


    // Fields    

     private String userLoginId;
     private Timestamp savedDate;
     private String sessionData;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public UserLoginSession() {
    }

	/** minimal constructor */
    public UserLoginSession(String userLoginId) {
        this.userLoginId = userLoginId;
    }
    
    /** full constructor */
    public UserLoginSession(String userLoginId, Timestamp savedDate, String sessionData, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.userLoginId = userLoginId;
        this.savedDate = savedDate;
        this.sessionData = sessionData;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public String getUserLoginId() {
        return this.userLoginId;
    }
    
    public void setUserLoginId(String userLoginId) {
        this.userLoginId = userLoginId;
    }

    public Timestamp getSavedDate() {
        return this.savedDate;
    }
    
    public void setSavedDate(Timestamp savedDate) {
        this.savedDate = savedDate;
    }

    public String getSessionData() {
        return this.sessionData;
    }
    
    public void setSessionData(String sessionData) {
        this.sessionData = sessionData;
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