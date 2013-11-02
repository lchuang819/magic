package com.magic.entitymodel;



/**
 * PortletAttributeId entity. @author MyEclipse Persistence Tools
 */

public class PortletAttributeId  implements java.io.Serializable {


    // Fields    

     private String portalPageId;
     private String portalPortletId;
     private String portletSeqId;
     private String attrName;


    // Constructors

    /** default constructor */
    public PortletAttributeId() {
    }

    
    /** full constructor */
    public PortletAttributeId(String portalPageId, String portalPortletId, String portletSeqId, String attrName) {
        this.portalPageId = portalPageId;
        this.portalPortletId = portalPortletId;
        this.portletSeqId = portletSeqId;
        this.attrName = attrName;
    }

   
    // Property accessors

    public String getPortalPageId() {
        return this.portalPageId;
    }
    
    public void setPortalPageId(String portalPageId) {
        this.portalPageId = portalPageId;
    }

    public String getPortalPortletId() {
        return this.portalPortletId;
    }
    
    public void setPortalPortletId(String portalPortletId) {
        this.portalPortletId = portalPortletId;
    }

    public String getPortletSeqId() {
        return this.portletSeqId;
    }
    
    public void setPortletSeqId(String portletSeqId) {
        this.portletSeqId = portletSeqId;
    }

    public String getAttrName() {
        return this.attrName;
    }
    
    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PortletAttributeId) ) return false;
		 PortletAttributeId castOther = ( PortletAttributeId ) other; 
         
		 return ( (this.getPortalPageId()==castOther.getPortalPageId()) || ( this.getPortalPageId()!=null && castOther.getPortalPageId()!=null && this.getPortalPageId().equals(castOther.getPortalPageId()) ) )
 && ( (this.getPortalPortletId()==castOther.getPortalPortletId()) || ( this.getPortalPortletId()!=null && castOther.getPortalPortletId()!=null && this.getPortalPortletId().equals(castOther.getPortalPortletId()) ) )
 && ( (this.getPortletSeqId()==castOther.getPortletSeqId()) || ( this.getPortletSeqId()!=null && castOther.getPortletSeqId()!=null && this.getPortletSeqId().equals(castOther.getPortletSeqId()) ) )
 && ( (this.getAttrName()==castOther.getAttrName()) || ( this.getAttrName()!=null && castOther.getAttrName()!=null && this.getAttrName().equals(castOther.getAttrName()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getPortalPageId() == null ? 0 : this.getPortalPageId().hashCode() );
         result = 37 * result + ( getPortalPortletId() == null ? 0 : this.getPortalPortletId().hashCode() );
         result = 37 * result + ( getPortletSeqId() == null ? 0 : this.getPortletSeqId().hashCode() );
         result = 37 * result + ( getAttrName() == null ? 0 : this.getAttrName().hashCode() );
         return result;
   }   





}