package com.magic.entitymodel;



/**
 * UomConversionId entity. @author MyEclipse Persistence Tools
 */

public class UomConversionId  implements java.io.Serializable {


    // Fields    

     private String uomId;
     private String uomIdTo;


    // Constructors

    /** default constructor */
    public UomConversionId() {
    }

    
    /** full constructor */
    public UomConversionId(String uomId, String uomIdTo) {
        this.uomId = uomId;
        this.uomIdTo = uomIdTo;
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
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof UomConversionId) ) return false;
		 UomConversionId castOther = ( UomConversionId ) other; 
         
		 return ( (this.getUomId()==castOther.getUomId()) || ( this.getUomId()!=null && castOther.getUomId()!=null && this.getUomId().equals(castOther.getUomId()) ) )
 && ( (this.getUomIdTo()==castOther.getUomIdTo()) || ( this.getUomIdTo()!=null && castOther.getUomIdTo()!=null && this.getUomIdTo().equals(castOther.getUomIdTo()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getUomId() == null ? 0 : this.getUomId().hashCode() );
         result = 37 * result + ( getUomIdTo() == null ? 0 : this.getUomIdTo().hashCode() );
         return result;
   }   





}