package com.magic.entitymodel;

import java.sql.Timestamp;


/**
 * UomConversionDatedId entity. @author MyEclipse Persistence Tools
 */

public class UomConversionDatedId  implements java.io.Serializable {


    // Fields    

     private String uomId;
     private String uomIdTo;
     private Timestamp fromDate;


    // Constructors

    /** default constructor */
    public UomConversionDatedId() {
    }

    
    /** full constructor */
    public UomConversionDatedId(String uomId, String uomIdTo, Timestamp fromDate) {
        this.uomId = uomId;
        this.uomIdTo = uomIdTo;
        this.fromDate = fromDate;
    }

   
    // Property accessors

    public String getUomId() {
        return this.uomId;
    }
    
    public void setUomId(String uomId) {
        this.uomId = uomId;
    }

    public String getUomIdTo() {
        return this.uomIdTo;
    }
    
    public void setUomIdTo(String uomIdTo) {
        this.uomIdTo = uomIdTo;
    }

    public Timestamp getFromDate() {
        return this.fromDate;
    }
    
    public void setFromDate(Timestamp fromDate) {
        this.fromDate = fromDate;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof UomConversionDatedId) ) return false;
		 UomConversionDatedId castOther = ( UomConversionDatedId ) other; 
         
		 return ( (this.getUomId()==castOther.getUomId()) || ( this.getUomId()!=null && castOther.getUomId()!=null && this.getUomId().equals(castOther.getUomId()) ) )
 && ( (this.getUomIdTo()==castOther.getUomIdTo()) || ( this.getUomIdTo()!=null && castOther.getUomIdTo()!=null && this.getUomIdTo().equals(castOther.getUomIdTo()) ) )
 && ( (this.getFromDate()==castOther.getFromDate()) || ( this.getFromDate()!=null && castOther.getFromDate()!=null && this.getFromDate().equals(castOther.getFromDate()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getUomId() == null ? 0 : this.getUomId().hashCode() );
         result = 37 * result + ( getUomIdTo() == null ? 0 : this.getUomIdTo().hashCode() );
         result = 37 * result + ( getFromDate() == null ? 0 : this.getFromDate().hashCode() );
         return result;
   }   





}