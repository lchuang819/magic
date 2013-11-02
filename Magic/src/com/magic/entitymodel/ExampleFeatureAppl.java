package com.magic.entitymodel;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * ExampleFeatureAppl entity. @author MyEclipse Persistence Tools
 */

public class ExampleFeatureAppl  implements java.io.Serializable {


    // Fields    

     private ExampleFeatureApplId id;
     private Timestamp thruDate;
     private String exampleFeatureApplTypeId;
     private BigDecimal sequenceNum;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public ExampleFeatureAppl() {
    }

	/** minimal constructor */
    public ExampleFeatureAppl(ExampleFeatureApplId id) {
        this.id = id;
    }
    
    /** full constructor */
    public ExampleFeatureAppl(ExampleFeatureApplId id, Timestamp thruDate, String exampleFeatureApplTypeId, BigDecimal sequenceNum, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.id = id;
        this.thruDate = thruDate;
        this.exampleFeatureApplTypeId = exampleFeatureApplTypeId;
        this.sequenceNum = sequenceNum;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public ExampleFeatureApplId getId() {
        return this.id;
    }
    
    public void setId(ExampleFeatureApplId id) {
        this.id = id;
    }

    public Timestamp getThruDate() {
        return this.thruDate;
    }
    
    public void setThruDate(Timestamp thruDate) {
        this.thruDate = thruDate;
    }

    public String getExampleFeatureApplTypeId() {
        return this.exampleFeatureApplTypeId;
    }
    
    public void setExampleFeatureApplTypeId(String exampleFeatureApplTypeId) {
        this.exampleFeatureApplTypeId = exampleFeatureApplTypeId;
    }

    public BigDecimal getSequenceNum() {
        return this.sequenceNum;
    }
    
    public void setSequenceNum(BigDecimal sequenceNum) {
        this.sequenceNum = sequenceNum;
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