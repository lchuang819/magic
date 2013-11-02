package com.magic.entitymodel;

import java.sql.Timestamp;


/**
 * UserAgent entity. @author MyEclipse Persistence Tools
 */

public class UserAgent  implements java.io.Serializable {


    // Fields    

     private String userAgentId;
     private String browserTypeId;
     private String platformTypeId;
     private String protocolTypeId;
     private String userAgentTypeId;
     private String userAgentMethodTypeId;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public UserAgent() {
    }

	/** minimal constructor */
    public UserAgent(String userAgentId) {
        this.userAgentId = userAgentId;
    }
    
    /** full constructor */
    public UserAgent(String userAgentId, String browserTypeId, String platformTypeId, String protocolTypeId, String userAgentTypeId, String userAgentMethodTypeId, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.userAgentId = userAgentId;
        this.browserTypeId = browserTypeId;
        this.platformTypeId = platformTypeId;
        this.protocolTypeId = protocolTypeId;
        this.userAgentTypeId = userAgentTypeId;
        this.userAgentMethodTypeId = userAgentMethodTypeId;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public String getUserAgentId() {
        return this.userAgentId;
    }
    
    public void setUserAgentId(String userAgentId) {
        this.userAgentId = userAgentId;
    }

    public String getBrowserTypeId() {
        return this.browserTypeId;
    }
    
    public void setBrowserTypeId(String browserTypeId) {
        this.browserTypeId = browserTypeId;
    }

    public String getPlatformTypeId() {
        return this.platformTypeId;
    }
    
    public void setPlatformTypeId(String platformTypeId) {
        this.platformTypeId = platformTypeId;
    }

    public String getProtocolTypeId() {
        return this.protocolTypeId;
    }
    
    public void setProtocolTypeId(String protocolTypeId) {
        this.protocolTypeId = protocolTypeId;
    }

    public String getUserAgentTypeId() {
        return this.userAgentTypeId;
    }
    
    public void setUserAgentTypeId(String userAgentTypeId) {
        this.userAgentTypeId = userAgentTypeId;
    }

    public String getUserAgentMethodTypeId() {
        return this.userAgentMethodTypeId;
    }
    
    public void setUserAgentMethodTypeId(String userAgentMethodTypeId) {
        this.userAgentMethodTypeId = userAgentMethodTypeId;
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