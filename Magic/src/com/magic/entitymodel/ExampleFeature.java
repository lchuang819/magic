package com.magic.entitymodel;

import java.sql.Timestamp;


/**
 * ExampleFeature entity. @author MyEclipse Persistence Tools
 */

public class ExampleFeature  implements java.io.Serializable {


    // Fields    

     private String exampleFeatureId;
     private String featureSourceEnumId;
     private String description;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public ExampleFeature() {
    }

	/** minimal constructor */
    public ExampleFeature(String exampleFeatureId) {
        this.exampleFeatureId = exampleFeatureId;
    }
    
    /** full constructor */
    public ExampleFeature(String exampleFeatureId, String featureSourceEnumId, String description, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.exampleFeatureId = exampleFeatureId;
        this.featureSourceEnumId = featureSourceEnumId;
        this.description = description;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public String getExampleFeatureId() {
        return this.exampleFeatureId;
    }
    
    public void setExampleFeatureId(String exampleFeatureId) {
        this.exampleFeatureId = exampleFeatureId;
    }

    public String getFeatureSourceEnumId() {
        return this.featureSourceEnumId;
    }
    
    public void setFeatureSourceEnumId(String featureSourceEnumId) {
        this.featureSourceEnumId = featureSourceEnumId;
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