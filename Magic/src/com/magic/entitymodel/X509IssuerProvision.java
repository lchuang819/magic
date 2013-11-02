package com.magic.entitymodel;

import java.sql.Timestamp;


/**
 * X509IssuerProvision entity. @author MyEclipse Persistence Tools
 */

public class X509IssuerProvision  implements java.io.Serializable {


    // Fields    

     private String certProvisionId;
     private String commonName;
     private String organizationalUnit;
     private String organizationName;
     private String cityLocality;
     private String stateProvince;
     private String country;
     private String serialNumber;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public X509IssuerProvision() {
    }

	/** minimal constructor */
    public X509IssuerProvision(String certProvisionId) {
        this.certProvisionId = certProvisionId;
    }
    
    /** full constructor */
    public X509IssuerProvision(String certProvisionId, String commonName, String organizationalUnit, String organizationName, String cityLocality, String stateProvince, String country, String serialNumber, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.certProvisionId = certProvisionId;
        this.commonName = commonName;
        this.organizationalUnit = organizationalUnit;
        this.organizationName = organizationName;
        this.cityLocality = cityLocality;
        this.stateProvince = stateProvince;
        this.country = country;
        this.serialNumber = serialNumber;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public String getCertProvisionId() {
        return this.certProvisionId;
    }
    
    public void setCertProvisionId(String certProvisionId) {
        this.certProvisionId = certProvisionId;
    }

    public String getCommonName() {
        return this.commonName;
    }
    
    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getOrganizationalUnit() {
        return this.organizationalUnit;
    }
    
    public void setOrganizationalUnit(String organizationalUnit) {
        this.organizationalUnit = organizationalUnit;
    }

    public String getOrganizationName() {
        return this.organizationName;
    }
    
    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getCityLocality() {
        return this.cityLocality;
    }
    
    public void setCityLocality(String cityLocality) {
        this.cityLocality = cityLocality;
    }

    public String getStateProvince() {
        return this.stateProvince;
    }
    
    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public String getCountry() {
        return this.country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }

    public String getSerialNumber() {
        return this.serialNumber;
    }
    
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
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