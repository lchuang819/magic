package com.magic.entitymodel;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * PeriodType entity. @author MyEclipse Persistence Tools
 */

public class PeriodType  implements java.io.Serializable {


    // Fields    

     private String periodTypeId;
     private String description;
     private BigDecimal periodLength;
     private String uomId;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public PeriodType() {
    }

	/** minimal constructor */
    public PeriodType(String periodTypeId) {
        this.periodTypeId = periodTypeId;
    }
    
    /** full constructor */
    public PeriodType(String periodTypeId, String description, BigDecimal periodLength, String uomId, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.periodTypeId = periodTypeId;
        this.description = description;
        this.periodLength = periodLength;
        this.uomId = uomId;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public String getPeriodTypeId() {
        return this.periodTypeId;
    }
    
    public void setPeriodTypeId(String periodTypeId) {
        this.periodTypeId = periodTypeId;
    }

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPeriodLength() {
        return this.periodLength;
    }
    
    public void setPeriodLength(BigDecimal periodLength) {
        this.periodLength = periodLength;
    }

    public String getUomId() {
        return this.uomId;
    }
    
    public void setUomId(String uomId) {
        this.uomId = uomId;
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