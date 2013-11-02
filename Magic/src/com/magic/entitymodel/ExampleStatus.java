package com.magic.entitymodel;

import java.sql.Timestamp;


/**
 * ExampleStatus entity. @author MyEclipse Persistence Tools
 */

public class ExampleStatus  implements java.io.Serializable {


    // Fields    

     private ExampleStatusId id;
     private Timestamp statusEndDate;
     private String statusId;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public ExampleStatus() {
    }

	/** minimal constructor */
    public ExampleStatus(ExampleStatusId id) {
        this.id = id;
    }
    
    /** full constructor */
    public ExampleStatus(ExampleStatusId id, Timestamp statusEndDate, String statusId, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.id = id;
        this.statusEndDate = statusEndDate;
        this.statusId = statusId;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public ExampleStatusId getId() {
        return this.id;
    }
    
    public void setId(ExampleStatusId id) {
        this.id = id;
    }

    public Timestamp getStatusEndDate() {
        return this.statusEndDate;
    }
    
    public void setStatusEndDate(Timestamp statusEndDate) {
        this.statusEndDate = statusEndDate;
    }

    public String getStatusId() {
        return this.statusId;
    }
    
    public void setStatusId(String statusId) {
        this.statusId = statusId;
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