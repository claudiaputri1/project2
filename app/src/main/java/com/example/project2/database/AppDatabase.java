package com.example.project2.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.project2.main.ModelLaundry;

@Database(entities = {ModelLaundry.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract LaundryDao laundryDao();
}