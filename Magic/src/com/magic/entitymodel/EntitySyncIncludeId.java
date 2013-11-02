package com.magic.entitymodel;



/**
 * EntitySyncIncludeId entity. @author MyEclipse Persistence Tools
 */

public class EntitySyncIncludeId  implements java.io.Serializable {


    // Fields    

     private String entitySyncId;
     private String entityOrPackage;


    // Constructors

    /** default constructor */
    public EntitySyncIncludeId() {
    }

    
    /** full constructor */
    public EntitySyncIncludeId(String entitySyncId, String entityOrPackage) {
        this.entitySyncId = entitySyncId;
        this.entityOrPackage = entityOrPackage;
    }

   
    // Property accessors

    public String getEntitySyncId() {
        return this.entitySyncId;
    }
    
    public void setEntitySyncId(String entitySyncId) {
        this.entitySyncId = entitySyncId;
    }

    public String getEntityOrPackage() {
        return this.entityOrPackage;
    }
    
    public void setEntityOrPackage(String entityOrPackage) {
        this.entityOrPackage = entityOrPackage;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof EntitySyncIncludeId) ) return false;
		 EntitySyncIncludeId castOther = ( EntitySyncIncludeId ) other; 
         
		 return ( (this.getEntitySyncId()==castOther.getEntitySyncId()) || ( this.getEntitySyncId()!=null && castOther.getEntitySyncId()!=null && this.getEntitySyncId().equals(castOther.getEntitySyncId()) ) )
 && ( (this.getEntityOrPackage()==castOther.getEntityOrPackage()) || ( this.getEntityOrPackage()!=null && castOther.getEntityOrPackage()!=null && this.getEntityOrPackage().equals(castOther.getEntityOrPackage()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getEntitySyncId() == null ? 0 : this.getEntitySyncId().hashCode() );
         result = 37 * result + ( getEntityOrPackage() == null ? 0 : this.getEntityOrPackage().hashCode() );
         return result;
   }   





}