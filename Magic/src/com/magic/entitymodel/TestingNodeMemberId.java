package com.magic.entitymodel;

import java.sql.Timestamp;


/**
 * TestingNodeMemberId entity. @author MyEclipse Persistence Tools
 */

public class TestingNodeMemberId  implements java.io.Serializable {


    // Fields    

     private String testingNodeId;
     private String testingId;
     private Timestamp fromDate;


    // Constructors

    /** default constructor */
    public TestingNodeMemberId() {
    }

    
    /** full constructor */
    public TestingNodeMemberId(String testingNodeId, String testingId, Timestamp fromDate) {
        this.testingNodeId = testingNodeId;
        this.testingId = testingId;
        this.fromDate = fromDate;
    }

   
    // Property accessors

    public String getTestingNodeId() {
        return this.testingNodeId;
    }
    
    public void setTestingNodeId(String testingNodeId) {
        this.testingNodeId = testingNodeId;
    }

    public String getTestingId() {
        return this.testingId;
    }
    
    public void setTestingId(String testingId) {
        this.testingId = testingId;
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
		 if ( !(other instanceof TestingNodeMemberId) ) return false;
		 TestingNodeMemberId castOther = ( TestingNodeMemberId ) other; 
         
		 return ( (this.getTestingNodeId()==castOther.getTestingNodeId()) || ( this.getTestingNodeId()!=null && castOther.getTestingNodeId()!=null && this.getTestingNodeId().equals(castOther.getTestingNodeId()) ) )
 && ( (this.getTestingId()==castOther.getTestingId()) || ( this.getTestingId()!=null && castOther.getTestingId()!=null && this.getTestingId().equals(castOther.getTestingId()) ) )
 && ( (this.getFromDate()==castOther.getFromDate()) || ( this.getFromDate()!=null && castOther.getFromDate()!=null && this.getFromDate().equals(castOther.getFromDate()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getTestingNodeId() == null ? 0 : this.getTestingNodeId().hashCode() );
         result = 37 * result + ( getTestingId() == null ? 0 : this.getTestingId().hashCode() );
         result = 37 * result + ( getFromDate() == null ? 0 : this.getFromDate().hashCode() );
         return result;
   }   





}