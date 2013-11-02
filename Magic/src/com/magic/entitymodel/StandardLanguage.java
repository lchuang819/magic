package com.magic.entitymodel;

import java.sql.Timestamp;


/**
 * StandardLanguage entity. @author MyEclipse Persistence Tools
 */

public class StandardLanguage  implements java.io.Serializable {


    // Fields    

     private String standardLanguageId;
     private String langCode3t;
     private String langCode3b;
     private String langCode2;
     private String langName;
     private String langFamily;
     private String langCharset;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public StandardLanguage() {
    }

	/** minimal constructor */
    public StandardLanguage(String standardLanguageId) {
        this.standardLanguageId = standardLanguageId;
    }
    
    /** full constructor */
    public StandardLanguage(String standardLanguageId, String langCode3t, String langCode3b, String langCode2, String langName, String langFamily, String langCharset, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.standardLanguageId = standardLanguageId;
        this.langCode3t = langCode3t;
        this.langCode3b = langCode3b;
        this.langCode2 = langCode2;
        this.langName = langName;
        this.langFamily = langFamily;
        this.langCharset = langCharset;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public String getStandardLanguageId() {
        return this.standardLanguageId;
    }
    
    public void setStandardLanguageId(String standardLanguageId) {
        this.standardLanguageId = standardLanguageId;
    }

    public String getLangCode3t() {
        return this.langCode3t;
    }
    
    public void setLangCode3t(String langCode3t) {
        this.langCode3t = langCode3t;
    }

    public String getLangCode3b() {
        return this.langCode3b;
    }
    
    public void setLangCode3b(String langCode3b) {
        this.langCode3b = langCode3b;
    }

    public String getLangCode2() {
        return this.langCode2;
    }
    
    public void setLangCode2(String langCode2) {
        this.langCode2 = langCode2;
    }

    public String getLangName() {
        return this.langName;
    }
    
    public void setLangName(String langName) {
        this.langName = langName;
    }

    public String getLangFamily() {
        return this.langFamily;
    }
    
    public void setLangFamily(String langFamily) {
        this.langFamily = langFamily;
    }

    public String getLangCharset() {
        return this.langCharset;
    }
    
    public void setLangCharset(String langCharset) {
        this.langCharset = langCharset;
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