package com.magic.entitymodel;

import java.sql.Timestamp;


/**
 * Enumeration entity. @author MyEclipse Persistence Tools
 */

public class Enumeration  implements java.io.Serializable {


    // Fields    

     private String enumId;
     private String enumTypeId;
     private String enumCode;
     private String sequenceId;
     private String description;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public Enumeration() {
    }

	/** minimal constructor */
    public Enumeration(String enumId) {
        this.enumId = enumId;
    }
    
    /** full constructor */
    public Enumeration(String enumId, String enumTypeId, String enumCode, String sequenceId, String description, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.enumId = enumId;
        this.enumTypeId = enumTypeId;
        this.enumCode = enumCode;
        this.sequenceId = sequenceId;
        this.description = description;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public String getEnumId() {
        return this.enumId;
    }
    
    public void setEnumId(String enumId) {
        this.enumId = enumId;
    }

    public String getEnumTypeId() {
        return this.enumTypeId;
    }
    
    public void setEnumTypeId(String enumTypeId) {
        this.enumTypeId = enumTypeId;
    }

    public String getEnumCode() {
        return this.enumCode;
    }
    
    public void setEnumCode(String enumCode) {
        this.enumCode = enumCode;
    }

    public String getSequenceId() {
        return this.sequenceId;
    }
    
    public void setSequenceId(String sequenceId) {
        this.sequenceId = sequenceId;
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