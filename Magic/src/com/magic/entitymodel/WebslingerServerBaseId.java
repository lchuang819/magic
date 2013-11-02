package com.magic.entitymodel;



/**
 * WebslingerServerBaseId entity. @author MyEclipse Persistence Tools
 */

public class WebslingerServerBaseId  implements java.io.Serializable {


    // Fields    

     private String webslingerServerId;
     private String baseName;


    // Constructors

    /** default constructor */
    public WebslingerServerBaseId() {
    }

    
    /** full constructor */
    public WebslingerServerBaseId(String webslingerServerId, String baseName) {
        this.webslingerServerId = webslingerServerId;
        this.baseName = baseName;
    }

   
    // Property accessors

    public String getWebslingerServerId() {
        return this.webslingerServerId;
    }
    
    public void setWebslingerServerId(String webslingerServerId) {
        this.webslingerServerId = webslingerServerId;
    }

    public String getBaseName() {
        return this.baseName;
    }
    
    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof WebslingerServerBaseId) ) return false;
		 WebslingerServerBaseId castOther = ( WebslingerServerBaseId ) other; 
         
		 return ( (this.getWebslingerServerId()==castOther.getWebslingerServerId()) || ( this.getWebslingerServerId()!=null && castOther.getWebslingerServerId()!=null && this.getWebslingerServerId().equals(castOther.getWebslingerServerId()) ) )
 && ( (this.getBaseName()==castOther.getBaseName()) || ( this.getBaseName()!=null && castOther.getBaseName()!=null && this.getBaseName().equals(castOther.getBaseName()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getWebslingerServerId() == null ? 0 : this.getWebslingerServerId().hashCode() );
         result = 37 * result + ( getBaseName() == null ? 0 : this.getBaseName().hashCode() );
         return result;
   }   





}