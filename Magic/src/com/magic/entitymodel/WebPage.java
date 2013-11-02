package com.magic.entitymodel;

import java.sql.Timestamp;


/**
 * WebPage entity. @author MyEclipse Persistence Tools
 */

public class WebPage  implements java.io.Serializable {


    // Fields    

     private String webPageId;
     private String pageName;
     private String webSiteId;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public WebPage() {
    }

	/** minimal constructor */
    public WebPage(String webPageId) {
        this.webPageId = webPageId;
    }
    
    /** full constructor */
    public WebPage(String webPageId, String pageName, String webSiteId, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.webPageId = webPageId;
        this.pageName = pageName;
        this.webSiteId = webSiteId;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public String getWebPageId() {
        return this.webPageId;
    }
    
    public void setWebPageId(String webPageId) {
        this.webPageId = webPageId;
    }

    public String getPageName() {
        return this.pageName;
    }
    
    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public String getWebSiteId() {
        return this.webSiteId;
    }
    
    public void setWebSiteId(String webSiteId) {
        this.webSiteId = webSiteId;
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