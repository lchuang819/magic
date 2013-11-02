package com.magic.entitymodel;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * WebslingerServerBase entity. @author MyEclipse Persistence Tools
 */

public class WebslingerServerBase  implements java.io.Serializable {


    // Fields    

     private WebslingerServerBaseId id;
     private BigDecimal seqNum;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public WebslingerServerBase() {
    }

	/** minimal constructor */
    public WebslingerServerBase(WebslingerServerBaseId id) {
        this.id = id;
    }
    
    /** full constructor */
    public WebslingerServerBase(WebslingerServerBaseId id, BigDecimal seqNum, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.id = id;
        this.seqNum = seqNum;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public WebslingerServerBaseId getId() {
        return this.id;
    }
    
    public void setId(WebslingerServerBaseId id) {
        this.id = id;
    }

    public BigDecimal getSeqNum() {
        return this.seqNum;
    }
    
    public void setSeqNum(BigDecimal seqNum) {
        this.seqNum = seqNum;
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