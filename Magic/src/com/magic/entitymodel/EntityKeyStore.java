package com.magic.entitymodel;

import java.sql.Timestamp;


/**
 * EntityKeyStore entity. @author MyEclipse Persistence Tools
 */

public class EntityKeyStore  implements java.io.Serializable {


    // Fields    

     private String keyName;
     private String keyText;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public EntityKeyStore() {
    }

	/** minimal constructor */
    public EntityKeyStore(String keyName) {
        this.keyName = keyName;
    }
    
    /** full constructor */
    public EntityKeyStore(String keyName, String keyText, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.keyName = keyName;
        this.keyText = keyText;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public String getKeyName() {
        return this.keyName;
    }
    
    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String getKeyText() {
        return this.keyText;
    }
    
    public void setKeyText(String keyText) {
        this.keyText = keyText;
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