package com.magic.entitymodel;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * TarpittedLoginView entity. @author MyEclipse Persistence Tools
 */

public class TarpittedLoginView  implements java.io.Serializable {


    // Fields    

     private TarpittedLoginViewId id;
     private BigDecimal tarpitReleaseDateTime;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public TarpittedLoginView() {
    }

	/** minimal constructor */
    public TarpittedLoginView(TarpittedLoginViewId id) {
        this.id = id;
    }
    
    /** full constructor */
    public TarpittedLoginView(TarpittedLoginViewId id, BigDecimal tarpitReleaseDateTime, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.id = id;
        this.tarpitReleaseDateTime = tarpitReleaseDateTime;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public TarpittedLoginViewId getId() {
        return this.id;
    }
    
    public void setId(TarpittedLoginViewId id) {
        this.id = id;
    }

    public BigDecimal getTarpitReleaseDateTime() {
        return this.tarpitReleaseDateTime;
    }
    
    public void setTarpitReleaseDateTime(BigDecimal tarpitReleaseDateTime) {
        this.tarpitReleaseDateTime = tarpitReleaseDateTime;
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