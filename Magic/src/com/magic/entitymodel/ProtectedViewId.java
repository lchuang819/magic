package com.magic.entitymodel;



/**
 * ProtectedViewId entity. @author MyEclipse Persistence Tools
 */

public class ProtectedViewId  implements java.io.Serializable {


    // Fields    

     private String groupId;
     private String viewNameId;


    // Constructors

    /** default constructor */
    public ProtectedViewId() {
    }

    
    /** full constructor */
    public ProtectedViewId(String groupId, String viewNameId) {
        this.groupId = groupId;
        this.viewNameId = viewNameId;
    }

   
    // Property accessors

    public String getGroupId() {
        return this.groupId;
    }
    
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getViewNameId() {
        return this.viewNameId;
    }
    
    public void setViewNameId(String viewNameId) {
        this.viewNameId = viewNameId;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ProtectedViewId) ) return false;
		 ProtectedViewId castOther = ( ProtectedViewId ) other; 
         
		 return ( (this.getGroupId()==castOther.getGroupId()) || ( this.getGroupId()!=null && castOther.getGroupId()!=null && this.getGroupId().equals(castOther.getGroupId()) ) )
 && ( (this.getViewNameId()==castOther.getViewNameId()) || ( this.getViewNameId()!=null && castOther.getViewNameId()!=null && this.getViewNameId().equals(castOther.getViewNameId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getGroupId() == null ? 0 : this.getGroupId().hashCode() );
         result = 37 * result + ( getViewNameId() == null ? 0 : this.getViewNameId().hashCode() );
         return result;
   }   





}