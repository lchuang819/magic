package com.magic.entitymodel;

import java.sql.Timestamp;


/**
 * StandardTimePeriod entity. @author MyEclipse Persistence Tools
 */

public class StandardTimePeriod  implements java.io.Serializable {


    // Fields    

     private String standardTimePeriodId;
     private String periodTypeId;
     private Timestamp fromDate;
     private Timestamp thruDate;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public StandardTimePeriod() {
    }

	/** minimal constructor */
    public StandardTimePeriod(String standardTimePeriodId) {
        this.standardTimePeriodId = standardTimePeriodId;
    }
    
    /** full constructor */
    public StandardTimePeriod(String standardTimePeriodId, String periodTypeId, Timestamp fromDate, Timestamp thruDate, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.standardTimePeriodId = standardTimePeriodId;
        this.periodTypeId = periodTypeId;
        this.fromDate = fromDate;
        this.thruDate = thruDate;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public String getStandardTimePeriodId() {
        return this.standardTimePeriodId;
    }
    
    public void setStandardTimePeriodId(String standardTimePeriodId) {
        this.standardTimePeriodId = standardTimePeriodId;
    }

    public String getPeriodTypeId() {
        return this.periodTypeId;
    }
    
    public void setPeriodTypeId(String periodTypeId) {
        this.periodTypeId = periodTypeId;
    }

    public Timestamp getFromDate() {
        return this.fromDate;
    }
    
    public void setFromDate(Timestamp fromDate) {
        this.fromDate = fromDate;
    }

    public Timestamp getThruDate() {
        return this.thruDate;
    }
    
    public void setThruDate(Timestamp thruDate) {
        this.thruDate = thruDate;
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