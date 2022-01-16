package com.jakobzeise.coursescheduler.modell;

import androidx.annotation.NonNull;

import java.util.Date;

public class Term {

    String name;
    Date startDate;
    Date endDate;


    public Term(String name, Date startDate, Date endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
