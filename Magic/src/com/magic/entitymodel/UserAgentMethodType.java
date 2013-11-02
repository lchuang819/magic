package com.magic.entitymodel;

import java.sql.Timestamp;


/**
 * UserAgentMethodType entity. @author MyEclipse Persistence Tools
 */

public class UserAgentMethodType  implements java.io.Serializable {


    // Fields    

     private String userAgentMethodTypeId;
     private String description;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public UserAgentMethodType() {
    }

	/** minimal constructor */
    public UserAgentMethodType(String userAgentMethodTypeId) {
        this.userAgentMethodTypeId = userAgentMethodTypeId;
    }
    
    /** full constructor */
    public UserAgentMethodType(String userAgentMethodTypeId, String description, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.userAgentMethodTypeId = userAgentMethodTypeId;
        this.description = description;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public String getUserAgentMethodTypeId() {
        return this.userAgentMethodTypeId;
    }
    
    public void setUserAgentMethodTypeId(String userAgentMethodTypeId) {
        this.userAgentMethodTypeId = userAgentMethodTypeId;
    }

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
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