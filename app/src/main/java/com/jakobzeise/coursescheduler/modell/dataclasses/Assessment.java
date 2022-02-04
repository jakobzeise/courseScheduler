package com.jakobzeise.coursescheduler.modell.dataclasses;

import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity
public class Assessment {

    @PrimaryKey(autoGenerate = true)
    long id;

    String performance;
    String objective;
    String title;
    long endDate;

    public Assessment(long id, String performance, String objective, String title, long endDate) {
        this.id = id;
        this.performance = performance;
        this.objective = objective;
        this.title = title;
        this.endDate = endDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getEndDate() {
        return endDate;
    }

    public void setEndDate(long endDate) {
        this.endDate = endDate;
    }
}
