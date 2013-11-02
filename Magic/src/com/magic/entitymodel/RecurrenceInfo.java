package com.magic.entitymodel;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * RecurrenceInfo entity. @author MyEclipse Persistence Tools
 */

public class RecurrenceInfo  implements java.io.Serializable {


    // Fields    

     private String recurrenceInfoId;
     private Timestamp startDateTime;
     private String exceptionDateTimes;
     private String recurrenceDateTimes;
     private String exceptionRuleId;
     private String recurrenceRuleId;
     private BigDecimal recurrenceCount;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public RecurrenceInfo() {
    }

	/** minimal constructor */
    public RecurrenceInfo(String recurrenceInfoId) {
        this.recurrenceInfoId = recurrenceInfoId;
    }
    
    /** full constructor */
    public RecurrenceInfo(String recurrenceInfoId, Timestamp startDateTime, String exceptionDateTimes, String recurrenceDateTimes, String exceptionRuleId, String recurrenceRuleId, BigDecimal recurrenceCount, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.recurrenceInfoId = recurrenceInfoId;
        this.startDateTime = startDateTime;
        this.exceptionDateTimes = exceptionDateTimes;
        this.recurrenceDateTimes = recurrenceDateTimes;
        this.exceptionRuleId = exceptionRuleId;
        this.recurrenceRuleId = recurrenceRuleId;
        this.recurrenceCount = recurrenceCount;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public String getRecurrenceInfoId() {
        return this.recurrenceInfoId;
    }
    
    public void setRecurrenceInfoId(String recurrenceInfoId) {
        this.recurrenceInfoId = recurrenceInfoId;
    }

    public Timestamp getStartDateTime() {
        return this.startDateTime;
    }
    
    public void setStartDateTime(Timestamp startDateTime) {
        this.startDateTime = startDateTime;
    }

    public String getExceptionDateTimes() {
        return this.exceptionDateTimes;
    }
    
    public void setExceptionDateTimes(String exceptionDateTimes) {
        this.exceptionDateTimes = exceptionDateTimes;
    }

    public String getRecurrenceDateTimes() {
        return this.recurrenceDateTimes;
    }
    
    public void setRecurrenceDateTimes(String recurrenceDateTimes) {
        this.recurrenceDateTimes = recurrenceDateTimes;
    }

    public String getExceptionRuleId() {
        return this.exceptionRuleId;
    }
    
    public void setExceptionRuleId(String exceptionRuleId) {
        this.exceptionRuleId = exceptionRuleId;
    }

    public String getRecurrenceRuleId() {
        return this.recurrenceRuleId;
    }
    
    public void setRecurrenceRuleId(String recurrenceRuleId) {
        this.recurrenceRuleId = recurrenceRuleId;
    }

    public BigDecimal getRecurrenceCount() {
        return this.recurrenceCount;
    }
    
    public void setRecurrenceCount(BigDecimal recurrenceCount) {
        this.recurrenceCount = recurrenceCount;
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