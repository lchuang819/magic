package com.magic.entitymodel;



/**
 * TemporalExpressionAssocId entity. @author MyEclipse Persistence Tools
 */

public class TemporalExpressionAssocId  implements java.io.Serializable {


    // Fields    

     private String fromTempExprId;
     private String toTempExprId;


    // Constructors

    /** default constructor */
    public TemporalExpressionAssocId() {
    }

    
    /** full constructor */
    public TemporalExpressionAssocId(String fromTempExprId, String toTempExprId) {
        this.fromTempExprId = fromTempExprId;
        this.toTempExprId = toTempExprId;
    }

   
    // Property accessors

    public String getFromTempExprId() {
        return this.fromTempExprId;
    }
    
    public void setFromTempExprId(String fromTempExprId) {
        this.fromTempExprId = fromTempExprId;
    }

    public String getToTempExprId() {
        return this.toTempExprId;
    }
    
    public void setToTempExprId(String toTempExprId) {
        this.toTempExprId = toTempExprId;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof TemporalExpressionAssocId) ) return false;
		 TemporalExpressionAssocId castOther = ( TemporalExpressionAssocId ) other; 
         
		 return ( (this.getFromTempExprId()==castOther.getFromTempExprId()) || ( this.getFromTempExprId()!=null && castOther.getFromTempExprId()!=null && this.getFromTempExprId().equals(castOther.getFromTempExprId()) ) )
 && ( (this.getToTempExprId()==castOther.getToTempExprId()) || ( this.getToTempExprId()!=null && castOther.getToTempExprId()!=null && this.getToTempExprId().equals(castOther.getToTempExprId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getFromTempExprId() == null ? 0 : this.getFromTempExprId().hashCode() );
         result = 37 * result + ( getToTempExprId() == null ? 0 : this.getToTempExprId().hashCode() );
         return result;
   }   





}