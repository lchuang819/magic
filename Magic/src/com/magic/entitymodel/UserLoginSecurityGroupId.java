package com.magic.entitymodel;

import java.sql.Timestamp;


/**
 * UserLoginSecurityGroupId entity. @author MyEclipse Persistence Tools
 */

public class UserLoginSecurityGroupId  implements java.io.Serializable {


    // Fields    

     private String userLoginId;
     private String groupId;
     private Timestamp fromDate;


    // Constructors

    /** default constructor */
    public UserLoginSecurityGroupId() {
    }

    
    /** full constructor */
    public UserLoginSecurityGroupId(String userLoginId, String groupId, Timestamp fromDate) {
        this.userLoginId = userLoginId;
        this.groupId = groupId;
        this.fromDate = fromDate;
    }

   
    // Property accessors

    public String getUserLoginId() {
        return this.userLoginId;
    }
    
    public void setUserLoginId(String userLoginId) {
        this.userLoginId = userLoginId;
    }

    public String getGroupId() {
        return this.groupId;
    }
    
    public void setGroupId(String groupId) {
        this.groupId = groupId;
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
		 if ( !(other instanceof UserLoginSecurityGroupId) ) return false;
		 UserLoginSecurityGroupId castOther = ( UserLoginSecurityGroupId ) other; 
         
		 return ( (this.getUserLoginId()==castOther.getUserLoginId()) || ( this.getUserLoginId()!=null && castOther.getUserLoginId()!=null && this.getUserLoginId().equals(castOther.getUserLoginId()) ) )
 && ( (this.getGroupId()==castOther.getGroupId()) || ( this.getGroupId()!=null && castOther.getGroupId()!=null && this.getGroupId().equals(castOther.getGroupId()) ) )
 && ( (this.getFromDate()==castOther.getFromDate()) || ( this.getFromDate()!=null && castOther.getFromDate()!=null && this.getFromDate().equals(castOther.getFromDate()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getUserLoginId() == null ? 0 : this.getUserLoginId().hashCode() );
         result = 37 * result + ( getGroupId() == null ? 0 : this.getGroupId().hashCode() );
         result = 37 * result + ( getFromDate() == null ? 0 : this.getFromDate().hashCode() );
         return result;
   }   





}