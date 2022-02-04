package com.jakobzeise.coursescheduler.modell.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.jakobzeise.coursescheduler.modell.dataclasses.Course;
import com.jakobzeise.coursescheduler.modell.dataclasses.Term;

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

    @Query("SELECT * FROM course WHERE id = :id")
    Course selectById(long id);
}
