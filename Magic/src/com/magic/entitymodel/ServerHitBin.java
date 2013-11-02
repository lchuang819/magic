package com.magic.entitymodel;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * ServerHitBin entity. @author MyEclipse Persistence Tools
 */

public class ServerHitBin  implements java.io.Serializable {


    // Fields    

     private String serverHitBinId;
     private String contentId;
     private String hitTypeId;
     private String serverIpAddress;
     private String serverHostName;
     private Timestamp binStartDateTime;
     private Timestamp binEndDateTime;
     private BigDecimal numberHits;
     private BigDecimal totalTimeMillis;
     private BigDecimal minTimeMillis;
     private BigDecimal maxTimeMillis;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public ServerHitBin() {
    }

	/** minimal constructor */
    public ServerHitBin(String serverHitBinId) {
        this.serverHitBinId = serverHitBinId;
    }
    
    /** full constructor */
    public ServerHitBin(String serverHitBinId, String contentId, String hitTypeId, String serverIpAddress, String serverHostName, Timestamp binStartDateTime, Timestamp binEndDateTime, BigDecimal numberHits, BigDecimal totalTimeMillis, BigDecimal minTimeMillis, BigDecimal maxTimeMillis, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.serverHitBinId = serverHitBinId;
        this.contentId = contentId;
        this.hitTypeId = hitTypeId;
        this.serverIpAddress = serverIpAddress;
        this.serverHostName = serverHostName;
        this.binStartDateTime = binStartDateTime;
        this.binEndDateTime = binEndDateTime;
        this.numberHits = numberHits;
        this.totalTimeMillis = totalTimeMillis;
        this.minTimeMillis = minTimeMillis;
        this.maxTimeMillis = maxTimeMillis;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public String getServerHitBinId() {
        return this.serverHitBinId;
    }
    
    public void setServerHitBinId(String serverHitBinId) {
        this.serverHitBinId = serverHitBinId;
    }

    public String getContentId() {
        return this.contentId;
    }
    
    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getHitTypeId() {
        return this.hitTypeId;
    }
    
    public void setHitTypeId(String hitTypeId) {
        this.hitTypeId = hitTypeId;
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

    public Timestamp getBinStartDateTime() {
        return this.binStartDateTime;
    }
    
    public void setBinStartDateTime(Timestamp binStartDateTime) {
        this.binStartDateTime = binStartDateTime;
    }

    public Timestamp getBinEndDateTime() {
        return this.binEndDateTime;
    }
    
    public void setBinEndDateTime(Timestamp binEndDateTime) {
        this.binEndDateTime = binEndDateTime;
    }

    public BigDecimal getNumberHits() {
        return this.numberHits;
    }
    
    public void setNumberHits(BigDecimal numberHits) {
        this.numberHits = numberHits;
    }

    public BigDecimal getTotalTimeMillis() {
        return this.totalTimeMillis;
    }
    
    public void setTotalTimeMillis(BigDecimal totalTimeMillis) {
        this.totalTimeMillis = totalTimeMillis;
    }

    public BigDecimal getMinTimeMillis() {
        return this.minTimeMillis;
    }
    
    public void setMinTimeMillis(BigDecimal minTimeMillis) {
        this.minTimeMillis = minTimeMillis;
    }

    public BigDecimal getMaxTimeMillis() {
        return this.maxTimeMillis;
    }
    
    public void setMaxTimeMillis(BigDecimal maxTimeMillis) {
        this.maxTimeMillis = maxTimeMillis;
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