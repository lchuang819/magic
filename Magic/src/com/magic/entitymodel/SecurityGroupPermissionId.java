package com.magic.entitymodel;



/**
 * SecurityGroupPermissionId entity. @author MyEclipse Persistence Tools
 */

public class SecurityGroupPermissionId  implements java.io.Serializable {


    // Fields    

     private String groupId;
     private String permissionId;


    // Constructors

    /** default constructor */
    public SecurityGroupPermissionId() {
    }

    
    /** full constructor */
    public SecurityGroupPermissionId(String groupId, String permissionId) {
        this.groupId = groupId;
        this.permissionId = permissionId;
    }

   
    // Property accessors

    public String getGroupId() {
        return this.groupId;
    }
    
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getPermissionId() {
        return this.permissionId;
    }
    
    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof SecurityGroupPermissionId) ) return false;
		 SecurityGroupPermissionId castOther = ( SecurityGroupPermissionId ) other; 
         
		 return ( (this.getGroupId()==castOther.getGroupId()) || ( this.getGroupId()!=null && castOther.getGroupId()!=null && this.getGroupId().equals(castOther.getGroupId()) ) )
 && ( (this.getPermissionId()==castOther.getPermissionId()) || ( this.getPermissionId()!=null && castOther.getPermissionId()!=null && this.getPermissionId().equals(castOther.getPermissionId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getGroupId() == null ? 0 : this.getGroupId().hashCode() );
         result = 37 * result + ( getPermissionId() == null ? 0 : this.getPermissionId().hashCode() );
         return result;
   }   





}