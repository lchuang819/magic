package com.magic.entitymodel;

import java.sql.Timestamp;


/**
 * TestingNodeMember entity. @author MyEclipse Persistence Tools
 */

public class TestingNodeMember  implements java.io.Serializable {


    // Fields    

     private TestingNodeMemberId id;
     private Timestamp thruDate;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public TestingNodeMember() {
    }

	/** minimal constructor */
    public TestingNodeMember(TestingNodeMemberId id) {
        this.id = id;
    }
    
    /** full constructor */
    public TestingNodeMember(TestingNodeMemberId id, Timestamp thruDate, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.id = id;
        this.thruDate = thruDate;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public TestingNodeMemberId getId() {
        return this.id;
    }
    
    public void setId(TestingNodeMemberId id) {
        this.id = id;
    }

    public Timestamp getThruDate() {
        return this.thruDate;
    }
    
    public void setThruDate(Timestamp thruDate) {
        this.thruDate = thruDate;
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