package com.jakobzeise.coursescheduler.modell.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.jakobzeise.coursescheduler.modell.dataclasses.Term;

import java.util.List;

@Dao
public interface TermDao {

    @Query("SELECT * FROM term")
    List<Term> getAll();

    @Insert
    void insertAll(Term... terms);

    @Delete
    void delete(Term term);

    @Update
    void update(Term term);

    @Query("DELETE FROM term WHERE id = :id")
    void deleteById(long id);

    @Query("UPDATE term SET courseList = :courseListString WHERE id = :id")
            void updateCourse(long id, String courseListString);


}
