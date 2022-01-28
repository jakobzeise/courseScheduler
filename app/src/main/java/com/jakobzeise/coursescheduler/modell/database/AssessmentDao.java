package com.jakobzeise.coursescheduler.modell.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.jakobzeise.coursescheduler.modell.dataclasses.Assessment;

import java.util.List;

@Dao
public interface AssessmentDao {

    @Query("SELECT * FROM assessment")
    List<Assessment> getAll();

    @Insert
    void insertAll(Assessment... assessments);

    @Delete
    void delete(Assessment assessment);

    @Update
    void update(Assessment assessment);

}
