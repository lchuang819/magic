package com.magic.entitymodel;



/**
 * TarpittedLoginViewId entity. @author MyEclipse Persistence Tools
 */

public class TarpittedLoginViewId  implements java.io.Serializable {


    // Fields    

     private String viewNameId;
     private String userLoginId;


    // Constructors

    /** default constructor */
    public TarpittedLoginViewId() {
    }

    
    /** full constructor */
    public TarpittedLoginViewId(String viewNameId, String userLoginId) {
        this.viewNameId = viewNameId;
        this.userLoginId = userLoginId;
    }

   
    // Property accessors

    public String getViewNameId() {
        return this.viewNameId;
    }
    
    public void setViewNameId(String viewNameId) {
        this.viewNameId = viewNameId;
    }

    public String getUserLoginId() {
        return this.userLoginId;
    }
    
    public void setUserLoginId(String userLoginId) {
        this.userLoginId = userLoginId;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof TarpittedLoginViewId) ) return false;
		 TarpittedLoginViewId castOther = ( TarpittedLoginViewId ) other; 
         
		 return ( (this.getViewNameId()==castOther.getViewNameId()) || ( this.getViewNameId()!=null && castOther.getViewNameId()!=null && this.getViewNameId().equals(castOther.getViewNameId()) ) )
 && ( (this.getUserLoginId()==castOther.getUserLoginId()) || ( this.getUserLoginId()!=null && castOther.getUserLoginId()!=null && this.getUserLoginId().equals(castOther.getUserLoginId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getViewNameId() == null ? 0 : this.getViewNameId().hashCode() );
         result = 37 * result + ( getUserLoginId() == null ? 0 : this.getUserLoginId().hashCode() );
         return result;
   }   





}