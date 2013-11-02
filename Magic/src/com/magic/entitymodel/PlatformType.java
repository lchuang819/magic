package com.magic.entitymodel;

import java.sql.Timestamp;


/**
 * PlatformType entity. @author MyEclipse Persistence Tools
 */

public class PlatformType  implements java.io.Serializable {


    // Fields    

     private String platformTypeId;
     private String platformName;
     private String platformVersion;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public PlatformType() {
    }

	/** minimal constructor */
    public PlatformType(String platformTypeId) {
        this.platformTypeId = platformTypeId;
    }
    
    /** full constructor */
    public PlatformType(String platformTypeId, String platformName, String platformVersion, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.platformTypeId = platformTypeId;
        this.platformName = platformName;
        this.platformVersion = platformVersion;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public String getPlatformTypeId() {
        return this.platformTypeId;
    }
    
    public void setPlatformTypeId(String platformTypeId) {
        this.platformTypeId = platformTypeId;
    }

    public String getPlatformName() {
        return this.platformName;
    }
    
    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getPlatformVersion() {
        return this.platformVersion;
    }
    
    public void setPlatformVersion(String platformVersion) {
        this.platformVersion = platformVersion;
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