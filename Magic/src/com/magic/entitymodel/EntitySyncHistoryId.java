package com.magic.entitymodel;

import java.sql.Timestamp;


/**
 * EntitySyncHistoryId entity. @author MyEclipse Persistence Tools
 */

public class EntitySyncHistoryId  implements java.io.Serializable {


    // Fields    

     private String entitySyncId;
     private Timestamp startDate;


    // Constructors

    /** default constructor */
    public EntitySyncHistoryId() {
    }

    
    /** full constructor */
    public EntitySyncHistoryId(String entitySyncId, Timestamp startDate) {
        this.entitySyncId = entitySyncId;
        this.startDate = startDate;
    }

   
    // Property accessors

    public String getEntitySyncId() {
        return this.entitySyncId;
    }
    
    public void setEntitySyncId(String entitySyncId) {
        this.entitySyncId = entitySyncId;
    }

    public Timestamp getStartDate() {
        return this.startDate;
    }
    
    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof EntitySyncHistoryId) ) return false;
		 EntitySyncHistoryId castOther = ( EntitySyncHistoryId ) other; 
         
		 return ( (this.getEntitySyncId()==castOther.getEntitySyncId()) || ( this.getEntitySyncId()!=null && castOther.getEntitySyncId()!=null && this.getEntitySyncId().equals(castOther.getEntitySyncId()) ) )
 && ( (this.getStartDate()==castOther.getStartDate()) || ( this.getStartDate()!=null && castOther.getStartDate()!=null && this.getStartDate().equals(castOther.getStartDate()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getEntitySyncId() == null ? 0 : this.getEntitySyncId().hashCode() );
         result = 37 * result + ( getStartDate() == null ? 0 : this.getStartDate().hashCode() );
         return result;
   }   





}