package com.magic.entitymodel;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;


/**
 * CustomTimePeriod entity. @author MyEclipse Persistence Tools
 */

public class CustomTimePeriod  implements java.io.Serializable {


    // Fields    

     private String customTimePeriodId;
     private String parentPeriodId;
     private String periodTypeId;
     private BigDecimal periodNum;
     private String periodName;
     private Date fromDate;
     private Date thruDate;
     private String isClosed;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public CustomTimePeriod() {
    }

	/** minimal constructor */
    public CustomTimePeriod(String customTimePeriodId) {
        this.customTimePeriodId = customTimePeriodId;
    }
    
    /** full constructor */
    public CustomTimePeriod(String customTimePeriodId, String parentPeriodId, String periodTypeId, BigDecimal periodNum, String periodName, Date fromDate, Date thruDate, String isClosed, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.customTimePeriodId = customTimePeriodId;
        this.parentPeriodId = parentPeriodId;
        this.periodTypeId = periodTypeId;
        this.periodNum = periodNum;
        this.periodName = periodName;
        this.fromDate = fromDate;
        this.thruDate = thruDate;
        this.isClosed = isClosed;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public String getCustomTimePeriodId() {
        return this.customTimePeriodId;
    }
    
    public void setCustomTimePeriodId(String customTimePeriodId) {
        this.customTimePeriodId = customTimePeriodId;
    }

    public String getParentPeriodId() {
        return this.parentPeriodId;
    }
    
    public void setParentPeriodId(String parentPeriodId) {
        this.parentPeriodId = parentPeriodId;
    }

    public String getPeriodTypeId() {
        return this.periodTypeId;
    }
    
    public void setPeriodTypeId(String periodTypeId) {
        this.periodTypeId = periodTypeId;
    }

    public BigDecimal getPeriodNum() {
        return this.periodNum;
    }
    
    public void setPeriodNum(BigDecimal periodNum) {
        this.periodNum = periodNum;
    }

    public String getPeriodName() {
        return this.periodName;
    }
    
    public void setPeriodName(String periodName) {
        this.periodName = periodName;
    }

    public Date getFromDate() {
        return this.fromDate;
    }
    
    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getThruDate() {
        return this.thruDate;
    }
    
    public void setThruDate(Date thruDate) {
        this.thruDate = thruDate;
    }

    public String getIsClosed() {
        return this.isClosed;
    }
    
    public void setIsClosed(String isClosed) {
        this.isClosed = isClosed;
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