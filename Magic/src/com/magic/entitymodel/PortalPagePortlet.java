package com.magic.entitymodel;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * PortalPagePortlet entity. @author MyEclipse Persistence Tools
 */

public class PortalPagePortlet  implements java.io.Serializable {


    // Fields    

     private PortalPagePortletId id;
     private String columnSeqId;
     private BigDecimal sequenceNum;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public PortalPagePortlet() {
    }

	/** minimal constructor */
    public PortalPagePortlet(PortalPagePortletId id) {
        this.id = id;
    }
    
    /** full constructor */
    public PortalPagePortlet(PortalPagePortletId id, String columnSeqId, BigDecimal sequenceNum, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.id = id;
        this.columnSeqId = columnSeqId;
        this.sequenceNum = sequenceNum;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public PortalPagePortletId getId() {
        return this.id;
    }
    
    public void setId(PortalPagePortletId id) {
        this.id = id;
    }

    public String getColumnSeqId() {
        return this.columnSeqId;
    }
    
    public void setColumnSeqId(String columnSeqId) {
        this.columnSeqId = columnSeqId;
    }

    public BigDecimal getSequenceNum() {
        return this.sequenceNum;
    }
    
    public void setSequenceNum(BigDecimal sequenceNum) {
        this.sequenceNum = sequenceNum;
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