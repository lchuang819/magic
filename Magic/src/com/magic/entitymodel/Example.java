package com.magic.entitymodel;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * Example entity. @author MyEclipse Persistence Tools
 */

public class Example  implements java.io.Serializable {


    // Fields    

     private String exampleId;
     private String exampleTypeId;
     private String statusId;
     private String exampleName;
     private String description;
     private String longDescription;
     private String comments;
     private BigDecimal exampleSize;
     private Timestamp exampleDate;
     private Timestamp anotherDate;
     private String anotherText;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public Example() {
    }

	/** minimal constructor */
    public Example(String exampleId) {
        this.exampleId = exampleId;
    }
    
    /** full constructor */
    public Example(String exampleId, String exampleTypeId, String statusId, String exampleName, String description, String longDescription, String comments, BigDecimal exampleSize, Timestamp exampleDate, Timestamp anotherDate, String anotherText, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.exampleId = exampleId;
        this.exampleTypeId = exampleTypeId;
        this.statusId = statusId;
        this.exampleName = exampleName;
        this.description = description;
        this.longDescription = longDescription;
        this.comments = comments;
        this.exampleSize = exampleSize;
        this.exampleDate = exampleDate;
        this.anotherDate = anotherDate;
        this.anotherText = anotherText;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public String getExampleId() {
        return this.exampleId;
    }
    
    public void setExampleId(String exampleId) {
        this.exampleId = exampleId;
    }

    public String getExampleTypeId() {
        return this.exampleTypeId;
    }
    
    public void setExampleTypeId(String exampleTypeId) {
        this.exampleTypeId = exampleTypeId;
    }

    public String getStatusId() {
        return this.statusId;
    }
    
    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public String getExampleName() {
        return this.exampleName;
    }
    
    public void setExampleName(String exampleName) {
        this.exampleName = exampleName;
    }

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public String getLongDescription() {
        return this.longDescription;
    }
    
    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getComments() {
        return this.comments;
    }
    
    public void setComments(String comments) {
        this.comments = comments;
    }

    public BigDecimal getExampleSize() {
        return this.exampleSize;
    }
    
    public void setExampleSize(BigDecimal exampleSize) {
        this.exampleSize = exampleSize;
    }

    public Timestamp getExampleDate() {
        return this.exampleDate;
    }
    
    public void setExampleDate(Timestamp exampleDate) {
        this.exampleDate = exampleDate;
    }

    public Timestamp getAnotherDate() {
        return this.anotherDate;
    }
    
    public void setAnotherDate(Timestamp anotherDate) {
        this.anotherDate = anotherDate;
    }

    public String getAnotherText() {
        return this.anotherText;
    }
    
    public void setAnotherText(String anotherText) {
        this.anotherText = anotherText;
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