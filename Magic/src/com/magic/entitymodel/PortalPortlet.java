package com.magic.entitymodel;

import java.sql.Timestamp;


/**
 * PortalPortlet entity. @author MyEclipse Persistence Tools
 */

public class PortalPortlet  implements java.io.Serializable {


    // Fields    

     private String portalPortletId;
     private String portletName;
     private String screenName;
     private String screenLocation;
     private String editFormName;
     private String editFormLocation;
     private String description;
     private String screenshot;
     private String securityServiceName;
     private String securityMainAction;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public PortalPortlet() {
    }

	/** minimal constructor */
    public PortalPortlet(String portalPortletId) {
        this.portalPortletId = portalPortletId;
    }
    
    /** full constructor */
    public PortalPortlet(String portalPortletId, String portletName, String screenName, String screenLocation, String editFormName, String editFormLocation, String description, String screenshot, String securityServiceName, String securityMainAction, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.portalPortletId = portalPortletId;
        this.portletName = portletName;
        this.screenName = screenName;
        this.screenLocation = screenLocation;
        this.editFormName = editFormName;
        this.editFormLocation = editFormLocation;
        this.description = description;
        this.screenshot = screenshot;
        this.securityServiceName = securityServiceName;
        this.securityMainAction = securityMainAction;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public String getPortalPortletId() {
        return this.portalPortletId;
    }
    
    public void setPortalPortletId(String portalPortletId) {
        this.portalPortletId = portalPortletId;
    }

    public String getPortletName() {
        return this.portletName;
    }
    
    public void setPortletName(String portletName) {
        this.portletName = portletName;
    }

    public String getScreenName() {
        return this.screenName;
    }
    
    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getScreenLocation() {
        return this.screenLocation;
    }
    
    public void setScreenLocation(String screenLocation) {
        this.screenLocation = screenLocation;
    }

    public String getEditFormName() {
        return this.editFormName;
    }
    
    public void setEditFormName(String editFormName) {
        this.editFormName = editFormName;
    }

    public String getEditFormLocation() {
        return this.editFormLocation;
    }
    
    public void setEditFormLocation(String editFormLocation) {
        this.editFormLocation = editFormLocation;
    }

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public String getScreenshot() {
        return this.screenshot;
    }
    
    public void setScreenshot(String screenshot) {
        this.screenshot = screenshot;
    }

    public String getSecurityServiceName() {
        return this.securityServiceName;
    }
    
    public void setSecurityServiceName(String securityServiceName) {
        this.securityServiceName = securityServiceName;
    }

    public String getSecurityMainAction() {
        return this.securityMainAction;
    }
    
    public void setSecurityMainAction(String securityMainAction) {
        this.securityMainAction = securityMainAction;
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