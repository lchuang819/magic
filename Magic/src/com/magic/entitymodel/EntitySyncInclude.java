package com.magic.entitymodel;

import java.sql.Timestamp;


/**
 * EntitySyncInclude entity. @author MyEclipse Persistence Tools
 */

public class EntitySyncInclude  implements java.io.Serializable {


    // Fields    

     private EntitySyncIncludeId id;
     private String applEnumId;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public EntitySyncInclude() {
    }

	/** minimal constructor */
    public EntitySyncInclude(EntitySyncIncludeId id) {
        this.id = id;
    }
    
    /** full constructor */
    public EntitySyncInclude(EntitySyncIncludeId id, String applEnumId, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.id = id;
        this.applEnumId = applEnumId;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public EntitySyncIncludeId getId() {
        return this.id;
    }
    
    public void setId(EntitySyncIncludeId id) {
        this.id = id;
    }

    public String getApplEnumId() {
        return this.applEnumId;
    }
    
    public void setApplEnumId(String applEnumId) {
        this.applEnumId = applEnumId;
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