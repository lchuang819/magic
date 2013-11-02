package com.magic.entitymodel;



/**
 * UserPreferenceId entity. @author MyEclipse Persistence Tools
 */

public class UserPreferenceId  implements java.io.Serializable {


    // Fields    

     private String userLoginId;
     private String userPrefTypeId;


    // Constructors

    /** default constructor */
    public UserPreferenceId() {
    }

    
    /** full constructor */
    public UserPreferenceId(String userLoginId, String userPrefTypeId) {
        this.userLoginId = userLoginId;
        this.userPrefTypeId = userPrefTypeId;
    }

   
    // Property accessors

    public String getUserLoginId() {
        return this.userLoginId;
    }
    
    public void setUserLoginId(String userLoginId) {
        this.userLoginId = userLoginId;
    }

    public String getUserPrefTypeId() {
        return this.userPrefTypeId;
    }
    
    public void setUserPrefTypeId(String userPrefTypeId) {
        this.userPrefTypeId = userPrefTypeId;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof UserPreferenceId) ) return false;
		 UserPreferenceId castOther = ( UserPreferenceId ) other; 
         
		 return ( (this.getUserLoginId()==castOther.getUserLoginId()) || ( this.getUserLoginId()!=null && castOther.getUserLoginId()!=null && this.getUserLoginId().equals(castOther.getUserLoginId()) ) )
 && ( (this.getUserPrefTypeId()==castOther.getUserPrefTypeId()) || ( this.getUserPrefTypeId()!=null && castOther.getUserPrefTypeId()!=null && this.getUserPrefTypeId().equals(castOther.getUserPrefTypeId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getUserLoginId() == null ? 0 : this.getUserLoginId().hashCode() );
         result = 37 * result + ( getUserPrefTypeId() == null ? 0 : this.getUserPrefTypeId().hashCode() );
         return result;
   }   





}