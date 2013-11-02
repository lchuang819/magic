package com.magic.entitymodel;

import java.sql.Timestamp;


/**
 * WebslingerHostMapping entity. @author MyEclipse Persistence Tools
 */

public class WebslingerHostMapping  implements java.io.Serializable {


    // Fields    

     private WebslingerHostMappingId id;
     private String webslingerServerId;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public WebslingerHostMapping() {
    }

	/** minimal constructor */
    public WebslingerHostMapping(WebslingerHostMappingId id) {
        this.id = id;
    }
    
    /** full constructor */
    public WebslingerHostMapping(WebslingerHostMappingId id, String webslingerServerId, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.id = id;
        this.webslingerServerId = webslingerServerId;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public WebslingerHostMappingId getId() {
        return this.id;
    }
    
    public void setId(WebslingerHostMappingId id) {
        this.id = id;
    }

    public String getWebslingerServerId() {
        return this.webslingerServerId;
    }
    
    public void setWebslingerServerId(String webslingerServerId) {
        this.webslingerServerId = webslingerServerId;
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