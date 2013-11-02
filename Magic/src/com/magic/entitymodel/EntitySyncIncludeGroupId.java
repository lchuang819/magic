package com.magic.entitymodel;



/**
 * EntitySyncIncludeGroupId entity. @author MyEclipse Persistence Tools
 */

public class EntitySyncIncludeGroupId  implements java.io.Serializable {


    // Fields    

     private String entitySyncId;
     private String entityGroupId;


    // Constructors

    /** default constructor */
    public EntitySyncIncludeGroupId() {
    }

    
    /** full constructor */
    public EntitySyncIncludeGroupId(String entitySyncId, String entityGroupId) {
        this.entitySyncId = entitySyncId;
        this.entityGroupId = entityGroupId;
    }

   
    // Property accessors

    public String getEntitySyncId() {
        return this.entitySyncId;
    }
    
    public void setEntitySyncId(String entitySyncId) {
        this.entitySyncId = entitySyncId;
    }

    public String getEntityGroupId() {
        return this.entityGroupId;
    }
    
    public void setEntityGroupId(String entityGroupId) {
        this.entityGroupId = entityGroupId;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof EntitySyncIncludeGroupId) ) return false;
		 EntitySyncIncludeGroupId castOther = ( EntitySyncIncludeGroupId ) other; 
         
		 return ( (this.getEntitySyncId()==castOther.getEntitySyncId()) || ( this.getEntitySyncId()!=null && castOther.getEntitySyncId()!=null && this.getEntitySyncId().equals(castOther.getEntitySyncId()) ) )
 && ( (this.getEntityGroupId()==castOther.getEntityGroupId()) || ( this.getEntityGroupId()!=null && castOther.getEntityGroupId()!=null && this.getEntityGroupId().equals(castOther.getEntityGroupId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getEntitySyncId() == null ? 0 : this.getEntitySyncId().hashCode() );
         result = 37 * result + ( getEntityGroupId() == null ? 0 : this.getEntityGroupId().hashCode() );
         return result;
   }   





}