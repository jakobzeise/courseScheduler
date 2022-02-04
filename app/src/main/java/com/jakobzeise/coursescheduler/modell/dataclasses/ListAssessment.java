package com.jakobzeise.coursescheduler.modell.dataclasses;

import java.util.List;

public class ListAssessment {

    List<Assessment> assessmentList;

    public ListAssessment(List<Assessment> assessmentList) {
        this.assessmentList = assessmentList;
    }

    public List<Assessment> getAssessmentList() {
        return assessmentList;
    }

    public void setAssessmentList(List<Assessment> assessmentList) {
        this.assessmentList = assessmentList;
    }
}
