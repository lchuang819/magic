package com.magic.entitymodel;

import java.sql.Timestamp;


/**
 * ExampleItem entity. @author MyEclipse Persistence Tools
 */

public class ExampleItem  implements java.io.Serializable {


    // Fields    

     private ExampleItemId id;
     private String description;
     private Double amount;
     private String amountUomId;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public ExampleItem() {
    }

	/** minimal constructor */
    public ExampleItem(ExampleItemId id) {
        this.id = id;
    }
    
    /** full constructor */
    public ExampleItem(ExampleItemId id, String description, Double amount, String amountUomId, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.amountUomId = amountUomId;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public ExampleItemId getId() {
        return this.id;
    }
    
    public void setId(ExampleItemId id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public Double getAmount() {
        return this.amount;
    }
    
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getAmountUomId() {
        return this.amountUomId;
    }
    
    public void setAmountUomId(String amountUomId) {
        this.amountUomId = amountUomId;
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