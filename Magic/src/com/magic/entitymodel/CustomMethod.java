package com.magic.entitymodel;

import java.sql.Timestamp;


/**
 * CustomMethod entity. @author MyEclipse Persistence Tools
 */

public class CustomMethod  implements java.io.Serializable {


    // Fields    

     private String customMethodId;
     private String customMethodTypeId;
     private String customMethodName;
     private String description;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public CustomMethod() {
    }

	/** minimal constructor */
    public CustomMethod(String customMethodId) {
        this.customMethodId = customMethodId;
    }
    
    /** full constructor */
    public CustomMethod(String customMethodId, String customMethodTypeId, String customMethodName, String description, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.customMethodId = customMethodId;
        this.customMethodTypeId = customMethodTypeId;
        this.customMethodName = customMethodName;
        this.description = description;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public String getCustomMethodId() {
        return this.customMethodId;
    }
    
    public void setCustomMethodId(String customMethodId) {
        this.customMethodId = customMethodId;
    }

    public String getCustomMethodTypeId() {
        return this.customMethodTypeId;
    }
    
    public void setCustomMethodTypeId(String customMethodTypeId) {
        this.customMethodTypeId = customMethodTypeId;
    }

    public String getCustomMethodName() {
        return this.customMethodName;
    }
    
    public void setCustomMethodName(String customMethodName) {
        this.customMethodName = customMethodName;
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