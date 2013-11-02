package com.magic.entitymodel;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * TemporalExpression entity. @author MyEclipse Persistence Tools
 */

public class TemporalExpression  implements java.io.Serializable {


    // Fields    

     private String tempExprId;
     private String tempExprTypeId;
     private Timestamp date1;
     private Timestamp date2;
     private BigDecimal integer1;
     private BigDecimal integer2;
     private String string1;
     private String string2;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public TemporalExpression() {
    }

	/** minimal constructor */
    public TemporalExpression(String tempExprId) {
        this.tempExprId = tempExprId;
    }
    
    /** full constructor */
    public TemporalExpression(String tempExprId, String tempExprTypeId, Timestamp date1, Timestamp date2, BigDecimal integer1, BigDecimal integer2, String string1, String string2, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.tempExprId = tempExprId;
        this.tempExprTypeId = tempExprTypeId;
        this.date1 = date1;
        this.date2 = date2;
        this.integer1 = integer1;
        this.integer2 = integer2;
        this.string1 = string1;
        this.string2 = string2;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public String getTempExprId() {
        return this.tempExprId;
    }
    
    public void setTempExprId(String tempExprId) {
        this.tempExprId = tempExprId;
    }

    public String getTempExprTypeId() {
        return this.tempExprTypeId;
    }
    
    public void setTempExprTypeId(String tempExprTypeId) {
        this.tempExprTypeId = tempExprTypeId;
    }

    public Timestamp getDate1() {
        return this.date1;
    }
    
    public void setDate1(Timestamp date1) {
        this.date1 = date1;
    }

    public Timestamp getDate2() {
        return this.date2;
    }
    
    public void setDate2(Timestamp date2) {
        this.date2 = date2;
    }

    public BigDecimal getInteger1() {
        return this.integer1;
    }
    
    public void setInteger1(BigDecimal integer1) {
        this.integer1 = integer1;
    }

    public BigDecimal getInteger2() {
        return this.integer2;
    }
    
    public void setInteger2(BigDecimal integer2) {
        this.integer2 = integer2;
    }

    public String getString1() {
        return this.string1;
    }
    
    public void setString1(String string1) {
        this.string1 = string1;
    }

    public String getString2() {
        return this.string2;
    }
    
    public void setString2(String string2) {
        this.string2 = string2;
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