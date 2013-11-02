package com.magic.entitymodel;

import java.sql.Timestamp;


/**
 * ProtocolType entity. @author MyEclipse Persistence Tools
 */

public class ProtocolType  implements java.io.Serializable {


    // Fields    

     private String protocolTypeId;
     private String protocolName;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public ProtocolType() {
    }

	/** minimal constructor */
    public ProtocolType(String protocolTypeId) {
        this.protocolTypeId = protocolTypeId;
    }
    
    /** full constructor */
    public ProtocolType(String protocolTypeId, String protocolName, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.protocolTypeId = protocolTypeId;
        this.protocolName = protocolName;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public String getProtocolTypeId() {
        return this.protocolTypeId;
    }
    
    public void setProtocolTypeId(String protocolTypeId) {
        this.protocolTypeId = protocolTypeId;
    }

    public String getProtocolName() {
        return this.protocolName;
    }
    
    public void setProtocolName(String protocolName) {
        this.protocolName = protocolName;
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