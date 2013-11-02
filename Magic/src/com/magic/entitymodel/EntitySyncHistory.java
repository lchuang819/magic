package com.magic.entitymodel;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * EntitySyncHistory entity. @author MyEclipse Persistence Tools
 */

public class EntitySyncHistory  implements java.io.Serializable {


    // Fields    

     private EntitySyncHistoryId id;
     private String runStatusId;
     private Timestamp beginningSynchTime;
     private Timestamp lastSuccessfulSynchTime;
     private Timestamp lastCandidateEndTime;
     private BigDecimal lastSplitStartTime;
     private BigDecimal toCreateInserted;
     private BigDecimal toCreateUpdated;
     private BigDecimal toCreateNotUpdated;
     private BigDecimal toStoreInserted;
     private BigDecimal toStoreUpdated;
     private BigDecimal toStoreNotUpdated;
     private BigDecimal toRemoveDeleted;
     private BigDecimal toRemoveAlreadyDeleted;
     private BigDecimal totalRowsExported;
     private BigDecimal totalRowsToCreate;
     private BigDecimal totalRowsToStore;
     private BigDecimal totalRowsToRemove;
     private BigDecimal totalSplits;
     private BigDecimal totalStoreCalls;
     private BigDecimal runningTimeMillis;
     private BigDecimal perSplitMinMillis;
     private BigDecimal perSplitMaxMillis;
     private BigDecimal perSplitMinItems;
     private BigDecimal perSplitMaxItems;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public EntitySyncHistory() {
    }

	/** minimal constructor */
    public EntitySyncHistory(EntitySyncHistoryId id) {
        this.id = id;
    }
    
