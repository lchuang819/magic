package com.magic.entitymodel;

import java.sql.Timestamp;


/**
 * BuildCodeBank entity. @author MyEclipse Persistence Tools
 */

public class BuildCodeBank  implements java.io.Serializable {


    // Fields    

     private BuildCodeBankId id;
     private String codeExtValue;
     private String codeOthValue;
     private String codeShortDescription;
     private String codeLongDescription;
     private String langCode;
     private String createBy;
     private String lastUpdateBy;
     private Timestamp lastUpdatedStamp;
     private Timestamp createdStamp;


    // Constructors

    /** default constructor */
    public BuildCodeBank() {
    }

	/** minimal constructor */
    public BuildCodeBank(BuildCodeBankId id) {
        this.id = id;
    }
    
    /** full constructor */
    public BuildCodeBank(BuildCodeBankId id, String codeExtValue, String codeOthValue, String codeShortDescription, String codeLongDescription, String langCode, String createBy, String lastUpdateBy, Timestamp lastUpdatedStamp, Timestamp createdStamp) {
        this.id = id;
        this.codeExtValue = codeExtValue;
        this.codeOthValue = codeOthValue;
        this.codeShortDescription = codeShortDescription;
        this.codeLongDescription = codeLongDescription;
        this.langCode = langCode;
        this.createBy = createBy;
        this.lastUpdateBy = lastUpdateBy;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.createdStamp = createdStamp;
    }

   
    // Property accessors

    public BuildCodeBankId getId() {
        return this.id;
    }
    
    public void setId(BuildCodeBankId id) {
        this.id = id;
    }

    public String getCodeExtValue() {
        return this.codeExtValue;
    }
    
    public void setCodeExtValue(String codeExtValue) {
        this.codeExtValue = codeExtValue;
    }

    public String getCodeOthValue() {
        return this.codeOthValue;
    }
    
    public void setCodeOthValue(String codeOthValue) {
        this.codeOthValue = codeOthValue;
    }

    public String getCodeShortDescription() {
        return this.codeShortDescription;
    }
    
    public void setCodeShortDescription(String codeShortDescription) {
        this.codeShortDescription = codeShortDescription;
    }

    public String getCodeLongDescription() {
        return this.codeLongDescription;
    }
    
    public void setCodeLongDescription(String codeLongDescription) {
        this.codeLongDescription = codeLongDescription;
    }

    public String getLangCode() {
        return this.langCode;
    }
    
    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }

    public String getCreateBy() {
        return this.createBy;
    }
    
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getLastUpdateBy() {
        return this.lastUpdateBy;
    }
    
    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    public Timestamp getLastUpdatedStamp() {
        return this.lastUpdatedStamp;
    }
    
    public void setLastUpdatedStamp(Timestamp lastUpdatedStamp) {
        this.lastUpdatedStamp = lastUpdatedStamp;
    }

    public Timestamp getCreatedStamp() {
        return this.createdStamp;
    }
    
    public void setCreatedStamp(Timestamp createdStamp) {
        this.createdStamp = createdStamp;
    }
   








}