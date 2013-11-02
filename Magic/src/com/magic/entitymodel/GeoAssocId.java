package com.magic.entitymodel;



/**
 * GeoAssocId entity. @author MyEclipse Persistence Tools
 */

public class GeoAssocId  implements java.io.Serializable {


    // Fields    

     private String geoId;
     private String geoIdTo;


    // Constructors

    /** default constructor */
    public GeoAssocId() {
    }

    
    /** full constructor */
    public GeoAssocId(String geoId, String geoIdTo) {
        this.geoId = geoId;
        this.geoIdTo = geoIdTo;
    }

   
    // Property accessors

    public String getGeoId() {
        return this.geoId;
    }
    
    public void setGeoId(String geoId) {
        this.geoId = geoId;
    }

    public String getGeoIdTo() {
        return this.geoIdTo;
    }
    
    public void setGeoIdTo(String geoIdTo) {
        this.geoIdTo = geoIdTo;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof GeoAssocId) ) return false;
		 GeoAssocId castOther = ( GeoAssocId ) other; 
         
		 return ( (this.getGeoId()==castOther.getGeoId()) || ( this.getGeoId()!=null && castOther.getGeoId()!=null && this.getGeoId().equals(castOther.getGeoId()) ) )
 && ( (this.getGeoIdTo()==castOther.getGeoIdTo()) || ( this.getGeoIdTo()!=null && castOther.getGeoIdTo()!=null && this.getGeoIdTo().equals(castOther.getGeoIdTo()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getGeoId() == null ? 0 : this.getGeoId().hashCode() );
         result = 37 * result + ( getGeoIdTo() == null ? 0 : this.getGeoIdTo().hashCode() );
         return result;
   }   





}