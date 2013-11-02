package com.magic.entitymodel;



/**
 * VisualThemeResourceId entity. @author MyEclipse Persistence Tools
 */

public class VisualThemeResourceId  implements java.io.Serializable {


    // Fields    

     private String visualThemeId;
     private String resourceTypeEnumId;
     private String sequenceId;


    // Constructors

    /** default constructor */
    public VisualThemeResourceId() {
    }

    
    /** full constructor */
    public VisualThemeResourceId(String visualThemeId, String resourceTypeEnumId, String sequenceId) {
        this.visualThemeId = visualThemeId;
        this.resourceTypeEnumId = resourceTypeEnumId;
        this.sequenceId = sequenceId;
    }

   
    // Property accessors

    public String getVisualThemeId() {
        return this.visualThemeId;
    }
    
    public void setVisualThemeId(String visualThemeId) {
        this.visualThemeId = visualThemeId;
    }

    public String getResourceTypeEnumId() {
        return this.resourceTypeEnumId;
    }
    
    public void setResourceTypeEnumId(String resourceTypeEnumId) {
        this.resourceTypeEnumId = resourceTypeEnumId;
    }

    public String getSequenceId() {
        return this.sequenceId;
    }
    
    public void setSequenceId(String sequenceId) {
        this.sequenceId = sequenceId;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof VisualThemeResourceId) ) return false;
		 VisualThemeResourceId castOther = ( VisualThemeResourceId ) other; 
         
		 return ( (this.getVisualThemeId()==castOther.getVisualThemeId()) || ( this.getVisualThemeId()!=null && castOther.getVisualThemeId()!=null && this.getVisualThemeId().equals(castOther.getVisualThemeId()) ) )
 && ( (this.getResourceTypeEnumId()==castOther.getResourceTypeEnumId()) || ( this.getResourceTypeEnumId()!=null && castOther.getResourceTypeEnumId()!=null && this.getResourceTypeEnumId().equals(castOther.getResourceTypeEnumId()) ) )
 && ( (this.getSequenceId()==castOther.getSequenceId()) || ( this.getSequenceId()!=null && castOther.getSequenceId()!=null && this.getSequenceId().equals(castOther.getSequenceId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getVisualThemeId() == null ? 0 : this.getVisualThemeId().hashCode() );
         result = 37 * result + ( getResourceTypeEnumId() == null ? 0 : this.getResourceTypeEnumId().hashCode() );
         result = 37 * result + ( getSequenceId() == null ? 0 : this.getSequenceId().hashCode() );
         return result;
   }   





}