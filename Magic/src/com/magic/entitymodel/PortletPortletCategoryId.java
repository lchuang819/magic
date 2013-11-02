package com.magic.entitymodel;



/**
 * PortletPortletCategoryId entity. @author MyEclipse Persistence Tools
 */

public class PortletPortletCategoryId  implements java.io.Serializable {


    // Fields    

     private String portalPortletId;
     private String portletCategoryId;


    // Constructors

    /** default constructor */
    public PortletPortletCategoryId() {
    }

    
    /** full constructor */
    public PortletPortletCategoryId(String portalPortletId, String portletCategoryId) {
        this.portalPortletId = portalPortletId;
        this.portletCategoryId = portletCategoryId;
    }

   
    // Property accessors

    public String getPortalPortletId() {
        return this.portalPortletId;
    }
    
    public void setPortalPortletId(String portalPortletId) {
        this.portalPortletId = portalPortletId;
    }

    public String getPortletCategoryId() {
        return this.portletCategoryId;
    }
    
    public void setPortletCategoryId(String portletCategoryId) {
        this.portletCategoryId = portletCategoryId;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PortletPortletCategoryId) ) return false;
		 PortletPortletCategoryId castOther = ( PortletPortletCategoryId ) other; 
         
		 return ( (this.getPortalPortletId()==castOther.getPortalPortletId()) || ( this.getPortalPortletId()!=null && castOther.getPortalPortletId()!=null && this.getPortalPortletId().equals(castOther.getPortalPortletId()) ) )
 && ( (this.getPortletCategoryId()==castOther.getPortletCategoryId()) || ( this.getPortletCategoryId()!=null && castOther.getPortletCategoryId()!=null && this.getPortletCategoryId().equals(castOther.getPortletCategoryId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getPortalPortletId() == null ? 0 : this.getPortalPortletId().hashCode() );
         result = 37 * result + ( getPortletCategoryId() == null ? 0 : this.getPortletCategoryId().hashCode() );
         return result;
   }   





}