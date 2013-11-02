package com.magic.entitymodel;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * UomConversionDated entity. @author MyEclipse Persistence Tools
 */

public class UomConversionDated  implements java.io.Serializable {


    // Fields    

     private UomConversionDatedId id;
     private Timestamp thruDate;
     private Double conversionFactor;
     private String customMethodId;
     private BigDecimal decimalScale;
     private String roundingMode;
     private String purposeEnumId;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public UomConversionDated() {
    }

	/** minimal constructor */
    public UomConversionDated(UomConversionDatedId id) {
        this.id = id;
    }
    
    /** full constructor */
    public UomConversionDated(UomConversionDatedId id, Timestamp thruDate, Double conversionFactor, String customMethodId, BigDecimal decimalScale, String roundingMode, String purposeEnumId, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.id = id;
        this.thruDate = thruDate;
        this.conversionFactor = conversionFactor;
        this.customMethodId = customMethodId;
        this.decimalScale = decimalScale;
        this.roundingMode = roundingMode;
        this.purposeEnumId = purposeEnumId;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public UomConversionDatedId getId() {
        return this.id;
    }
    
    public void setId(UomConversionDatedId id) {
        this.id = id;
    }

    public Timestamp getThruDate() {
        return this.thruDate;
    }
    
    public void setThruDate(Timestamp thruDate) {
        this.thruDate = thruDate;
    }

    public Double getConversionFactor() {
        return this.conversionFactor;
    }
    
    public void setConversionFactor(Double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public String getCustomMethodId() {
        return this.customMethodId;
    }
    
    public void setCustomMethodId(String customMethodId) {
        this.customMethodId = customMethodId;
    }

    public BigDecimal getDecimalScale() {
        return this.decimalScale;
    }
    
    public void setDecimalScale(BigDecimal decimalScale) {
        this.decimalScale = decimalScale;
    }

    public String getRoundingMode() {
        return this.roundingMode;
    }
    
    public void setRoundingMode(String roundingMode) {
        this.roundingMode = roundingMode;
    }

    public String getPurposeEnumId() {
        return this.purposeEnumId;
    }
    
    public void setPurposeEnumId(String purposeEnumId) {
        this.purposeEnumId = purposeEnumId;
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