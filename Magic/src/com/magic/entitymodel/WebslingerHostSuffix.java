package com.magic.entitymodel;

import java.sql.Timestamp;


/**
 * WebslingerHostSuffix entity. @author MyEclipse Persistence Tools
 */

public class WebslingerHostSuffix  implements java.io.Serializable {


    // Fields    

     private String hostSuffixId;
     private String hostSuffix;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public WebslingerHostSuffix() {
    }

	/** minimal constructor */
    public WebslingerHostSuffix(String hostSuffixId) {
        this.hostSuffixId = hostSuffixId;
    }
    
    /** full constructor */
    public WebslingerHostSuffix(String hostSuffixId, String hostSuffix, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.hostSuffixId = hostSuffixId;
        this.hostSuffix = hostSuffix;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public String getHostSuffixId() {
        return this.hostSuffixId;
    }
    
    public void setHostSuffixId(String hostSuffixId) {
        this.hostSuffixId = hostSuffixId;
    }

    public String getHostSuffix() {
        return this.hostSuffix;
    }
    
    public void setHostSuffix(String hostSuffix) {
        this.hostSuffix = hostSuffix;
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