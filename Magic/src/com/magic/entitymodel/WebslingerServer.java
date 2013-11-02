package com.magic.entitymodel;

import java.sql.Timestamp;


/**
 * WebslingerServer entity. @author MyEclipse Persistence Tools
 */

public class WebslingerServer  implements java.io.Serializable {


    // Fields    

     private String webslingerServerId;
     private String delegatorName;
     private String dispatcherName;
     private String serverName;
     private String webSiteId;
     private String target;
     private String loadAtStart;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public WebslingerServer() {
    }

	/** minimal constructor */
    public WebslingerServer(String webslingerServerId) {
        this.webslingerServerId = webslingerServerId;
    }
    
    /** full constructor */
    public WebslingerServer(String webslingerServerId, String delegatorName, String dispatcherName, String serverName, String webSiteId, String target, String loadAtStart, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.webslingerServerId = webslingerServerId;
        this.delegatorName = delegatorName;
        this.dispatcherName = dispatcherName;
        this.serverName = serverName;
        this.webSiteId = webSiteId;
        this.target = target;
        this.loadAtStart = loadAtStart;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public String getWebslingerServerId() {
        return this.webslingerServerId;
    }
    
    public void setWebslingerServerId(String webslingerServerId) {
        this.webslingerServerId = webslingerServerId;
    }

    public String getDelegatorName() {
        return this.delegatorName;
    }
    
    public void setDelegatorName(String delegatorName) {
        this.delegatorName = delegatorName;
    }

    public String getDispatcherName() {
        return this.dispatcherName;
    }
    
    public void setDispatcherName(String dispatcherName) {
        this.dispatcherName = dispatcherName;
    }

    public String getServerName() {
        return this.serverName;
    }
    
    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getWebSiteId() {
        return this.webSiteId;
    }
    
    public void setWebSiteId(String webSiteId) {
        this.webSiteId = webSiteId;
    }

    public String getTarget() {
        return this.target;
    }
    
    public void setTarget(String target) {
        this.target = target;
    }

    public String getLoadAtStart() {
        return this.loadAtStart;
    }
    
    public void setLoadAtStart(String loadAtStart) {
        this.loadAtStart = loadAtStart;
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