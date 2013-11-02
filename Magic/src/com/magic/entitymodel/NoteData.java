package com.magic.entitymodel;

import java.sql.Timestamp;


/**
 * NoteData entity. @author MyEclipse Persistence Tools
 */

public class NoteData  implements java.io.Serializable {


    // Fields    

     private String noteId;
     private String noteName;
     private String noteInfo;
     private Timestamp noteDateTime;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public NoteData() {
    }

	/** minimal constructor */
    public NoteData(String noteId) {
        this.noteId = noteId;
    }
    
    /** full constructor */
    public NoteData(String noteId, String noteName, String noteInfo, Timestamp noteDateTime, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.noteId = noteId;
        this.noteName = noteName;
        this.noteInfo = noteInfo;
        this.noteDateTime = noteDateTime;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public String getNoteId() {
        return this.noteId;
    }
    
    public void setNoteId(String noteId) {
        this.noteId = noteId;
    }

    public String getNoteName() {
        return this.noteName;
    }
    
    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }

    public String getNoteInfo() {
        return this.noteInfo;
    }
    
    public void setNoteInfo(String noteInfo) {
        this.noteInfo = noteInfo;
    }

    public Timestamp getNoteDateTime() {
        return this.noteDateTime;
    }
    
    public void setNoteDateTime(Timestamp noteDateTime) {
        this.noteDateTime = noteDateTime;
    }

    public Timestamp getLastUpdatedStamp() {
        return this.lastUpdatedStamp;
    }
    
    public void setLastUpdatedStamp(Timestamp lastUpdatedStamp) {
        this.lastUpdatedStamp = lastUpdatedStamp;
    }

    public Timestamp getLastUpdatedTxStamp() {
        return this.lastUpdatedTxStamp;
    }
    
    public void setLastUpdatedTxStamp(Timestamp lastUpdatedTxStamp) {
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
    }

    public Timestamp getCreatedStamp() {
        return this.createdStamp;
    }
    
    public void setCreatedStamp(Timestamp createdStamp) {
        this.createdStamp = createdStamp;
    }

    public Timestamp getCreatedTxStamp() {
        return this.createdTxStamp;
    }
    
    public void setCreatedTxStamp(Timestamp createdTxStamp) {
        this.createdTxStamp = createdTxStamp;
    }
   








}