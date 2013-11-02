package com.magic.entitymodel;

import java.sql.Timestamp;


/**
 * PortletAttribute entity. @author MyEclipse Persistence Tools
 */

public class PortletAttribute  implements java.io.Serializable {


    // Fields    

     private PortletAttributeId id;
     private String attrValue;
     private String attrType;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public PortletAttribute() {
    }

	/** minimal constructor */
    public PortletAttribute(PortletAttributeId id) {
        this.id = id;
    }
    
    /** full constructor */
    public PortletAttribute(PortletAttributeId id, String attrValue, String attrType, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.id = id;
        this.attrValue = attrValue;
        this.attrType = attrType;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public PortletAttributeId getId() {
        return this.id;
    }
    
    public void setId(PortletAttributeId id) {
        this.id = id;
    }

    public String getAttrValue() {
        return this.attrValue;
    }
    
    public void setAttrValue(String attrValue) {
        this.attrValue = attrValue;
    }

    public String getAttrType() {
        return this.attrType;
    }
    
    public void setAttrType(String attrType) {
        this.attrType = attrType;
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