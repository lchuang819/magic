package com.magic.entitymodel;

import java.sql.Timestamp;


/**
 * ServerHitId entity. @author MyEclipse Persistence Tools
 */

public class ServerHitId  implements java.io.Serializable {


    // Fields    

     private String visitId;
     private String contentId;
     private Timestamp hitStartDateTime;
     private String hitTypeId;


    // Constructors

    /** default constructor */
    public ServerHitId() {
    }

    
    /** full constructor */
    public ServerHitId(String visitId, String contentId, Timestamp hitStartDateTime, String hitTypeId) {
        this.visitId = visitId;
        this.contentId = contentId;
        this.hitStartDateTime = hitStartDateTime;
        this.hitTypeId = hitTypeId;
    }

   
    // Property accessors

    public String getVisitId() {
        return this.visitId;
    }
    
    public void setVisitId(String visitId) {
        this.visitId = visitId;
    }

    public String getContentId() {
        return this.contentId;
    }
    
    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public Timestamp getHitStartDateTime() {
        return this.hitStartDateTime;
    }
    
    public void setHitStartDateTime(Timestamp hitStartDateTime) {
        this.hitStartDateTime = hitStartDateTime;
    }

    public String getHitTypeId() {
        return this.hitTypeId;
    }
    
    public void setHitTypeId(String hitTypeId) {
        this.hitTypeId = hitTypeId;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ServerHitId) ) return false;
		 ServerHitId castOther = ( ServerHitId ) other; 
         
		 return ( (this.getVisitId()==castOther.getVisitId()) || ( this.getVisitId()!=null && castOther.getVisitId()!=null && this.getVisitId().equals(castOther.getVisitId()) ) )
 && ( (this.getContentId()==castOther.getContentId()) || ( this.getContentId()!=null && castOther.getContentId()!=null && this.getContentId().equals(castOther.getContentId()) ) )
 && ( (this.getHitStartDateTime()==castOther.getHitStartDateTime()) || ( this.getHitStartDateTime()!=null && castOther.getHitStartDateTime()!=null && this.getHitStartDateTime().equals(castOther.getHitStartDateTime()) ) )
 && ( (this.getHitTypeId()==castOther.getHitTypeId()) || ( this.getHitTypeId()!=null && castOther.getHitTypeId()!=null && this.getHitTypeId().equals(castOther.getHitTypeId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getVisitId() == null ? 0 : this.getVisitId().hashCode() );
         result = 37 * result + ( getContentId() == null ? 0 : this.getContentId().hashCode() );
         result = 37 * result + ( getHitStartDateTime() == null ? 0 : this.getHitStartDateTime().hashCode() );
         result = 37 * result + ( getHitTypeId() == null ? 0 : this.getHitTypeId().hashCode() );
         return result;
   }   





}