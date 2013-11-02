package com.magic.entitymodel;



/**
 * StatusValidChangeId entity. @author MyEclipse Persistence Tools
 */

public class StatusValidChangeId  implements java.io.Serializable {


    // Fields    

     private String statusId;
     private String statusIdTo;


    // Constructors

    /** default constructor */
    public StatusValidChangeId() {
    }

    
    /** full constructor */
    public StatusValidChangeId(String statusId, String statusIdTo) {
        this.statusId = statusId;
        this.statusIdTo = statusIdTo;
    }

   
    // Property accessors

    public String getStatusId() {
        return this.statusId;
    }
    
    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public String getStatusIdTo() {
        return this.statusIdTo;
    }
    
    public void setStatusIdTo(String statusIdTo) {
        this.statusIdTo = statusIdTo;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof StatusValidChangeId) ) return false;
		 StatusValidChangeId castOther = ( StatusValidChangeId ) other; 
         
		 return ( (this.getStatusId()==castOther.getStatusId()) || ( this.getStatusId()!=null && castOther.getStatusId()!=null && this.getStatusId().equals(castOther.getStatusId()) ) )
 && ( (this.getStatusIdTo()==castOther.getStatusIdTo()) || ( this.getStatusIdTo()!=null && castOther.getStatusIdTo()!=null && this.getStatusIdTo().equals(castOther.getStatusIdTo()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getStatusId() == null ? 0 : this.getStatusId().hashCode() );
         result = 37 * result + ( getStatusIdTo() == null ? 0 : this.getStatusIdTo().hashCode() );
         return result;
   }   





}