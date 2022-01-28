package com.jakobzeise.coursescheduler.modell.dataclasses;

import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity
public class Assessment {

    @PrimaryKey(autoGenerate = true)
    long id;

    String assessmentGrade;
    String performanceAssessment;
    String objectiveAssessment;
    String assessmentTitle;
    long assessmentEndDate;


    public String getAssessmentGrade() {
        return assessmentGrade;
    }

    public void setAssessmentGrade(String assessmentGrade) {
        this.assessmentGrade = assessmentGrade;
    }

    public String getPerformanceAssessment() {
        return performanceAssessment;
    }

    public void setPerformanceAssessment(String performanceAssessment) {
        this.performanceAssessment = performanceAssessment;
    }

    public String getObjectiveAssessment() {
        return objectiveAssessment;
    }

    public void setObjectiveAssessment(String objectiveAssessment) {
        this.objectiveAssessment = objectiveAssessment;
    }

    public String getAssessmentTitle() {
        return assessmentTitle;
    }

    public void setAssessmentTitle(String assessmentTitle) {
        this.assessmentTitle = assessmentTitle;
    }

    public long getAssessmentEndDate() {
        return assessmentEndDate;
    }

    public void setAssessmentEndDate(long assessmentEndDate) {
        this.assessmentEndDate = assessmentEndDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Assessment(
            String assessmentGrade,
            String performanceAssessment,
            String objectiveAssessment,
            String assessmentTitle,
            long assessmentEndDate
    ) {
        this.assessmentGrade = assessmentGrade;
        this.performanceAssessment = performanceAssessment;
        this.objectiveAssessment = objectiveAssessment;
        this.assessmentTitle = assessmentTitle;
        this.assessmentEndDate = assessmentEndDate;
    }
}
