package com.magic.entitymodel;

import java.sql.Timestamp;


/**
 * ServiceSemaphore entity. @author MyEclipse Persistence Tools
 */

public class ServiceSemaphore  implements java.io.Serializable {


    // Fields    

     private String serviceName;
     private String lockThread;
     private Timestamp lockTime;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public ServiceSemaphore() {
    }

	/** minimal constructor */
    public ServiceSemaphore(String serviceName) {
        this.serviceName = serviceName;
    }
    
    /** full constructor */
    public ServiceSemaphore(String serviceName, String lockThread, Timestamp lockTime, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.serviceName = serviceName;
        this.lockThread = lockThread;
        this.lockTime = lockTime;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public String getServiceName() {
        return this.serviceName;
    }
    
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getLockThread() {
        return this.lockThread;
    }
    
    public void setLockThread(String lockThread) {
        this.lockThread = lockThread;
    }

    public Timestamp getLockTime() {
        return this.lockTime;
    }
    
    public void setLockTime(Timestamp lockTime) {
        this.lockTime = lockTime;
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