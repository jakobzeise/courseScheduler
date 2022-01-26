package com.jakobzeise.coursescheduler.modell;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Term.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TermDao courseSchedulerDao();
}