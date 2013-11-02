package com.magic.entitymodel;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * CatalinaSession entity. @author MyEclipse Persistence Tools
 */

public class CatalinaSession  implements java.io.Serializable {


    // Fields    

     private String sessionId;
     private BigDecimal sessionSize;
     private String sessionInfo;
     private String isValid;
     private BigDecimal maxIdle;
     private BigDecimal lastAccessed;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public CatalinaSession() {
    }

	/** minimal constructor */
    public CatalinaSession(String sessionId) {
        this.sessionId = sessionId;
    }
    
    /** full constructor */
    public CatalinaSession(String sessionId, BigDecimal sessionSize, String sessionInfo, String isValid, BigDecimal maxIdle, BigDecimal lastAccessed, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.sessionId = sessionId;
        this.sessionSize = sessionSize;
        this.sessionInfo = sessionInfo;
        this.isValid = isValid;
        this.maxIdle = maxIdle;
        this.lastAccessed = lastAccessed;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public String getSessionId() {
        return this.sessionId;
    }
    
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public BigDecimal getSessionSize() {
        return this.sessionSize;
    }
    
    public void setSessionSize(BigDecimal sessionSize) {
        this.sessionSize = sessionSize;
    }

    public String getSessionInfo() {
        return this.sessionInfo;
    }
    
    public void setSessionInfo(String sessionInfo) {
        this.sessionInfo = sessionInfo;
    }

    public String getIsValid() {
        return this.isValid;
    }
    
    public void setIsValid(String isValid) {
        this.isValid = isValid;
    }

    public BigDecimal getMaxIdle() {
        return this.maxIdle;
    }
    
    public void setMaxIdle(BigDecimal maxIdle) {
        this.maxIdle = maxIdle;
    }

    public BigDecimal getLastAccessed() {
        return this.lastAccessed;
    }
    
    public void setLastAccessed(BigDecimal lastAccessed) {
        this.lastAccessed = lastAccessed;
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