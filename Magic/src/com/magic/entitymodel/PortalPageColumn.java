package com.magic.entitymodel;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * PortalPageColumn entity. @author MyEclipse Persistence Tools
 */

public class PortalPageColumn  implements java.io.Serializable {


    // Fields    

     private PortalPageColumnId id;
     private BigDecimal columnWidthPixels;
     private BigDecimal columnWidthPercentage;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public PortalPageColumn() {
    }

	/** minimal constructor */
    public PortalPageColumn(PortalPageColumnId id) {
        this.id = id;
    }
    
    /** full constructor */
    public PortalPageColumn(PortalPageColumnId id, BigDecimal columnWidthPixels, BigDecimal columnWidthPercentage, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.id = id;
        this.columnWidthPixels = columnWidthPixels;
        this.columnWidthPercentage = columnWidthPercentage;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public PortalPageColumnId getId() {
        return this.id;
    }
    
    public void setId(PortalPageColumnId id) {
        this.id = id;
    }

    public BigDecimal getColumnWidthPixels() {
        return this.columnWidthPixels;
    }
    
    public void setColumnWidthPixels(BigDecimal columnWidthPixels) {
        this.columnWidthPixels = columnWidthPixels;
    }

    public BigDecimal getColumnWidthPercentage() {
        return this.columnWidthPercentage;
    }
    
    public void setColumnWidthPercentage(BigDecimal columnWidthPercentage) {
        this.columnWidthPercentage = columnWidthPercentage;
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