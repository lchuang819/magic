package com.magic.entitymodel;



/**
 * EntityGroupEntryId entity. @author MyEclipse Persistence Tools
 */

public class EntityGroupEntryId  implements java.io.Serializable {


    // Fields    

     private String entityGroupId;
     private String entityOrPackage;


    // Constructors

    /** default constructor */
    public EntityGroupEntryId() {
    }

    
    /** full constructor */
    public EntityGroupEntryId(String entityGroupId, String entityOrPackage) {
        this.entityGroupId = entityGroupId;
        this.entityOrPackage = entityOrPackage;
    }

   
    // Property accessors

    public String getEntityGroupId() {
        return this.entityGroupId;
    }
    
    public void setEntityGroupId(String entityGroupId) {
        this.entityGroupId = entityGroupId;
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
		 if ( !(other instanceof EntityGroupEntryId) ) return false;
		 EntityGroupEntryId castOther = ( EntityGroupEntryId ) other; 
         
		 return ( (this.getEntityGroupId()==castOther.getEntityGroupId()) || ( this.getEntityGroupId()!=null && castOther.getEntityGroupId()!=null && this.getEntityGroupId().equals(castOther.getEntityGroupId()) ) )
 && ( (this.getEntityOrPackage()==castOther.getEntityOrPackage()) || ( this.getEntityOrPackage()!=null && castOther.getEntityOrPackage()!=null && this.getEntityOrPackage().equals(castOther.getEntityOrPackage()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getEntityGroupId() == null ? 0 : this.getEntityGroupId().hashCode() );
         result = 37 * result + ( getEntityOrPackage() == null ? 0 : this.getEntityOrPackage().hashCode() );
         return result;
   }   





}