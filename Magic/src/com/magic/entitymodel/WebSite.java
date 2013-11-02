package com.magic.entitymodel;

import java.sql.Timestamp;


/**
 * WebSite entity. @author MyEclipse Persistence Tools
 */

public class WebSite  implements java.io.Serializable {


    // Fields    

     private String webSiteId;
     private String siteName;
     private String httpHost;
     private String httpPort;
     private String httpsHost;
     private String httpsPort;
     private String enableHttps;
     private String standardContentPrefix;
     private String secureContentPrefix;
     private String cookieDomain;
     private String visualThemeSetId;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public WebSite() {
    }

	/** minimal constructor */
    public WebSite(String webSiteId) {
        this.webSiteId = webSiteId;
    }
    
    /** full constructor */
    public WebSite(String webSiteId, String siteName, String httpHost, String httpPort, String httpsHost, String httpsPort, String enableHttps, String standardContentPrefix, String secureContentPrefix, String cookieDomain, String visualThemeSetId, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.webSiteId = webSiteId;
        this.siteName = siteName;
        this.httpHost = httpHost;
        this.httpPort = httpPort;
        this.httpsHost = httpsHost;
        this.httpsPort = httpsPort;
        this.enableHttps = enableHttps;
        this.standardContentPrefix = standardContentPrefix;
        this.secureContentPrefix = secureContentPrefix;
        this.cookieDomain = cookieDomain;
        this.visualThemeSetId = visualThemeSetId;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public String getWebSiteId() {
        return this.webSiteId;
    }
    
    public void setWebSiteId(String webSiteId) {
        this.webSiteId = webSiteId;
    }

    public String getSiteName() {
        return this.siteName;
    }
    
    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getHttpHost() {
        return this.httpHost;
    }
    
    public void setHttpHost(String httpHost) {
        this.httpHost = httpHost;
    }

    public String getHttpPort() {
        return this.httpPort;
    }
    
    public void setHttpPort(String httpPort) {
        this.httpPort = httpPort;
    }

    public String getHttpsHost() {
        return this.httpsHost;
    }
    
    public void setHttpsHost(String httpsHost) {
        this.httpsHost = httpsHost;
    }

    public String getHttpsPort() {
        return this.httpsPort;
    }
    
    public void setHttpsPort(String httpsPort) {
        this.httpsPort = httpsPort;
    }

    public String getEnableHttps() {
        return this.enableHttps;
    }
    
    public void setEnableHttps(String enableHttps) {
        this.enableHttps = enableHttps;
    }

    public String getStandardContentPrefix() {
        return this.standardContentPrefix;
    }
    
    public void setStandardContentPrefix(String standardContentPrefix) {
        this.standardContentPrefix = standardContentPrefix;
    }

    public String getSecureContentPrefix() {
        return this.secureContentPrefix;
    }
    
    public void setSecureContentPrefix(String secureContentPrefix) {
        this.secureContentPrefix = secureContentPrefix;
    }

    public String getCookieDomain() {
        return this.cookieDomain;
    }
    
    public void setCookieDomain(String cookieDomain) {
        this.cookieDomain = cookieDomain;
    }

    public String getVisualThemeSetId() {
        return this.visualThemeSetId;
    }
    
    public void setVisualThemeSetId(String visualThemeSetId) {
        this.visualThemeSetId = visualThemeSetId;
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