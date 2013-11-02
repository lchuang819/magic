package com.magic.entitymodel;

import java.sql.Timestamp;


/**
 * BrowserType entity. @author MyEclipse Persistence Tools
 */

public class BrowserType  implements java.io.Serializable {


    // Fields    

     private String browserTypeId;
     private String browserName;
     private String browserVersion;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public BrowserType() {
    }

	/** minimal constructor */
    public BrowserType(String browserTypeId) {
        this.browserTypeId = browserTypeId;
    }
    
    /** full constructor */
    public BrowserType(String browserTypeId, String browserName, String browserVersion, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.browserTypeId = browserTypeId;
        this.browserName = browserName;
        this.browserVersion = browserVersion;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public String getBrowserTypeId() {
        return this.browserTypeId;
    }
    
    public void setBrowserTypeId(String browserTypeId) {
        this.browserTypeId = browserTypeId;
    }

    public String getBrowserName() {
        return this.browserName;
    }
    
    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }

    public String getBrowserVersion() {
        return this.browserVersion;
    }
    
    public void setBrowserVersion(String browserVersion) {
        this.browserVersion = browserVersion;
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