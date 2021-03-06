package com.magic.entitymodel;

import java.sql.Timestamp;


/**
 * UserLoginHistoryId entity. @author MyEclipse Persistence Tools
 */

public class UserLoginHistoryId  implements java.io.Serializable {


    // Fields    

     private String userLoginId;
     private Timestamp fromDate;


    // Constructors

    /** default constructor */
    public UserLoginHistoryId() {
    }

    
    /** full constructor */
    public UserLoginHistoryId(String userLoginId, Timestamp fromDate) {
        this.userLoginId = userLoginId;
        this.fromDate = fromDate;
    }

   
    // Property accessors

    public String getUserLoginId() {
        return this.userLoginId;
    }
    
    public void setUserLoginId(String userLoginId) {
        this.userLoginId = userLoginId;
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
		 if ( !(other instanceof UserLoginHistoryId) ) return false;
		 UserLoginHistoryId castOther = ( UserLoginHistoryId ) other; 
         
		 return ( (this.getUserLoginId()==castOther.getUserLoginId()) || ( this.getUserLoginId()!=null && castOther.getUserLoginId()!=null && this.getUserLoginId().equals(castOther.getUserLoginId()) ) )
 && ( (this.getFromDate()==castOther.getFromDate()) || ( this.getFromDate()!=null && castOther.getFromDate()!=null && this.getFromDate().equals(castOther.getFromDate()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getUserLoginId() == null ? 0 : this.getUserLoginId().hashCode() );
         result = 37 * result + ( getFromDate() == null ? 0 : this.getFromDate().hashCode() );
         return result;
   }   





}