    /** full constructor */
    public EntitySyncHistory(EntitySyncHistoryId id, String runStatusId, Timestamp beginningSynchTime, Timestamp lastSuccessfulSynchTime, Timestamp lastCandidateEndTime, BigDecimal lastSplitStartTime, BigDecimal toCreateInserted, BigDecimal toCreateUpdated, BigDecimal toCreateNotUpdated, BigDecimal toStoreInserted, BigDecimal toStoreUpdated, BigDecimal toStoreNotUpdated, BigDecimal toRemoveDeleted, BigDecimal toRemoveAlreadyDeleted, BigDecimal totalRowsExported, BigDecimal totalRowsToCreate, BigDecimal totalRowsToStore, BigDecimal totalRowsToRemove, BigDecimal totalSplits, BigDecimal totalStoreCalls, BigDecimal runningTimeMillis, BigDecimal perSplitMinMillis, BigDecimal perSplitMaxMillis, BigDecimal perSplitMinItems, BigDecimal perSplitMaxItems, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.id = id;
        this.runStatusId = runStatusId;
        this.beginningSynchTime = beginningSynchTime;
        this.lastSuccessfulSynchTime = lastSuccessfulSynchTime;
        this.lastCandidateEndTime = lastCandidateEndTime;
        this.lastSplitStartTime = lastSplitStartTime;
        this.toCreateInserted = toCreateInserted;
        this.toCreateUpdated = toCreateUpdated;
        this.toCreateNotUpdated = toCreateNotUpdated;
        this.toStoreInserted = toStoreInserted;
        this.toStoreUpdated = toStoreUpdated;
        this.toStoreNotUpdated = toStoreNotUpdated;
        this.toRemoveDeleted = toRemoveDeleted;
        this.toRemoveAlreadyDeleted = toRemoveAlreadyDeleted;
        this.totalRowsExported = totalRowsExported;
        this.totalRowsToCreate = totalRowsToCreate;
        this.totalRowsToStore = totalRowsToStore;
        this.totalRowsToRemove = totalRowsToRemove;
        this.totalSplits = totalSplits;
        this.totalStoreCalls = totalStoreCalls;
        this.runningTimeMillis = runningTimeMillis;
        this.perSplitMinMillis = perSplitMinMillis;
        this.perSplitMaxMillis = perSplitMaxMillis;
        this.perSplitMinItems = perSplitMinItems;
        this.perSplitMaxItems = perSplitMaxItems;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public EntitySyncHistoryId getId() {
        return this.id;
    }
    
    public void setId(EntitySyncHistoryId id) {
        this.id = id;
    }

    public String getRunStatusId() {
        return this.runStatusId;
    }
    
    public void setRunStatusId(String runStatusId) {
        this.runStatusId = runStatusId;
    }

    public Timestamp getBeginningSynchTime() {
        return this.beginningSynchTime;
    }
    
    public void setBeginningSynchTime(Timestamp beginningSynchTime) {
        this.beginningSynchTime = beginningSynchTime;
    }

    public Timestamp getLastSuccessfulSynchTime() {
        return this.lastSuccessfulSynchTime;
    }
    
    public void setLastSuccessfulSynchTime(Timestamp lastSuccessfulSynchTime) {
        this.lastSuccessfulSynchTime = lastSuccessfulSynchTime;
    }

    public Timestamp getLastCandidateEndTime() {
        return this.lastCandidateEndTime;
    }
    
    public void setLastCandidateEndTime(Timestamp lastCandidateEndTime) {
        this.lastCandidateEndTime = lastCandidateEndTime;
    }

    public BigDecimal getLastSplitStartTime() {
        return this.lastSplitStartTime;
    }
    
    public void setLastSplitStartTime(BigDecimal lastSplitStartTime) {
        this.lastSplitStartTime = lastSplitStartTime;
    }

    public BigDecimal getToCreateInserted() {
        return this.toCreateInserted;
    }
    
    public void setToCreateInserted(BigDecimal toCreateInserted) {
        this.toCreateInserted = toCreateInserted;
    }

    public BigDecimal getToCreateUpdated() {
        return this.toCreateUpdated;
    }
    
    public void setToCreateUpdated(BigDecimal toCreateUpdated) {
        this.toCreateUpdated = toCreateUpdated;
    }

    public BigDecimal getToCreateNotUpdated() {
        return this.toCreateNotUpdated;
    }
    
    public void setToCreateNotUpdated(BigDecimal toCreateNotUpdated) {
        this.toCreateNotUpdated = toCreateNotUpdated;
    }

    public BigDecimal getToStoreInserted() {
        return this.toStoreInserted;
    }
    
    public void setToStoreInserted(BigDecimal toStoreInserted) {
        this.toStoreInserted = toStoreInserted;
    }

    public BigDecimal getToStoreUpdated() {
        return this.toStoreUpdated;
    }
    
    public void setToStoreUpdated(BigDecimal toStoreUpdated) {
        this.toStoreUpdated = toStoreUpdated;
    }

    public BigDecimal getToStoreNotUpdated() {
        return this.toStoreNotUpdated;
    }
    
    public void setToStoreNotUpdated(BigDecimal toStoreNotUpdated) {
        this.toStoreNotUpdated = toStoreNotUpdated;
    }

    public BigDecimal getToRemoveDeleted() {
        return this.toRemoveDeleted;
    }
    
    public void setToRemoveDeleted(BigDecimal toRemoveDeleted) {
        this.toRemoveDeleted = toRemoveDeleted;
    }

    public BigDecimal getToRemoveAlreadyDeleted() {
        return this.toRemoveAlreadyDeleted;
    }
    
    public void setToRemoveAlreadyDeleted(BigDecimal toRemoveAlreadyDeleted) {
        this.toRemoveAlreadyDeleted = toRemoveAlreadyDeleted;
    }

    public BigDecimal getTotalRowsExported() {
        return this.totalRowsExported;
    }
    
    public void setTotalRowsExported(BigDecimal totalRowsExported) {
        this.totalRowsExported = totalRowsExported;
    }

    public BigDecimal getTotalRowsToCreate() {
        return this.totalRowsToCreate;
    }
    
    public void setTotalRowsToCreate(BigDecimal totalRowsToCreate) {
        this.totalRowsToCreate = totalRowsToCreate;
    }

    public BigDecimal getTotalRowsToStore() {
        return this.totalRowsToStore;
    }
    
    public void setTotalRowsToStore(BigDecimal totalRowsToStore) {
        this.totalRowsToStore = totalRowsToStore;
    }

    public BigDecimal getTotalRowsToRemove() {
        return this.totalRowsToRemove;
    }
    
    public void setTotalRowsToRemove(BigDecimal totalRowsToRemove) {
        this.totalRowsToRemove = totalRowsToRemove;
    }

    public BigDecimal getTotalSplits() {
        return this.totalSplits;
    }
    
    public void setTotalSplits(BigDecimal totalSplits) {
        this.totalSplits = totalSplits;
    }

    public BigDecimal getTotalStoreCalls() {
        return this.totalStoreCalls;
    }
    
    public void setTotalStoreCalls(BigDecimal totalStoreCalls) {
        this.totalStoreCalls = totalStoreCalls;
    }

    public BigDecimal getRunningTimeMillis() {
        return this.runningTimeMillis;
    }
    
    public void setRunningTimeMillis(BigDecimal runningTimeMillis) {
        this.runningTimeMillis = runningTimeMillis;
    }

    public BigDecimal getPerSplitMinMillis() {
        return this.perSplitMinMillis;
    }
    
    public void setPerSplitMinMillis(BigDecimal perSplitMinMillis) {
        this.perSplitMinMillis = perSplitMinMillis;
    }

    public BigDecimal getPerSplitMaxMillis() {
        return this.perSplitMaxMillis;
    }
    
    public void setPerSplitMaxMillis(BigDecimal perSplitMaxMillis) {
        this.perSplitMaxMillis = perSplitMaxMillis;
    }

    public BigDecimal getPerSplitMinItems() {
        return this.perSplitMinItems;
    }
    
    public void setPerSplitMinItems(BigDecimal perSplitMinItems) {
        this.perSplitMinItems = perSplitMinItems;
    }

    public BigDecimal getPerSplitMaxItems() {
        return this.perSplitMaxItems;
    }
    
    public void setPerSplitMaxItems(BigDecimal perSplitMaxItems) {
        this.perSplitMaxItems = perSplitMaxItems;
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