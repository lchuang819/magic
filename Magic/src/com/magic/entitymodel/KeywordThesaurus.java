package com.magic.entitymodel;

import java.sql.Timestamp;


/**
 * KeywordThesaurus entity. @author MyEclipse Persistence Tools
 */

public class KeywordThesaurus  implements java.io.Serializable {


    // Fields    

     private KeywordThesaurusId id;
     private String relationshipEnumId;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public KeywordThesaurus() {
    }

	/** minimal constructor */
    public KeywordThesaurus(KeywordThesaurusId id) {
        this.id = id;
    }
    
    /** full constructor */
    public KeywordThesaurus(KeywordThesaurusId id, String relationshipEnumId, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.id = id;
        this.relationshipEnumId = relationshipEnumId;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public KeywordThesaurusId getId() {
        return this.id;
    }
    
    public void setId(KeywordThesaurusId id) {
        this.id = id;
    }

    public String getRelationshipEnumId() {
        return this.relationshipEnumId;
    }
    
    public void setRelationshipEnumId(String relationshipEnumId) {
        this.relationshipEnumId = relationshipEnumId;
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