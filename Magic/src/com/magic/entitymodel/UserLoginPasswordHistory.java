package com.magic.entitymodel;

import java.sql.Timestamp;


/**
 * UserLoginPasswordHistory entity. @author MyEclipse Persistence Tools
 */

public class UserLoginPasswordHistory  implements java.io.Serializable {


    // Fields    

     private UserLoginPasswordHistoryId id;
     private Timestamp thruDate;
     private String currentPassword;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public UserLoginPasswordHistory() {
    }

	/** minimal constructor */
    public UserLoginPasswordHistory(UserLoginPasswordHistoryId id) {
        this.id = id;
    }
    
    /** full constructor */
    public UserLoginPasswordHistory(UserLoginPasswordHistoryId id, Timestamp thruDate, String currentPassword, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.id = id;
        this.thruDate = thruDate;
        this.currentPassword = currentPassword;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public UserLoginPasswordHistoryId getId() {
        return this.id;
    }
    
    public void setId(UserLoginPasswordHistoryId id) {
        this.id = id;
    }

    public Timestamp getThruDate() {
        return this.thruDate;
    }
    
    public void setThruDate(Timestamp thruDate) {
        this.thruDate = thruDate;
    }

    public String getCurrentPassword() {
        return this.currentPassword;
    }
    
    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
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