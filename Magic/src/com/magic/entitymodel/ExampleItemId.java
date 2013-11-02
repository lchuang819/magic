package com.magic.entitymodel;



/**
 * ExampleItemId entity. @author MyEclipse Persistence Tools
 */

public class ExampleItemId  implements java.io.Serializable {


    // Fields    

     private String exampleId;
     private String exampleItemSeqId;


    // Constructors

    /** default constructor */
    public ExampleItemId() {
    }

    
    /** full constructor */
    public ExampleItemId(String exampleId, String exampleItemSeqId) {
        this.exampleId = exampleId;
        this.exampleItemSeqId = exampleItemSeqId;
    }

   
    // Property accessors

    public String getExampleId() {
        return this.exampleId;
    }
    
    public void setExampleId(String exampleId) {
        this.exampleId = exampleId;
    }

    public String getExampleItemSeqId() {
        return this.exampleItemSeqId;
    }
    
    public void setExampleItemSeqId(String exampleItemSeqId) {
        this.exampleItemSeqId = exampleItemSeqId;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ExampleItemId) ) return false;
		 ExampleItemId castOther = ( ExampleItemId ) other; 
         
		 return ( (this.getExampleId()==castOther.getExampleId()) || ( this.getExampleId()!=null && castOther.getExampleId()!=null && this.getExampleId().equals(castOther.getExampleId()) ) )
 && ( (this.getExampleItemSeqId()==castOther.getExampleItemSeqId()) || ( this.getExampleItemSeqId()!=null && castOther.getExampleItemSeqId()!=null && this.getExampleItemSeqId().equals(castOther.getExampleItemSeqId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getExampleId() == null ? 0 : this.getExampleId().hashCode() );
         result = 37 * result + ( getExampleItemSeqId() == null ? 0 : this.getExampleItemSeqId().hashCode() );
         return result;
   }   





}