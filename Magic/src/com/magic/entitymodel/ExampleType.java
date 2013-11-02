package com.magic.entitymodel;

import java.sql.Timestamp;


/**
 * ExampleType entity. @author MyEclipse Persistence Tools
 */

public class ExampleType  implements java.io.Serializable {


    // Fields    

     private String exampleTypeId;
     private String parentTypeId;
     private String description;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public ExampleType() {
    }

	/** minimal constructor */
    public ExampleType(String exampleTypeId) {
        this.exampleTypeId = exampleTypeId;
    }
    
    /** full constructor */
    public ExampleType(String exampleTypeId, String parentTypeId, String description, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.exampleTypeId = exampleTypeId;
        this.parentTypeId = parentTypeId;
        this.description = description;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public String getExampleTypeId() {
        return this.exampleTypeId;
    }
    
    public void setExampleTypeId(String exampleTypeId) {
        this.exampleTypeId = exampleTypeId;
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