package com.magic.entitymodel;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * ServerHit entity. @author MyEclipse Persistence Tools
 */

public class ServerHit  implements java.io.Serializable {


    // Fields    

     private ServerHitId id;
     private BigDecimal numOfBytes;
     private BigDecimal runningTimeMillis;
     private String userLoginId;
     private String statusId;
     private String requestUrl;
     private String referrerUrl;
     private String serverIpAddress;
     private String serverHostName;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public ServerHit() {
    }

	/** minimal constructor */
    public ServerHit(ServerHitId id) {
        this.id = id;
    }
    
    /** full constructor */
    public ServerHit(ServerHitId id, BigDecimal numOfBytes, BigDecimal runningTimeMillis, String userLoginId, String statusId, String requestUrl, String referrerUrl, String serverIpAddress, String serverHostName, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.id = id;
        this.numOfBytes = numOfBytes;
        this.runningTimeMillis = runningTimeMillis;
        this.userLoginId = userLoginId;
        this.statusId = statusId;
        this.requestUrl = requestUrl;
        this.referrerUrl = referrerUrl;
        this.serverIpAddress = serverIpAddress;
        this.serverHostName = serverHostName;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public ServerHitId getId() {
        return this.id;
    }
    
    public void setId(ServerHitId id) {
        this.id = id;
    }

    public BigDecimal getNumOfBytes() {
        return this.numOfBytes;
    }
    
    public void setNumOfBytes(BigDecimal numOfBytes) {
        this.numOfBytes = numOfBytes;
    }

    public BigDecimal getRunningTimeMillis() {
        return this.runningTimeMillis;
    }
    
    public void setRunningTimeMillis(BigDecimal runningTimeMillis) {
        this.runningTimeMillis = runningTimeMillis;
    }

    public String getUserLoginId() {
        return this.userLoginId;
    }
    
    public void setUserLoginId(String userLoginId) {
        this.userLoginId = userLoginId;
    }

    public String getStatusId() {
        return this.statusId;
    }
    
    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public String getRequestUrl() {
        return this.requestUrl;
    }
    
    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getReferrerUrl() {
        return this.referrerUrl;
    }
    
    public void setReferrerUrl(String referrerUrl) {
        this.referrerUrl = referrerUrl;
    }

    public String getServerIpAddress() {
        return this.serverIpAddress;
    }
    
    public void setServerIpAddress(String serverIpAddress) {
        this.serverIpAddress = serverIpAddress;
    }

    public String getServerHostName() {
        return this.serverHostName;
    }
    
    public void setServerHostName(String serverHostName) {
        this.serverHostName = serverHostName;
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