package com.magic.entitymodel;

import java.sql.Timestamp;


/**
 * EmailTemplateSetting entity. @author MyEclipse Persistence Tools
 */

public class EmailTemplateSetting  implements java.io.Serializable {


    // Fields    

     private String emailTemplateSettingId;
     private String description;
     private String bodyScreenLocation;
     private String xslfoAttachScreenLocation;
     private String fromAddress;
     private String ccAddress;
     private String bccAddress;
     private String subject;
     private String contentType;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public EmailTemplateSetting() {
    }

	/** minimal constructor */
    public EmailTemplateSetting(String emailTemplateSettingId) {
        this.emailTemplateSettingId = emailTemplateSettingId;
    }
    
    /** full constructor */
    public EmailTemplateSetting(String emailTemplateSettingId, String description, String bodyScreenLocation, String xslfoAttachScreenLocation, String fromAddress, String ccAddress, String bccAddress, String subject, String contentType, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.emailTemplateSettingId = emailTemplateSettingId;
        this.description = description;
        this.bodyScreenLocation = bodyScreenLocation;
        this.xslfoAttachScreenLocation = xslfoAttachScreenLocation;
        this.fromAddress = fromAddress;
        this.ccAddress = ccAddress;
        this.bccAddress = bccAddress;
        this.subject = subject;
        this.contentType = contentType;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public String getEmailTemplateSettingId() {
        return this.emailTemplateSettingId;
    }
    
    public void setEmailTemplateSettingId(String emailTemplateSettingId) {
        this.emailTemplateSettingId = emailTemplateSettingId;
    }

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public String getBodyScreenLocation() {
        return this.bodyScreenLocation;
    }
    
    public void setBodyScreenLocation(String bodyScreenLocation) {
        this.bodyScreenLocation = bodyScreenLocation;
    }

    public String getXslfoAttachScreenLocation() {
        return this.xslfoAttachScreenLocation;
    }
    
    public void setXslfoAttachScreenLocation(String xslfoAttachScreenLocation) {
        this.xslfoAttachScreenLocation = xslfoAttachScreenLocation;
    }

    public String getFromAddress() {
        return this.fromAddress;
    }
    
    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getCcAddress() {
        return this.ccAddress;
    }
    
    public void setCcAddress(String ccAddress) {
        this.ccAddress = ccAddress;
    }

    public String getBccAddress() {
        return this.bccAddress;
    }
    
    public void setBccAddress(String bccAddress) {
        this.bccAddress = bccAddress;
    }

    public String getSubject() {
        return this.subject;
    }
    
    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContentType() {
        return this.contentType;
    }
    
    public void setContentType(String contentType) {
        this.contentType = contentType;
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