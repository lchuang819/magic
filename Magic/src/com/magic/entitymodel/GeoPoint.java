package com.magic.entitymodel;

import java.sql.Timestamp;


/**
 * GeoPoint entity. @author MyEclipse Persistence Tools
 */

public class GeoPoint  implements java.io.Serializable {


    // Fields    

     private String geoPointId;
     private String dataSourceId;
     private Double latitude;
     private Double longitude;
     private Double elevation;
     private String elevationUomId;
     private String information;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public GeoPoint() {
    }

	/** minimal constructor */
    public GeoPoint(String geoPointId, Double latitude, Double longitude) {
        this.geoPointId = geoPointId;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    /** full constructor */
    public GeoPoint(String geoPointId, String dataSourceId, Double latitude, Double longitude, Double elevation, String elevationUomId, String information, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.geoPointId = geoPointId;
        this.dataSourceId = dataSourceId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.elevation = elevation;
        this.elevationUomId = elevationUomId;
        this.information = information;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public String getGeoPointId() {
        return this.geoPointId;
    }
    
    public void setGeoPointId(String geoPointId) {
        this.geoPointId = geoPointId;
    }

    public String getDataSourceId() {
        return this.dataSourceId;
    }
    
    public void setDataSourceId(String dataSourceId) {
        this.dataSourceId = dataSourceId;
    }

    public Double getLatitude() {
        return this.latitude;
    }
    
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return this.longitude;
    }
    
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getElevation() {
        return this.elevation;
    }
    
    public void setElevation(Double elevation) {
        this.elevation = elevation;
    }

    public String getElevationUomId() {
        return this.elevationUomId;
    }
    
    public void setElevationUomId(String elevationUomId) {
        this.elevationUomId = elevationUomId;
    }

    public String getInformation() {
        return this.information;
    }
    
    public void setInformation(String information) {
        this.information = information;
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