package com.magic.entitymodel;

import java.sql.Timestamp;


/**
 * VisualThemeResource entity. @author MyEclipse Persistence Tools
 */

public class VisualThemeResource  implements java.io.Serializable {


    // Fields    

     private VisualThemeResourceId id;
     private String resourceValue;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public VisualThemeResource() {
    }

	/** minimal constructor */
    public VisualThemeResource(VisualThemeResourceId id) {
        this.id = id;
    }
    
    /** full constructor */
    public VisualThemeResource(VisualThemeResourceId id, String resourceValue, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.id = id;
        this.resourceValue = resourceValue;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public VisualThemeResourceId getId() {
        return this.id;
    }
    
    public void setId(VisualThemeResourceId id) {
        this.id = id;
    }

    public String getResourceValue() {
        return this.resourceValue;
    }
    
    public void setResourceValue(String resourceValue) {
        this.resourceValue = resourceValue;
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