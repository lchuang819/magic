package com.magic.entitymodel;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * ProtectedView entity. @author MyEclipse Persistence Tools
 */

public class ProtectedView  implements java.io.Serializable {


    // Fields    

     private ProtectedViewId id;
     private BigDecimal maxHits;
     private BigDecimal maxHitsDuration;
     private BigDecimal tarpitDuration;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public ProtectedView() {
    }

	/** minimal constructor */
    public ProtectedView(ProtectedViewId id) {
        this.id = id;
    }
    
    /** full constructor */
    public ProtectedView(ProtectedViewId id, BigDecimal maxHits, BigDecimal maxHitsDuration, BigDecimal tarpitDuration, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.id = id;
        this.maxHits = maxHits;
        this.maxHitsDuration = maxHitsDuration;
        this.tarpitDuration = tarpitDuration;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public ProtectedViewId getId() {
        return this.id;
    }
    
    public void setId(ProtectedViewId id) {
        this.id = id;
    }

    public BigDecimal getMaxHits() {
        return this.maxHits;
    }
    
    public void setMaxHits(BigDecimal maxHits) {
        this.maxHits = maxHits;
    }

    public BigDecimal getMaxHitsDuration() {
        return this.maxHitsDuration;
    }
    
    public void setMaxHitsDuration(BigDecimal maxHitsDuration) {
        this.maxHitsDuration = maxHitsDuration;
    }

    public BigDecimal getTarpitDuration() {
        return this.tarpitDuration;
    }
    
    public void setTarpitDuration(BigDecimal tarpitDuration) {
        this.tarpitDuration = tarpitDuration;
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