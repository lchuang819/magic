package com.magic.entitymodel;



/**
 * PortalPageColumnId entity. @author MyEclipse Persistence Tools
 */

public class PortalPageColumnId  implements java.io.Serializable {


    // Fields    

     private String portalPageId;
     private String columnSeqId;


    // Constructors

    /** default constructor */
    public PortalPageColumnId() {
    }

    
    /** full constructor */
    public PortalPageColumnId(String portalPageId, String columnSeqId) {
        this.portalPageId = portalPageId;
        this.columnSeqId = columnSeqId;
    }

   
    // Property accessors

    public String getPortalPageId() {
        return this.portalPageId;
    }
    
    public void setPortalPageId(String portalPageId) {
        this.portalPageId = portalPageId;
    }

    public String getColumnSeqId() {
        return this.columnSeqId;
    }
    
    public void setColumnSeqId(String columnSeqId) {
        this.columnSeqId = columnSeqId;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PortalPageColumnId) ) return false;
		 PortalPageColumnId castOther = ( PortalPageColumnId ) other; 
         
		 return ( (this.getPortalPageId()==castOther.getPortalPageId()) || ( this.getPortalPageId()!=null && castOther.getPortalPageId()!=null && this.getPortalPageId().equals(castOther.getPortalPageId()) ) )
 && ( (this.getColumnSeqId()==castOther.getColumnSeqId()) || ( this.getColumnSeqId()!=null && castOther.getColumnSeqId()!=null && this.getColumnSeqId().equals(castOther.getColumnSeqId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getPortalPageId() == null ? 0 : this.getPortalPageId().hashCode() );
         result = 37 * result + ( getColumnSeqId() == null ? 0 : this.getColumnSeqId().hashCode() );
         return result;
   }   





}