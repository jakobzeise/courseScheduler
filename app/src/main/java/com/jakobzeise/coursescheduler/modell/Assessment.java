package com.jakobzeise.coursescheduler.modell;

import java.util.Date;

public class Assessment {

    String assessmentGrade;
    String performanceAssessment;
    String objectiveAssessment;
    String assessmentTitle;
    Date assessmentEndDate;

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

    public Date getAssessmentEndDate() {
        return assessmentEndDate;
    }

    public void setAssessmentEndDate(Date assessmentEndDate) {
        this.assessmentEndDate = assessmentEndDate;
    }

    public Assessment(
            String assessmentGrade,
            String performanceAssessment,
            String objectiveAssessment,
            String assessmentTitle,
            Date assessmentEndDate
    ) {
        this.assessmentGrade = assessmentGrade;
        this.performanceAssessment = performanceAssessment;
        this.objectiveAssessment = objectiveAssessment;
        this.assessmentTitle = assessmentTitle;
        this.assessmentEndDate = assessmentEndDate;
    }
}
