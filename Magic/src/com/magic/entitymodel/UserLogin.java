package com.magic.entitymodel;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * UserLogin entity. @author MyEclipse Persistence Tools
 */

public class UserLogin  implements java.io.Serializable {


    // Fields    

     private String userLoginId;
     private String currentPassword;
     private String passwordHint;
     private String isSystem;
     private String enabled;
     private String hasLoggedOut;
     private String requirePasswordChange;
     private String lastCurrencyUom;
     private String lastLocale;
     private String lastTimeZone;
     private Timestamp disabledDateTime;
     private BigDecimal successiveFailedLogins;
     private String userLdapDn;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public UserLogin() {
    }

	/** minimal constructor */
    public UserLogin(String userLoginId) {
        this.userLoginId = userLoginId;
    }
    
    /** full constructor */
    public UserLogin(String userLoginId, String currentPassword, String passwordHint, String isSystem, String enabled, String hasLoggedOut, String requirePasswordChange, String lastCurrencyUom, String lastLocale, String lastTimeZone, Timestamp disabledDateTime, BigDecimal successiveFailedLogins, String userLdapDn, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.userLoginId = userLoginId;
        this.currentPassword = currentPassword;
        this.passwordHint = passwordHint;
        this.isSystem = isSystem;
        this.enabled = enabled;
        this.hasLoggedOut = hasLoggedOut;
        this.requirePasswordChange = requirePasswordChange;
        this.lastCurrencyUom = lastCurrencyUom;
        this.lastLocale = lastLocale;
        this.lastTimeZone = lastTimeZone;
        this.disabledDateTime = disabledDateTime;
        this.successiveFailedLogins = successiveFailedLogins;
        this.userLdapDn = userLdapDn;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public String getUserLoginId() {
        return this.userLoginId;
    }
    
    public void setUserLoginId(String userLoginId) {
        this.userLoginId = userLoginId;
    }

    public String getCurrentPassword() {
        return this.currentPassword;
    }
    
    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getPasswordHint() {
        return this.passwordHint;
    }
    
    public void setPasswordHint(String passwordHint) {
        this.passwordHint = passwordHint;
    }

    public String getIsSystem() {
        return this.isSystem;
    }
    
    public void setIsSystem(String isSystem) {
        this.isSystem = isSystem;
    }

    public String getEnabled() {
        return this.enabled;
    }
    
    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getHasLoggedOut() {
        return this.hasLoggedOut;
    }
    
    public void setHasLoggedOut(String hasLoggedOut) {
        this.hasLoggedOut = hasLoggedOut;
    }

    public String getRequirePasswordChange() {
        return this.requirePasswordChange;
    }
    
    public void setRequirePasswordChange(String requirePasswordChange) {
        this.requirePasswordChange = requirePasswordChange;
    }

    public String getLastCurrencyUom() {
        return this.lastCurrencyUom;
    }
    
    public void setLastCurrencyUom(String lastCurrencyUom) {
        this.lastCurrencyUom = lastCurrencyUom;
    }

    public String getLastLocale() {
        return this.lastLocale;
    }
    
    public void setLastLocale(String lastLocale) {
        this.lastLocale = lastLocale;
    }

    public String getLastTimeZone() {
        return this.lastTimeZone;
    }
    
    public void setLastTimeZone(String lastTimeZone) {
        this.lastTimeZone = lastTimeZone;
    }

    public Timestamp getDisabledDateTime() {
        return this.disabledDateTime;
    }
    
    public void setDisabledDateTime(Timestamp disabledDateTime) {
        this.disabledDateTime = disabledDateTime;
    }

    public BigDecimal getSuccessiveFailedLogins() {
        return this.successiveFailedLogins;
    }
    
    public void setSuccessiveFailedLogins(BigDecimal successiveFailedLogins) {
        this.successiveFailedLogins = successiveFailedLogins;
    }

    public String getUserLdapDn() {
        return this.userLdapDn;
    }
    
    public void setUserLdapDn(String userLdapDn) {
        this.userLdapDn = userLdapDn;
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