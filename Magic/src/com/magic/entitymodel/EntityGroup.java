package com.magic.entitymodel;

import java.sql.Timestamp;


/**
 * EntityGroup entity. @author MyEclipse Persistence Tools
 */

public class EntityGroup  implements java.io.Serializable {


    // Fields    

     private String entityGroupId;
     private String entityGroupName;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public EntityGroup() {
    }

	/** minimal constructor */
    public EntityGroup(String entityGroupId) {
        this.entityGroupId = entityGroupId;
    }
    
    /** full constructor */
    public EntityGroup(String entityGroupId, String entityGroupName, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.entityGroupId = entityGroupId;
        this.entityGroupName = entityGroupName;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public String getEntityGroupId() {
        return this.entityGroupId;
    }
    
    public void setEntityGroupId(String entityGroupId) {
        this.entityGroupId = entityGroupId;
    }

    public String getEntityGroupName() {
        return this.entityGroupName;
    }
    
    public void setEntityGroupName(String entityGroupName) {
        this.entityGroupName = entityGroupName;
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