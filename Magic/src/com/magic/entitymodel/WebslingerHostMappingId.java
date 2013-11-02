package com.magic.entitymodel;



/**
 * WebslingerHostMappingId entity. @author MyEclipse Persistence Tools
 */

public class WebslingerHostMappingId  implements java.io.Serializable {


    // Fields    

     private String hostName;
     private String contextPath;


    // Constructors

    /** default constructor */
    public WebslingerHostMappingId() {
    }

    
    /** full constructor */
    public WebslingerHostMappingId(String hostName, String contextPath) {
        this.hostName = hostName;
        this.contextPath = contextPath;
    }

   
    // Property accessors

    public String getHostName() {
        return this.hostName;
    }
    
    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getContextPath() {
        return this.contextPath;
    }
    
    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof WebslingerHostMappingId) ) return false;
		 WebslingerHostMappingId castOther = ( WebslingerHostMappingId ) other; 
         
		 return ( (this.getHostName()==castOther.getHostName()) || ( this.getHostName()!=null && castOther.getHostName()!=null && this.getHostName().equals(castOther.getHostName()) ) )
 && ( (this.getContextPath()==castOther.getContextPath()) || ( this.getContextPath()!=null && castOther.getContextPath()!=null && this.getContextPath().equals(castOther.getContextPath()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getHostName() == null ? 0 : this.getHostName().hashCode() );
         result = 37 * result + ( getContextPath() == null ? 0 : this.getContextPath().hashCode() );
         return result;
   }   





}