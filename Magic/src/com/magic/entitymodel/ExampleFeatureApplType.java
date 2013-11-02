package com.magic.entitymodel;

import java.sql.Timestamp;


/**
 * ExampleFeatureApplType entity. @author MyEclipse Persistence Tools
 */

public class ExampleFeatureApplType  implements java.io.Serializable {


    // Fields    

     private String exampleFeatureApplTypeId;
     private String parentTypeId;
     private String description;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public ExampleFeatureApplType() {
    }

	/** minimal constructor */
    public ExampleFeatureApplType(String exampleFeatureApplTypeId) {
        this.exampleFeatureApplTypeId = exampleFeatureApplTypeId;
    }
    
    /** full constructor */
    public ExampleFeatureApplType(String exampleFeatureApplTypeId, String parentTypeId, String description, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.exampleFeatureApplTypeId = exampleFeatureApplTypeId;
        this.parentTypeId = parentTypeId;
        this.description = description;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public String getExampleFeatureApplTypeId() {
        return this.exampleFeatureApplTypeId;
    }
    
    public void setExampleFeatureApplTypeId(String exampleFeatureApplTypeId) {
        this.exampleFeatureApplTypeId = exampleFeatureApplTypeId;
    }

    public String getParentTypeId() {
        return this.parentTypeId;
    }
    
    public void setParentTypeId(String parentTypeId) {
        this.parentTypeId = parentTypeId;
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