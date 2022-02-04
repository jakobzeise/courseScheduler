package com.jakobzeise.coursescheduler.modell.dataclasses;

import java.util.List;

public class ListCourse {

    List<Course> courseList;

    public ListCourse(List<Course> courseList) {
        this.courseList = courseList;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
}
