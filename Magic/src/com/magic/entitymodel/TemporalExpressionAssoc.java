package com.magic.entitymodel;

import java.sql.Timestamp;


/**
 * TemporalExpressionAssoc entity. @author MyEclipse Persistence Tools
 */

public class TemporalExpressionAssoc  implements java.io.Serializable {


    // Fields    

     private TemporalExpressionAssocId id;
     private String exprAssocType;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public TemporalExpressionAssoc() {
    }

	/** minimal constructor */
    public TemporalExpressionAssoc(TemporalExpressionAssocId id) {
        this.id = id;
    }
    
    /** full constructor */
    public TemporalExpressionAssoc(TemporalExpressionAssocId id, String exprAssocType, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.id = id;
        this.exprAssocType = exprAssocType;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public TemporalExpressionAssocId getId() {
        return this.id;
    }
    
    public void setId(TemporalExpressionAssocId id) {
        this.id = id;
    }

    public String getExprAssocType() {
        return this.exprAssocType;
    }
    
    public void setExprAssocType(String exprAssocType) {
        this.exprAssocType = exprAssocType;
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