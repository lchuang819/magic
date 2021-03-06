package com.magic.entitymodel;

import java.sql.Timestamp;


/**
 * EntitySyncIncludeGroup entity. @author MyEclipse Persistence Tools
 */

public class EntitySyncIncludeGroup  implements java.io.Serializable {


    // Fields    

     private EntitySyncIncludeGroupId id;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public EntitySyncIncludeGroup() {
    }

	/** minimal constructor */
    public EntitySyncIncludeGroup(EntitySyncIncludeGroupId id) {
        this.id = id;
    }
    
    /** full constructor */
    public EntitySyncIncludeGroup(EntitySyncIncludeGroupId id, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.id = id;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public EntitySyncIncludeGroupId getId() {
        return this.id;
    }
    
    public void setId(EntitySyncIncludeGroupId id) {
        this.id = id;
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