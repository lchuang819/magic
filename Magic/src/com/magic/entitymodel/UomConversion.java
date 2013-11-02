package com.magic.entitymodel;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * UomConversion entity. @author MyEclipse Persistence Tools
 */

public class UomConversion  implements java.io.Serializable {


    // Fields    

     private UomConversionId id;
     private Double conversionFactor;
     private String customMethodId;
     private BigDecimal decimalScale;
     private String roundingMode;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public UomConversion() {
    }

	/** minimal constructor */
    public UomConversion(UomConversionId id) {
        this.id = id;
    }
    
    /** full constructor */
    public UomConversion(UomConversionId id, Double conversionFactor, String customMethodId, BigDecimal decimalScale, String roundingMode, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.id = id;
        this.conversionFactor = conversionFactor;
        this.customMethodId = customMethodId;
        this.decimalScale = decimalScale;
        this.roundingMode = roundingMode;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public UomConversionId getId() {
        return this.id;
    }
    
    public void setId(UomConversionId id) {
        this.id = id;
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