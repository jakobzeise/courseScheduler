package com.jakobzeise.coursescheduler.modell.dataclasses;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Course {

    public long mentorId;
    @PrimaryKey(autoGenerate = true)
    long id;

    String title;
    long startDate;
    long endDate;
    String status;
    String assessmentList;
    String notesList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getStartDate() {
        return startDate;
    }

    public void setStartDate(long startDate) {
        this.startDate = startDate;
    }

    public long getEndDate() {
        return endDate;
    }

    public void setEndDate(long endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAssessmentList() {
        return assessmentList;
    }

    public void setAssessmentList(String assessmentList) {
        this.assessmentList = assessmentList;
    }

    public String getNotesList() {
        return notesList;
    }

    public void setNotesList(String notesList) {
        this.notesList = notesList;
    }

    public long getMentorId() {
        return mentorId;
    }

    public void setMentorId(long mentorId) {
        this.mentorId = mentorId;
    }

    public Course(String title, long startDate, long endDate, String status, String assessmentList, String notesList, long mentorId) {

        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.assessmentList = assessmentList;
        this.notesList = notesList;
        this.mentorId = mentorId;
    }
}