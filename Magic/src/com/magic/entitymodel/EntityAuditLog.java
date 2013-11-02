package com.magic.entitymodel;

import java.sql.Timestamp;


/**
 * EntityAuditLog entity. @author MyEclipse Persistence Tools
 */

public class EntityAuditLog  implements java.io.Serializable {


    // Fields    

     private String auditHistorySeqId;
     private String changedEntityName;
     private String changedFieldName;
     private String pkCombinedValueText;
     private String oldValueText;
     private String newValueText;
     private Timestamp changedDate;
     private String changedByInfo;
     private String changedSessionInfo;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public EntityAuditLog() {
    }

	/** minimal constructor */
    public EntityAuditLog(String auditHistorySeqId) {
        this.auditHistorySeqId = auditHistorySeqId;
    }
    
    /** full constructor */
    public EntityAuditLog(String auditHistorySeqId, String changedEntityName, String changedFieldName, String pkCombinedValueText, String oldValueText, String newValueText, Timestamp changedDate, String changedByInfo, String changedSessionInfo, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.auditHistorySeqId = auditHistorySeqId;
        this.changedEntityName = changedEntityName;
        this.changedFieldName = changedFieldName;
        this.pkCombinedValueText = pkCombinedValueText;
        this.oldValueText = oldValueText;
        this.newValueText = newValueText;
        this.changedDate = changedDate;
        this.changedByInfo = changedByInfo;
        this.changedSessionInfo = changedSessionInfo;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public String getAuditHistorySeqId() {
        return this.auditHistorySeqId;
    }
    
    public void setAuditHistorySeqId(String auditHistorySeqId) {
        this.auditHistorySeqId = auditHistorySeqId;
    }

    public String getChangedEntityName() {
        return this.changedEntityName;
    }
    
    public void setChangedEntityName(String changedEntityName) {
        this.changedEntityName = changedEntityName;
    }

    public String getChangedFieldName() {
        return this.changedFieldName;
    }
    
    public void setChangedFieldName(String changedFieldName) {
        this.changedFieldName = changedFieldName;
    }

    public String getPkCombinedValueText() {
        return this.pkCombinedValueText;
    }
    
    public void setPkCombinedValueText(String pkCombinedValueText) {
        this.pkCombinedValueText = pkCombinedValueText;
    }

    public String getOldValueText() {
        return this.oldValueText;
    }
    
    public void setOldValueText(String oldValueText) {
        this.oldValueText = oldValueText;
    }

    public String getNewValueText() {
        return this.newValueText;
    }
    
    public void setNewValueText(String newValueText) {
        this.newValueText = newValueText;
    }

    public Timestamp getChangedDate() {
        return this.changedDate;
    }
    
    public void setChangedDate(Timestamp changedDate) {
        this.changedDate = changedDate;
    }

    public String getChangedByInfo() {
        return this.changedByInfo;
    }
    
    public void setChangedByInfo(String changedByInfo) {
        this.changedByInfo = changedByInfo;
    }

    public String getChangedSessionInfo() {
        return this.changedSessionInfo;
    }
    
    public void setChangedSessionInfo(String changedSessionInfo) {
        this.changedSessionInfo = changedSessionInfo;
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