package com.jakobzeise.coursescheduler.modell.dataclasses;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.jakobzeise.coursescheduler.modell.converters.DateConverter;

import java.util.Date;

@Entity
public class Term {

    @PrimaryKey(autoGenerate = true)
    long id;

    String name;

    long startDate;

    long endDate;

    String courseList;

    public Term(String name, long startDate, long endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public long getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = DateConverter.fromDate(startDate);
    }

    public long getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = DateConverter.fromDate(endDate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCourseList() {
        return courseList;
    }

    public void setCourseList(String courseList) {
        this.courseList = courseList;
    }

    @NonNull
    @Override
    public String toString() {
        return
                name + ";" +
                startDate + ";" +
                endDate + ";" ;
    }
}
