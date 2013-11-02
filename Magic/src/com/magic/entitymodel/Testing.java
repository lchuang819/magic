package com.magic.entitymodel;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * Testing entity. @author MyEclipse Persistence Tools
 */

public class Testing  implements java.io.Serializable {


    // Fields    

     private String testingId;
     private String testingTypeId;
     private String testingName;
     private String description;
     private String comments;
     private BigDecimal testingSize;
     private Timestamp testingDate;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public Testing() {
    }

	/** minimal constructor */
    public Testing(String testingId) {
        this.testingId = testingId;
    }
    
    /** full constructor */
    public Testing(String testingId, String testingTypeId, String testingName, String description, String comments, BigDecimal testingSize, Timestamp testingDate, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.testingId = testingId;
        this.testingTypeId = testingTypeId;
        this.testingName = testingName;
        this.description = description;
        this.comments = comments;
        this.testingSize = testingSize;
        this.testingDate = testingDate;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public String getTestingId() {
        return this.testingId;
    }
    
    public void setTestingId(String testingId) {
        this.testingId = testingId;
    }

    public String getTestingTypeId() {
        return this.testingTypeId;
    }
    
    public void setTestingTypeId(String testingTypeId) {
        this.testingTypeId = testingTypeId;
    }

    public String getTestingName() {
        return this.testingName;
    }
    
    public void setTestingName(String testingName) {
        this.testingName = testingName;
    }

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public String getComments() {
        return this.comments;
    }
    
    public void setComments(String comments) {
        this.comments = comments;
    }

    public BigDecimal getTestingSize() {
        return this.testingSize;
    }
    
    public void setTestingSize(BigDecimal testingSize) {
        this.testingSize = testingSize;
    }

    public Timestamp getTestingDate() {
        return this.testingDate;
    }
    
    public void setTestingDate(Timestamp testingDate) {
        this.testingDate = testingDate;
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