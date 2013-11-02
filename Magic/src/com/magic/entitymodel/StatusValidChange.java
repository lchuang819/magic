package com.magic.entitymodel;

import java.sql.Timestamp;


/**
 * StatusValidChange entity. @author MyEclipse Persistence Tools
 */

public class StatusValidChange  implements java.io.Serializable {


    // Fields    

     private StatusValidChangeId id;
     private String conditionExpression;
     private String transitionName;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public StatusValidChange() {
    }

	/** minimal constructor */
    public StatusValidChange(StatusValidChangeId id) {
        this.id = id;
    }
    
    /** full constructor */
    public StatusValidChange(StatusValidChangeId id, String conditionExpression, String transitionName, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.id = id;
        this.conditionExpression = conditionExpression;
        this.transitionName = transitionName;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public StatusValidChangeId getId() {
        return this.id;
    }
    
    public void setId(StatusValidChangeId id) {
        this.id = id;
    }

    public String getConditionExpression() {
        return this.conditionExpression;
    }
    
    public void setConditionExpression(String conditionExpression) {
        this.conditionExpression = conditionExpression;
    }

    public String getTransitionName() {
        return this.transitionName;
    }
    
    public void setTransitionName(String transitionName) {
        this.transitionName = transitionName;
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