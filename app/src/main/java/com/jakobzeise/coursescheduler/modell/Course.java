package com.jakobzeise.coursescheduler.modell;

import java.util.Date;
public class Course {

    String title;
    Date startDate;
    Date endDate;
    String status;
    Mentor mentor;
    Assessment[] assessments;
    String[] notes;


    public Course(String title, Date startDate, Date endDate, String status, Mentor mentor, Assessment[] assessments, String[] notes) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.mentor = mentor;
        this.assessments = assessments;
        this.notes = notes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Mentor getMentor() {
        return mentor;
    }

    public void setMentor(Mentor mentor) {
        this.mentor = mentor;
    }

    public Assessment[] getAssessments() {
        return assessments;
    }

    public void setAssessments(Assessment[] assessments) {
        this.assessments = assessments;
    }

    public String[] getNotes() {
        return notes;
    }

    public void setNotes(String[] notes) {
        this.notes = notes;
    }
}