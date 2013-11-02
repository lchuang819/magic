package com.magic.entitymodel;

import java.sql.Timestamp;


/**
 * StatusItem entity. @author MyEclipse Persistence Tools
 */

public class StatusItem  implements java.io.Serializable {


    // Fields    

     private String statusId;
     private String statusTypeId;
     private String statusCode;
     private String sequenceId;
     private String description;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public StatusItem() {
    }

	/** minimal constructor */
    public StatusItem(String statusId) {
        this.statusId = statusId;
    }
    
    /** full constructor */
    public StatusItem(String statusId, String statusTypeId, String statusCode, String sequenceId, String description, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.statusId = statusId;
        this.statusTypeId = statusTypeId;
        this.statusCode = statusCode;
        this.sequenceId = sequenceId;
        this.description = description;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public String getStatusId() {
        return this.statusId;
    }
    
    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public String getStatusTypeId() {
        return this.statusTypeId;
    }
    
    public void setStatusTypeId(String statusTypeId) {
        this.statusTypeId = statusTypeId;
    }

    public String getStatusCode() {
        return this.statusCode;
    }
    
    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getSequenceId() {
        return this.sequenceId;
    }
    
    public void setSequenceId(String sequenceId) {
        this.sequenceId = sequenceId;
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