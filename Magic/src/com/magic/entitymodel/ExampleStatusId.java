package com.magic.entitymodel;

import java.sql.Timestamp;


/**
 * ExampleStatusId entity. @author MyEclipse Persistence Tools
 */

public class ExampleStatusId  implements java.io.Serializable {


    // Fields    

     private String exampleId;
     private Timestamp statusDate;


    // Constructors

    /** default constructor */
    public ExampleStatusId() {
    }

    
    /** full constructor */
    public ExampleStatusId(String exampleId, Timestamp statusDate) {
        this.exampleId = exampleId;
        this.statusDate = statusDate;
    }

   
    // Property accessors

    public String getExampleId() {
        return this.exampleId;
    }
    
    public void setExampleId(String exampleId) {
        this.exampleId = exampleId;
    }

    public Timestamp getStatusDate() {
        return this.statusDate;
    }
    
    public void setStatusDate(Timestamp statusDate) {
        this.statusDate = statusDate;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ExampleStatusId) ) return false;
		 ExampleStatusId castOther = ( ExampleStatusId ) other; 
         
		 return ( (this.getExampleId()==castOther.getExampleId()) || ( this.getExampleId()!=null && castOther.getExampleId()!=null && this.getExampleId().equals(castOther.getExampleId()) ) )
 && ( (this.getStatusDate()==castOther.getStatusDate()) || ( this.getStatusDate()!=null && castOther.getStatusDate()!=null && this.getStatusDate().equals(castOther.getStatusDate()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getExampleId() == null ? 0 : this.getExampleId().hashCode() );
         result = 37 * result + ( getStatusDate() == null ? 0 : this.getStatusDate().hashCode() );
         return result;
   }   





}