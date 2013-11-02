package com.magic.entitymodel;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * EntitySync entity. @author MyEclipse Persistence Tools
 */

public class EntitySync  implements java.io.Serializable {


    // Fields    

     private String entitySyncId;
     private String runStatusId;
     private Timestamp lastSuccessfulSynchTime;
     private Timestamp lastHistoryStartDate;
     private Timestamp preOfflineSynchTime;
     private BigDecimal offlineSyncSplitMillis;
     private BigDecimal syncSplitMillis;
     private BigDecimal syncEndBufferMillis;
     private BigDecimal maxRunningNoUpdateMillis;
     private String targetServiceName;
     private String targetDelegatorName;
     private Double keepRemoveInfoHours;
     private String forPullOnly;
     private String forPushOnly;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public EntitySync() {
    }

	/** minimal constructor */
    public EntitySync(String entitySyncId) {
        this.entitySyncId = entitySyncId;
    }
    
    /** full constructor */
    public EntitySync(String entitySyncId, String runStatusId, Timestamp lastSuccessfulSynchTime, Timestamp lastHistoryStartDate, Timestamp preOfflineSynchTime, BigDecimal offlineSyncSplitMillis, BigDecimal syncSplitMillis, BigDecimal syncEndBufferMillis, BigDecimal maxRunningNoUpdateMillis, String targetServiceName, String targetDelegatorName, Double keepRemoveInfoHours, String forPullOnly, String forPushOnly, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.entitySyncId = entitySyncId;
        this.runStatusId = runStatusId;
        this.lastSuccessfulSynchTime = lastSuccessfulSynchTime;
        this.lastHistoryStartDate = lastHistoryStartDate;
        this.preOfflineSynchTime = preOfflineSynchTime;
        this.offlineSyncSplitMillis = offlineSyncSplitMillis;
        this.syncSplitMillis = syncSplitMillis;
        this.syncEndBufferMillis = syncEndBufferMillis;
        this.maxRunningNoUpdateMillis = maxRunningNoUpdateMillis;
        this.targetServiceName = targetServiceName;
        this.targetDelegatorName = targetDelegatorName;
        this.keepRemoveInfoHours = keepRemoveInfoHours;
        this.forPullOnly = forPullOnly;
        this.forPushOnly = forPushOnly;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public String getEntitySyncId() {
        return this.entitySyncId;
    }
    
    public void setEntitySyncId(String entitySyncId) {
        this.entitySyncId = entitySyncId;
    }

    public String getRunStatusId() {
        return this.runStatusId;
    }
    
    public void setRunStatusId(String runStatusId) {
        this.runStatusId = runStatusId;
    }

    public Timestamp getLastSuccessfulSynchTime() {
        return this.lastSuccessfulSynchTime;
    }
    
    public void setLastSuccessfulSynchTime(Timestamp lastSuccessfulSynchTime) {
        this.lastSuccessfulSynchTime = lastSuccessfulSynchTime;
    }

    public Timestamp getLastHistoryStartDate() {
        return this.lastHistoryStartDate;
    }
    
    public void setLastHistoryStartDate(Timestamp lastHistoryStartDate) {
        this.lastHistoryStartDate = lastHistoryStartDate;
    }

    public Timestamp getPreOfflineSynchTime() {
        return this.preOfflineSynchTime;
    }
    
    public void setPreOfflineSynchTime(Timestamp preOfflineSynchTime) {
        this.preOfflineSynchTime = preOfflineSynchTime;
    }

    public BigDecimal getOfflineSyncSplitMillis() {
        return this.offlineSyncSplitMillis;
    }
    
    public void setOfflineSyncSplitMillis(BigDecimal offlineSyncSplitMillis) {
        this.offlineSyncSplitMillis = offlineSyncSplitMillis;
    }

    public BigDecimal getSyncSplitMillis() {
        return this.syncSplitMillis;
    }
    
    public void setSyncSplitMillis(BigDecimal syncSplitMillis) {
        this.syncSplitMillis = syncSplitMillis;
    }

    public BigDecimal getSyncEndBufferMillis() {
        return this.syncEndBufferMillis;
    }
    
    public void setSyncEndBufferMillis(BigDecimal syncEndBufferMillis) {
        this.syncEndBufferMillis = syncEndBufferMillis;
    }

    public BigDecimal getMaxRunningNoUpdateMillis() {
        return this.maxRunningNoUpdateMillis;
    }
    
    public void setMaxRunningNoUpdateMillis(BigDecimal maxRunningNoUpdateMillis) {
        this.maxRunningNoUpdateMillis = maxRunningNoUpdateMillis;
    }

    public String getTargetServiceName() {
        return this.targetServiceName;
    }
    
    public void setTargetServiceName(String targetServiceName) {
        this.targetServiceName = targetServiceName;
    }

    public String getTargetDelegatorName() {
        return this.targetDelegatorName;
    }
    
    public void setTargetDelegatorName(String targetDelegatorName) {
        this.targetDelegatorName = targetDelegatorName;
    }

    public Double getKeepRemoveInfoHours() {
        return this.keepRemoveInfoHours;
    }
    
    public void setKeepRemoveInfoHours(Double keepRemoveInfoHours) {
        this.keepRemoveInfoHours = keepRemoveInfoHours;
    }

    public String getForPullOnly() {
        return this.forPullOnly;
    }
    
    public void setForPullOnly(String forPullOnly) {
        this.forPullOnly = forPullOnly;
    }

    public String getForPushOnly() {
        return this.forPushOnly;
    }
    
    public void setForPushOnly(String forPushOnly) {
        this.forPushOnly = forPushOnly;
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