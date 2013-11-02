package com.magic.entitymodel;



/**
 * BuildCodeBankId entity. @author MyEclipse Persistence Tools
 */

public class BuildCodeBankId  implements java.io.Serializable {


    // Fields    

     private String codeIndex;
     private String systemId;


    // Constructors

    /** default constructor */
    public BuildCodeBankId() {
    }

    
    /** full constructor */
    public BuildCodeBankId(String codeIndex, String systemId) {
        this.codeIndex = codeIndex;
        this.systemId = systemId;
    }

   
    // Property accessors

    public String getCodeIndex() {
        return this.codeIndex;
    }
    
    public void setCodeIndex(String codeIndex) {
        this.codeIndex = codeIndex;
    }

    public String getSystemId() {
        return this.systemId;
    }
    
    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof BuildCodeBankId) ) return false;
		 BuildCodeBankId castOther = ( BuildCodeBankId ) other; 
         
		 return ( (this.getCodeIndex()==castOther.getCodeIndex()) || ( this.getCodeIndex()!=null && castOther.getCodeIndex()!=null && this.getCodeIndex().equals(castOther.getCodeIndex()) ) )
 && ( (this.getSystemId()==castOther.getSystemId()) || ( this.getSystemId()!=null && castOther.getSystemId()!=null && this.getSystemId().equals(castOther.getSystemId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getCodeIndex() == null ? 0 : this.getCodeIndex().hashCode() );
         result = 37 * result + ( getSystemId() == null ? 0 : this.getSystemId().hashCode() );
         return result;
   }   





}