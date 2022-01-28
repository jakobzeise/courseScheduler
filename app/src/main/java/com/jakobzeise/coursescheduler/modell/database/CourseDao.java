package com.jakobzeise.coursescheduler.modell.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.jakobzeise.coursescheduler.modell.dataclasses.Course;

import java.util.List;

@Dao
public interface CourseDao {

    @Query("SELECT * FROM course")
    List<Course> getAll();

    @Insert
    void insertAll(Course... courses);

    @Delete
    void delete(Course course);

    @Update
    void update(Course course);

}
