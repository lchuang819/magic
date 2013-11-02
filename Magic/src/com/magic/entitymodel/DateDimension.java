package com.magic.entitymodel;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;


/**
 * DateDimension entity. @author MyEclipse Persistence Tools
 */

public class DateDimension  implements java.io.Serializable {


    // Fields    

     private String dimensionId;
     private Date dateValue;
     private String description;
     private String dayName;
     private BigDecimal dayOfMonth;
     private BigDecimal dayOfYear;
     private String monthName;
     private BigDecimal monthOfYear;
     private BigDecimal yearName;
     private BigDecimal weekOfMonth;
     private BigDecimal weekOfYear;
     private String yearMonthDay;
     private String yearAndMonth;
     private String weekdayType;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public DateDimension() {
    }

	/** minimal constructor */
    public DateDimension(String dimensionId) {
        this.dimensionId = dimensionId;
    }
    
    /** full constructor */
    public DateDimension(String dimensionId, Date dateValue, String description, String dayName, BigDecimal dayOfMonth, BigDecimal dayOfYear, String monthName, BigDecimal monthOfYear, BigDecimal yearName, BigDecimal weekOfMonth, BigDecimal weekOfYear, String yearMonthDay, String yearAndMonth, String weekdayType, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.dimensionId = dimensionId;
        this.dateValue = dateValue;
        this.description = description;
        this.dayName = dayName;
        this.dayOfMonth = dayOfMonth;
        this.dayOfYear = dayOfYear;
        this.monthName = monthName;
        this.monthOfYear = monthOfYear;
        this.yearName = yearName;
        this.weekOfMonth = weekOfMonth;
        this.weekOfYear = weekOfYear;
        this.yearMonthDay = yearMonthDay;
        this.yearAndMonth = yearAndMonth;
        this.weekdayType = weekdayType;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public String getDimensionId() {
        return this.dimensionId;
    }
    
    public void setDimensionId(String dimensionId) {
        this.dimensionId = dimensionId;
    }

    public Date getDateValue() {
        return this.dateValue;
    }
    
    public void setDateValue(Date dateValue) {
        this.dateValue = dateValue;
    }

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public String getDayName() {
        return this.dayName;
    }
    
    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public BigDecimal getDayOfMonth() {
        return this.dayOfMonth;
    }
    
    public void setDayOfMonth(BigDecimal dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public BigDecimal getDayOfYear() {
        return this.dayOfYear;
    }
    
    public void setDayOfYear(BigDecimal dayOfYear) {
        this.dayOfYear = dayOfYear;
    }

    public String getMonthName() {
        return this.monthName;
    }
    
    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }

    public BigDecimal getMonthOfYear() {
        return this.monthOfYear;
    }
    
    public void setMonthOfYear(BigDecimal monthOfYear) {
        this.monthOfYear = monthOfYear;
    }

    public BigDecimal getYearName() {
        return this.yearName;
    }
    
    public void setYearName(BigDecimal yearName) {
        this.yearName = yearName;
    }

    public BigDecimal getWeekOfMonth() {
        return this.weekOfMonth;
    }
    
    public void setWeekOfMonth(BigDecimal weekOfMonth) {
        this.weekOfMonth = weekOfMonth;
    }

    public BigDecimal getWeekOfYear() {
        return this.weekOfYear;
    }
    
    public void setWeekOfYear(BigDecimal weekOfYear) {
        this.weekOfYear = weekOfYear;
    }

    public String getYearMonthDay() {
        return this.yearMonthDay;
    }
    
    public void setYearMonthDay(String yearMonthDay) {
        this.yearMonthDay = yearMonthDay;
    }

    public String getYearAndMonth() {
        return this.yearAndMonth;
    }
    
    public void setYearAndMonth(String yearAndMonth) {
        this.yearAndMonth = yearAndMonth;
    }

    public String getWeekdayType() {
        return this.weekdayType;
    }
    
    public void setWeekdayType(String weekdayType) {
        this.weekdayType = weekdayType;
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