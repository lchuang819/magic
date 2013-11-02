package com.magic.entitymodel;

import java.sql.Timestamp;


/**
 * TestingNode entity. @author MyEclipse Persistence Tools
 */

public class TestingNode  implements java.io.Serializable {


    // Fields    

     private String testingNodeId;
     private String primaryParentNodeId;
     private String description;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public TestingNode() {
    }

	/** minimal constructor */
    public TestingNode(String testingNodeId) {
        this.testingNodeId = testingNodeId;
    }
    
    /** full constructor */
    public TestingNode(String testingNodeId, String primaryParentNodeId, String description, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.testingNodeId = testingNodeId;
        this.primaryParentNodeId = primaryParentNodeId;
        this.description = description;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public String getTestingNodeId() {
        return this.testingNodeId;
    }
    
    public void setTestingNodeId(String testingNodeId) {
        this.testingNodeId = testingNodeId;
    }

    public String getPrimaryParentNodeId() {
        return this.primaryParentNodeId;
    }
    
    public void setPrimaryParentNodeId(String primaryParentNodeId) {
        this.primaryParentNodeId = primaryParentNodeId;
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