package com.magic.entitymodel;

import java.sql.Timestamp;


/**
 * UserLoginHistory entity. @author MyEclipse Persistence Tools
 */

public class UserLoginHistory  implements java.io.Serializable {


    // Fields    

     private UserLoginHistoryId id;
     private String visitId;
     private Timestamp thruDate;
     private String passwordUsed;
     private String successfulLogin;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public UserLoginHistory() {
    }

	/** minimal constructor */
    public UserLoginHistory(UserLoginHistoryId id) {
        this.id = id;
    }
    
    /** full constructor */
    public UserLoginHistory(UserLoginHistoryId id, String visitId, Timestamp thruDate, String passwordUsed, String successfulLogin, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.id = id;
        this.visitId = visitId;
        this.thruDate = thruDate;
        this.passwordUsed = passwordUsed;
        this.successfulLogin = successfulLogin;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public UserLoginHistoryId getId() {
        return this.id;
    }
    
    public void setId(UserLoginHistoryId id) {
        this.id = id;
    }

    public String getVisitId() {
        return this.visitId;
    }
    
    public void setVisitId(String visitId) {
        this.visitId = visitId;
    }

    public Timestamp getThruDate() {
        return this.thruDate;
    }
    
    public void setThruDate(Timestamp thruDate) {
        this.thruDate = thruDate;
    }

    public String getPasswordUsed() {
        return this.passwordUsed;
    }
    
    public void setPasswordUsed(String passwordUsed) {
        this.passwordUsed = passwordUsed;
    }

    public String getSuccessfulLogin() {
        return this.successfulLogin;
    }
    
    public void setSuccessfulLogin(String successfulLogin) {
        this.successfulLogin = successfulLogin;
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