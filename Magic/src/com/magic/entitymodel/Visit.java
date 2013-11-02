package com.magic.entitymodel;

import java.sql.Timestamp;


/**
 * Visit entity. @author MyEclipse Persistence Tools
 */

public class Visit  implements java.io.Serializable {


    // Fields    

     private String visitId;
     private String visitorId;
     private String userLoginId;
     private String userCreated;
     private String sessionId;
     private String serverIpAddress;
     private String serverHostName;
     private String webappName;
     private String initialLocale;
     private String initialRequest;
     private String initialReferrer;
     private String initialUserAgent;
     private String userAgentId;
     private String clientIpAddress;
     private String clientHostName;
     private String clientUser;
     private String clientIpIspName;
     private String clientIpPostalCode;
     private String clientIpStateProvGeoId;
     private String clientIpCountryGeoId;
     private String cookie;
     private Timestamp fromDate;
     private Timestamp thruDate;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public Visit() {
    }

	/** minimal constructor */
    public Visit(String visitId) {
        this.visitId = visitId;
    }
    
    /** full constructor */
    public Visit(String visitId, String visitorId, String userLoginId, String userCreated, String sessionId, String serverIpAddress, String serverHostName, String webappName, String initialLocale, String initialRequest, String initialReferrer, String initialUserAgent, String userAgentId, String clientIpAddress, String clientHostName, String clientUser, String clientIpIspName, String clientIpPostalCode, String clientIpStateProvGeoId, String clientIpCountryGeoId, String cookie, Timestamp fromDate, Timestamp thruDate, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.visitId = visitId;
        this.visitorId = visitorId;
        this.userLoginId = userLoginId;
        this.userCreated = userCreated;
        this.sessionId = sessionId;
        this.serverIpAddress = serverIpAddress;
        this.serverHostName = serverHostName;
        this.webappName = webappName;
        this.initialLocale = initialLocale;
        this.initialRequest = initialRequest;
        this.initialReferrer = initialReferrer;
        this.initialUserAgent = initialUserAgent;
        this.userAgentId = userAgentId;
        this.clientIpAddress = clientIpAddress;
        this.clientHostName = clientHostName;
        this.clientUser = clientUser;
        this.clientIpIspName = clientIpIspName;
        this.clientIpPostalCode = clientIpPostalCode;
        this.clientIpStateProvGeoId = clientIpStateProvGeoId;
        this.clientIpCountryGeoId = clientIpCountryGeoId;
        this.cookie = cookie;
        this.fromDate = fromDate;
        this.thruDate = thruDate;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public String getVisitId() {
        return this.visitId;
    }
    
    public void setVisitId(String visitId) {
        this.visitId = visitId;
    }

    public String getVisitorId() {
        return this.visitorId;
    }
    
    public void setVisitorId(String visitorId) {
        this.visitorId = visitorId;
    }

    public String getUserLoginId() {
        return this.userLoginId;
    }
    
    public void setUserLoginId(String userLoginId) {
        this.userLoginId = userLoginId;
    }

    public String getUserCreated() {
        return this.userCreated;
    }
    
    public void setUserCreated(String userCreated) {
        this.userCreated = userCreated;
    }

    public String getSessionId() {
        return this.sessionId;
    }
    
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getServerIpAddress() {
        return this.serverIpAddress;
    }
    
    public void setServerIpAddress(String serverIpAddress) {
        this.serverIpAddress = serverIpAddress;
    }

    public String getServerHostName() {
        return this.serverHostName;
    }
    
    public void setServerHostName(String serverHostName) {
        this.serverHostName = serverHostName;
    }

    public String getWebappName() {
        return this.webappName;
    }
    
    public void setWebappName(String webappName) {
        this.webappName = webappName;
    }

    public String getInitialLocale() {
        return this.initialLocale;
    }
    
    public void setInitialLocale(String initialLocale) {
        this.initialLocale = initialLocale;
    }

    public String getInitialRequest() {
        return this.initialRequest;
    }
    
    public void setInitialRequest(String initialRequest) {
        this.initialRequest = initialRequest;
    }

    public String getInitialReferrer() {
        return this.initialReferrer;
    }
    
    public void setInitialReferrer(String initialReferrer) {
        this.initialReferrer = initialReferrer;
    }

    public String getInitialUserAgent() {
        return this.initialUserAgent;
    }
    
    public void setInitialUserAgent(String initialUserAgent) {
        this.initialUserAgent = initialUserAgent;
    }

    public String getUserAgentId() {
        return this.userAgentId;
    }
    
    public void setUserAgentId(String userAgentId) {
        this.userAgentId = userAgentId;
    }

    public String getClientIpAddress() {
        return this.clientIpAddress;
    }
    
    public void setClientIpAddress(String clientIpAddress) {
        this.clientIpAddress = clientIpAddress;
    }

    public String getClientHostName() {
        return this.clientHostName;
    }
    
    public void setClientHostName(String clientHostName) {
        this.clientHostName = clientHostName;
    }

    public String getClientUser() {
        return this.clientUser;
    }
    
    public void setClientUser(String clientUser) {
        this.clientUser = clientUser;
    }

    public String getClientIpIspName() {
        return this.clientIpIspName;
    }
    
    public void setClientIpIspName(String clientIpIspName) {
        this.clientIpIspName = clientIpIspName;
    }

    public String getClientIpPostalCode() {
        return this.clientIpPostalCode;
    }
    
    public void setClientIpPostalCode(String clientIpPostalCode) {
        this.clientIpPostalCode = clientIpPostalCode;
    }

    public String getClientIpStateProvGeoId() {
        return this.clientIpStateProvGeoId;
    }
    
    public void setClientIpStateProvGeoId(String clientIpStateProvGeoId) {
        this.clientIpStateProvGeoId = clientIpStateProvGeoId;
    }

    public String getClientIpCountryGeoId() {
        return this.clientIpCountryGeoId;
    }
    
    public void setClientIpCountryGeoId(String clientIpCountryGeoId) {
        this.clientIpCountryGeoId = clientIpCountryGeoId;
    }

    public String getCookie() {
        return this.cookie;
    }
    
    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public Timestamp getFromDate() {
        return this.fromDate;
    }
    
    public void setFromDate(Timestamp fromDate) {
        this.fromDate = fromDate;
    }

    public Timestamp getThruDate() {
        return this.thruDate;
    }
    
    public void setThruDate(Timestamp thruDate) {
        this.thruDate = thruDate;
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