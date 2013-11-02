package com.magic.entitymodel;

import java.sql.Timestamp;


/**
 * CurrencyDimension entity. @author MyEclipse Persistence Tools
 */

public class CurrencyDimension  implements java.io.Serializable {


    // Fields    

     private String dimensionId;
     private String currencyId;
     private String description;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public CurrencyDimension() {
    }

	/** minimal constructor */
    public CurrencyDimension(String dimensionId) {
        this.dimensionId = dimensionId;
    }
    
    /** full constructor */
    public CurrencyDimension(String dimensionId, String currencyId, String description, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.dimensionId = dimensionId;
        this.currencyId = currencyId;
        this.description = description;
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

    public String getCurrencyId() {
        return this.currencyId;
    }
    
    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
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