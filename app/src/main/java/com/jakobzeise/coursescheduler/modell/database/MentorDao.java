package com.jakobzeise.coursescheduler.modell.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.jakobzeise.coursescheduler.modell.dataclasses.Mentor;
import com.jakobzeise.coursescheduler.modell.dataclasses.Term;

import java.util.List;

@Dao
public interface MentorDao {

    @Query("SELECT * FROM mentor")
    List<Mentor> getAll();

    @Insert
    void insertAll(Mentor... mentors);

    @Delete
    void delete(Mentor mentor);

    @Update
    void update(Mentor mentor);

    @Query("SELECT * FROM mentor WHERE id = :id")
    Mentor selectById(long id);
}
