package com.magic.entitymodel;

import java.sql.Timestamp;


/**
 * Geo entity. @author MyEclipse Persistence Tools
 */

public class Geo  implements java.io.Serializable {


    // Fields    

     private String geoId;
     private String geoTypeId;
     private String geoName;
     private String geoCode;
     private String geoSecCode;
     private String abbreviation;
     private String wellKnownText;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public Geo() {
    }

	/** minimal constructor */
    public Geo(String geoId) {
        this.geoId = geoId;
    }
    
    /** full constructor */
    public Geo(String geoId, String geoTypeId, String geoName, String geoCode, String geoSecCode, String abbreviation, String wellKnownText, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.geoId = geoId;
        this.geoTypeId = geoTypeId;
        this.geoName = geoName;
        this.geoCode = geoCode;
        this.geoSecCode = geoSecCode;
        this.abbreviation = abbreviation;
        this.wellKnownText = wellKnownText;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public String getGeoId() {
        return this.geoId;
    }
    
    public void setGeoId(String geoId) {
        this.geoId = geoId;
    }

    public String getGeoTypeId() {
        return this.geoTypeId;
    }
    
    public void setGeoTypeId(String geoTypeId) {
        this.geoTypeId = geoTypeId;
    }

    public String getGeoName() {
        return this.geoName;
    }
    
    public void setGeoName(String geoName) {
        this.geoName = geoName;
    }

    public String getGeoCode() {
        return this.geoCode;
    }
    
    public void setGeoCode(String geoCode) {
        this.geoCode = geoCode;
    }

    public String getGeoSecCode() {
        return this.geoSecCode;
    }
    
    public void setGeoSecCode(String geoSecCode) {
        this.geoSecCode = geoSecCode;
    }

    public String getAbbreviation() {
        return this.abbreviation;
    }
    
    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getWellKnownText() {
        return this.wellKnownText;
    }
    
    public void setWellKnownText(String wellKnownText) {
        this.wellKnownText = wellKnownText;
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