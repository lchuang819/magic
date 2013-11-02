package com.magic.entitymodel;

import java.sql.Timestamp;


/**
 * GeoAssoc entity. @author MyEclipse Persistence Tools
 */

public class GeoAssoc  implements java.io.Serializable {


    // Fields    

     private GeoAssocId id;
     private String geoAssocTypeId;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public GeoAssoc() {
    }

	/** minimal constructor */
    public GeoAssoc(GeoAssocId id) {
        this.id = id;
    }
    
    /** full constructor */
    public GeoAssoc(GeoAssocId id, String geoAssocTypeId, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.id = id;
        this.geoAssocTypeId = geoAssocTypeId;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public GeoAssocId getId() {
        return this.id;
    }
    
    public void setId(GeoAssocId id) {
        this.id = id;
    }

    public String getGeoAssocTypeId() {
        return this.geoAssocTypeId;
    }
    
    public void setGeoAssocTypeId(String geoAssocTypeId) {
        this.geoAssocTypeId = geoAssocTypeId;
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