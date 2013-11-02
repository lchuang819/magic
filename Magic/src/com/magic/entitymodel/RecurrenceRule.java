package com.magic.entitymodel;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * RecurrenceRule entity. @author MyEclipse Persistence Tools
 */

public class RecurrenceRule  implements java.io.Serializable {


    // Fields    

     private String recurrenceRuleId;
     private String frequency;
     private Timestamp untilDateTime;
     private BigDecimal countNumber;
     private BigDecimal intervalNumber;
     private String bySecondList;
     private String byMinuteList;
     private String byHourList;
     private String byDayList;
     private String byMonthDayList;
     private String byYearDayList;
     private String byWeekNoList;
     private String byMonthList;
     private String bySetPosList;
     private String weekStart;
     private String XName;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public RecurrenceRule() {
    }

	/** minimal constructor */
    public RecurrenceRule(String recurrenceRuleId) {
        this.recurrenceRuleId = recurrenceRuleId;
    }
    
    /** full constructor */
    public RecurrenceRule(String recurrenceRuleId, String frequency, Timestamp untilDateTime, BigDecimal countNumber, BigDecimal intervalNumber, String bySecondList, String byMinuteList, String byHourList, String byDayList, String byMonthDayList, String byYearDayList, String byWeekNoList, String byMonthList, String bySetPosList, String weekStart, String XName, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.recurrenceRuleId = recurrenceRuleId;
        this.frequency = frequency;
        this.untilDateTime = untilDateTime;
        this.countNumber = countNumber;
        this.intervalNumber = intervalNumber;
        this.bySecondList = bySecondList;
        this.byMinuteList = byMinuteList;
        this.byHourList = byHourList;
        this.byDayList = byDayList;
        this.byMonthDayList = byMonthDayList;
        this.byYearDayList = byYearDayList;
        this.byWeekNoList = byWeekNoList;
        this.byMonthList = byMonthList;
        this.bySetPosList = bySetPosList;
        this.weekStart = weekStart;
        this.XName = XName;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public String getRecurrenceRuleId() {
        return this.recurrenceRuleId;
    }
    
    public void setRecurrenceRuleId(String recurrenceRuleId) {
        this.recurrenceRuleId = recurrenceRuleId;
    }

    public String getFrequency() {
        return this.frequency;
    }
    
    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public Timestamp getUntilDateTime() {
        return this.untilDateTime;
    }
    
    public void setUntilDateTime(Timestamp untilDateTime) {
        this.untilDateTime = untilDateTime;
    }

    public BigDecimal getCountNumber() {
        return this.countNumber;
    }
    
    public void setCountNumber(BigDecimal countNumber) {
        this.countNumber = countNumber;
    }

    public BigDecimal getIntervalNumber() {
        return this.intervalNumber;
    }
    
    public void setIntervalNumber(BigDecimal intervalNumber) {
        this.intervalNumber = intervalNumber;
    }

    public String getBySecondList() {
        return this.bySecondList;
    }
    
    public void setBySecondList(String bySecondList) {
        this.bySecondList = bySecondList;
    }

    public String getByMinuteList() {
        return this.byMinuteList;
    }
    
    public void setByMinuteList(String byMinuteList) {
        this.byMinuteList = byMinuteList;
    }

    public String getByHourList() {
        return this.byHourList;
    }
    
    public void setByHourList(String byHourList) {
        this.byHourList = byHourList;
    }

    public String getByDayList() {
        return this.byDayList;
    }
    
    public void setByDayList(String byDayList) {
        this.byDayList = byDayList;
    }

    public String getByMonthDayList() {
        return this.byMonthDayList;
    }
    
    public void setByMonthDayList(String byMonthDayList) {
        this.byMonthDayList = byMonthDayList;
    }

    public String getByYearDayList() {
        return this.byYearDayList;
    }
    
    public void setByYearDayList(String byYearDayList) {
        this.byYearDayList = byYearDayList;
    }

    public String getByWeekNoList() {
        return this.byWeekNoList;
    }
    
    public void setByWeekNoList(String byWeekNoList) {
        this.byWeekNoList = byWeekNoList;
    }

    public String getByMonthList() {
        return this.byMonthList;
    }
    
    public void setByMonthList(String byMonthList) {
        this.byMonthList = byMonthList;
    }

    public String getBySetPosList() {
        return this.bySetPosList;
    }
    
    public void setBySetPosList(String bySetPosList) {
        this.bySetPosList = bySetPosList;
    }

    public String getWeekStart() {
        return this.weekStart;
    }
    
    public void setWeekStart(String weekStart) {
        this.weekStart = weekStart;
    }

    public String getXName() {
        return this.XName;
    }
    
    public void setXName(String XName) {
        this.XName = XName;
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