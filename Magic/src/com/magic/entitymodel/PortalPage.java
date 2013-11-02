package com.magic.entitymodel;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * PortalPage entity. @author MyEclipse Persistence Tools
 */

public class PortalPage  implements java.io.Serializable {


    // Fields    

     private String portalPageId;
     private String portalPageName;
     private String description;
     private String ownerUserLoginId;
     private String originalPortalPageId;
     private String parentPortalPageId;
     private BigDecimal sequenceNum;
     private String securityGroupId;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public PortalPage() {
    }

	/** minimal constructor */
    public PortalPage(String portalPageId) {
        this.portalPageId = portalPageId;
    }
    
    /** full constructor */
    public PortalPage(String portalPageId, String portalPageName, String description, String ownerUserLoginId, String originalPortalPageId, String parentPortalPageId, BigDecimal sequenceNum, String securityGroupId, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.portalPageId = portalPageId;
        this.portalPageName = portalPageName;
        this.description = description;
        this.ownerUserLoginId = ownerUserLoginId;
        this.originalPortalPageId = originalPortalPageId;
        this.parentPortalPageId = parentPortalPageId;
        this.sequenceNum = sequenceNum;
        this.securityGroupId = securityGroupId;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public String getPortalPageId() {
        return this.portalPageId;
    }
    
    public void setPortalPageId(String portalPageId) {
        this.portalPageId = portalPageId;
    }

    public String getPortalPageName() {
        return this.portalPageName;
    }
    
    public void setPortalPageName(String portalPageName) {
        this.portalPageName = portalPageName;
    }

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwnerUserLoginId() {
        return this.ownerUserLoginId;
    }
    
    public void setOwnerUserLoginId(String ownerUserLoginId) {
        this.ownerUserLoginId = ownerUserLoginId;
    }

    public String getOriginalPortalPageId() {
        return this.originalPortalPageId;
    }
    
    public void setOriginalPortalPageId(String originalPortalPageId) {
        this.originalPortalPageId = originalPortalPageId;
    }

    public String getParentPortalPageId() {
        return this.parentPortalPageId;
    }
    
    public void setParentPortalPageId(String parentPortalPageId) {
        this.parentPortalPageId = parentPortalPageId;
    }

    public BigDecimal getSequenceNum() {
        return this.sequenceNum;
    }
    
    public void setSequenceNum(BigDecimal sequenceNum) {
        this.sequenceNum = sequenceNum;
    }

    public String getSecurityGroupId() {
        return this.securityGroupId;
    }
    
    public void setSecurityGroupId(String securityGroupId) {
        this.securityGroupId = securityGroupId;
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