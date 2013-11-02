package com.magic.entitymodel;

import java.sql.Timestamp;


/**
 * DataSource entity. @author MyEclipse Persistence Tools
 */

public class DataSource  implements java.io.Serializable {


    // Fields    

     private String dataSourceId;
     private String dataSourceTypeId;
     private String description;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public DataSource() {
    }

	/** minimal constructor */
    public DataSource(String dataSourceId) {
        this.dataSourceId = dataSourceId;
    }
    
    /** full constructor */
    public DataSource(String dataSourceId, String dataSourceTypeId, String description, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.dataSourceId = dataSourceId;
        this.dataSourceTypeId = dataSourceTypeId;
        this.description = description;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public String getDataSourceId() {
        return this.dataSourceId;
    }
    
    public void setDataSourceId(String dataSourceId) {
        this.dataSourceId = dataSourceId;
    }

    public String getDataSourceTypeId() {
        return this.dataSourceTypeId;
    }
    
    public void setDataSourceTypeId(String dataSourceTypeId) {
        this.dataSourceTypeId = dataSourceTypeId;
    }

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
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