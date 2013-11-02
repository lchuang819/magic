package com.magic.entitymodel;

import java.sql.Timestamp;


/**
 * RuntimeData entity. @author MyEclipse Persistence Tools
 */

public class RuntimeData  implements java.io.Serializable {


    // Fields    

     private String runtimeDataId;
     private String runtimeInfo;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public RuntimeData() {
    }

	/** minimal constructor */
    public RuntimeData(String runtimeDataId) {
        this.runtimeDataId = runtimeDataId;
    }
    
    /** full constructor */
    public RuntimeData(String runtimeDataId, String runtimeInfo, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.runtimeDataId = runtimeDataId;
        this.runtimeInfo = runtimeInfo;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public String getRuntimeDataId() {
        return this.runtimeDataId;
    }
    
    public void setRuntimeDataId(String runtimeDataId) {
        this.runtimeDataId = runtimeDataId;
    }

    public String getRuntimeInfo() {
        return this.runtimeInfo;
    }
    
    public void setRuntimeInfo(String runtimeInfo) {
        this.runtimeInfo = runtimeInfo;
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