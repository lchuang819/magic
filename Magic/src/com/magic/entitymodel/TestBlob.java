package com.magic.entitymodel;

import java.sql.Timestamp;


/**
 * TestBlob entity. @author MyEclipse Persistence Tools
 */

public class TestBlob  implements java.io.Serializable {


    // Fields    

     private String testBlobId;
     private String testBlobField;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public TestBlob() {
    }

	/** minimal constructor */
    public TestBlob(String testBlobId) {
        this.testBlobId = testBlobId;
    }
    
    /** full constructor */
    public TestBlob(String testBlobId, String testBlobField, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.testBlobId = testBlobId;
        this.testBlobField = testBlobField;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public String getTestBlobId() {
        return this.testBlobId;
    }
    
    public void setTestBlobId(String testBlobId) {
        this.testBlobId = testBlobId;
    }

    public String getTestBlobField() {
        return this.testBlobField;
    }
    
    public void setTestBlobField(String testBlobField) {
        this.testBlobField = testBlobField;
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