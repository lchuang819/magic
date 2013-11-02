package com.magic.entitymodel;

import java.sql.Timestamp;


/**
 * ExampleFeatureApplId entity. @author MyEclipse Persistence Tools
 */

public class ExampleFeatureApplId  implements java.io.Serializable {


    // Fields    

     private String exampleId;
     private String exampleFeatureId;
     private Timestamp fromDate;


    // Constructors

    /** default constructor */
    public ExampleFeatureApplId() {
    }

    
    /** full constructor */
    public ExampleFeatureApplId(String exampleId, String exampleFeatureId, Timestamp fromDate) {
        this.exampleId = exampleId;
        this.exampleFeatureId = exampleFeatureId;
        this.fromDate = fromDate;
    }

   
    // Property accessors

    public String getExampleId() {
        return this.exampleId;
    }
    
    public void setExampleId(String exampleId) {
        this.exampleId = exampleId;
    }

    public String getExampleFeatureId() {
        return this.exampleFeatureId;
    }
    
    public void setExampleFeatureId(String exampleFeatureId) {
        this.exampleFeatureId = exampleFeatureId;
    }

    public Timestamp getFromDate() {
        return this.fromDate;
    }
    
    public void setFromDate(Timestamp fromDate) {
        this.fromDate = fromDate;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ExampleFeatureApplId) ) return false;
		 ExampleFeatureApplId castOther = ( ExampleFeatureApplId ) other; 
         
		 return ( (this.getExampleId()==castOther.getExampleId()) || ( this.getExampleId()!=null && castOther.getExampleId()!=null && this.getExampleId().equals(castOther.getExampleId()) ) )
 && ( (this.getExampleFeatureId()==castOther.getExampleFeatureId()) || ( this.getExampleFeatureId()!=null && castOther.getExampleFeatureId()!=null && this.getExampleFeatureId().equals(castOther.getExampleFeatureId()) ) )
 && ( (this.getFromDate()==castOther.getFromDate()) || ( this.getFromDate()!=null && castOther.getFromDate()!=null && this.getFromDate().equals(castOther.getFromDate()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getExampleId() == null ? 0 : this.getExampleId().hashCode() );
         result = 37 * result + ( getExampleFeatureId() == null ? 0 : this.getExampleFeatureId().hashCode() );
         result = 37 * result + ( getFromDate() == null ? 0 : this.getFromDate().hashCode() );
         return result;
   }   





}