package com.magic.entitymodel;



/**
 * KeywordThesaurusId entity. @author MyEclipse Persistence Tools
 */

public class KeywordThesaurusId  implements java.io.Serializable {


    // Fields    

     private String enteredKeyword;
     private String alternateKeyword;


    // Constructors

    /** default constructor */
    public KeywordThesaurusId() {
    }

    
    /** full constructor */
    public KeywordThesaurusId(String enteredKeyword, String alternateKeyword) {
        this.enteredKeyword = enteredKeyword;
        this.alternateKeyword = alternateKeyword;
    }

   
    // Property accessors

    public String getEnteredKeyword() {
        return this.enteredKeyword;
    }
    
    public void setEnteredKeyword(String enteredKeyword) {
        this.enteredKeyword = enteredKeyword;
    }

    public String getAlternateKeyword() {
        return this.alternateKeyword;
    }
    
    public void setAlternateKeyword(String alternateKeyword) {
        this.alternateKeyword = alternateKeyword;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof KeywordThesaurusId) ) return false;
		 KeywordThesaurusId castOther = ( KeywordThesaurusId ) other; 
         
		 return ( (this.getEnteredKeyword()==castOther.getEnteredKeyword()) || ( this.getEnteredKeyword()!=null && castOther.getEnteredKeyword()!=null && this.getEnteredKeyword().equals(castOther.getEnteredKeyword()) ) )
 && ( (this.getAlternateKeyword()==castOther.getAlternateKeyword()) || ( this.getAlternateKeyword()!=null && castOther.getAlternateKeyword()!=null && this.getAlternateKeyword().equals(castOther.getAlternateKeyword()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getEnteredKeyword() == null ? 0 : this.getEnteredKeyword().hashCode() );
         result = 37 * result + ( getAlternateKeyword() == null ? 0 : this.getAlternateKeyword().hashCode() );
         return result;
   }   





}