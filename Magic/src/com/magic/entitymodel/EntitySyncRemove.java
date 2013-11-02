package com.magic.entitymodel;

import java.sql.Timestamp;


/**
 * EntitySyncRemove entity. @author MyEclipse Persistence Tools
 */

public class EntitySyncRemove  implements java.io.Serializable {


    // Fields    

     private String entitySyncRemoveId;
     private String primaryKeyRemoved;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public EntitySyncRemove() {
    }

	/** minimal constructor */
    public EntitySyncRemove(String entitySyncRemoveId) {
        this.entitySyncRemoveId = entitySyncRemoveId;
    }
    
    /** full constructor */
    public EntitySyncRemove(String entitySyncRemoveId, String primaryKeyRemoved, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.entitySyncRemoveId = entitySyncRemoveId;
        this.primaryKeyRemoved = primaryKeyRemoved;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public String getEntitySyncRemoveId() {
        return this.entitySyncRemoveId;
    }
    
    public void setEntitySyncRemoveId(String entitySyncRemoveId) {
        this.entitySyncRemoveId = entitySyncRemoveId;
    }

    public String getPrimaryKeyRemoved() {
        return this.primaryKeyRemoved;
    }
    
    public void setPrimaryKeyRemoved(String primaryKeyRemoved) {
        this.primaryKeyRemoved = primaryKeyRemoved;
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