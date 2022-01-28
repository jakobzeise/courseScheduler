package com.jakobzeise.coursescheduler.modell.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.jakobzeise.coursescheduler.modell.dataclasses.Assessment;
import com.jakobzeise.coursescheduler.modell.dataclasses.Course;
import com.jakobzeise.coursescheduler.modell.dataclasses.Mentor;
import com.jakobzeise.coursescheduler.modell.dataclasses.Term;


@Database(entities = {Term.class, Assessment.class, Course.class, Mentor.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract TermDao termDao();

    public abstract AssessmentDao assessDao();

    public abstract CourseDao courseDao();

    public abstract MentorDao mentorDao();

}