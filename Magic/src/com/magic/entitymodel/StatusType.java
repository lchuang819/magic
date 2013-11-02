package com.magic.entitymodel;

import java.sql.Timestamp;


/**
 * StatusType entity. @author MyEclipse Persistence Tools
 */

public class StatusType  implements java.io.Serializable {


    // Fields    

     private String statusTypeId;
     private String parentTypeId;
     private String hasTable;
     private String description;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public StatusType() {
    }

	/** minimal constructor */
    public StatusType(String statusTypeId) {
        this.statusTypeId = statusTypeId;
    }
    
    /** full constructor */
    public StatusType(String statusTypeId, String parentTypeId, String hasTable, String description, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.statusTypeId = statusTypeId;
        this.parentTypeId = parentTypeId;
        this.hasTable = hasTable;
        this.description = description;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public String getStatusTypeId() {
        return this.statusTypeId;
    }
    
    public void setStatusTypeId(String statusTypeId) {
        this.statusTypeId = statusTypeId;
    }

    public String getParentTypeId() {
        return this.parentTypeId;
    }
    
    public void setParentTypeId(String parentTypeId) {
        this.parentTypeId = parentTypeId;
    }

    public String getHasTable() {
        return this.hasTable;
    }
    
    public void setHasTable(String hasTable) {
        this.hasTable = hasTable;
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