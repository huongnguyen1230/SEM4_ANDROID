package com.example.practical_android.database;

import android.content.Context;

import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.practical_android.entity.Product;

@Database(entities = {Product.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase appDatabase;

    public abstract ProductDao productDao();

    public static AppDatabase getAppDatabase(Context context){
        if (appDatabase == null){
            appDatabase = Room.databaseBuilder(context, AppDatabase.class, "News").allowMainThreadQueries().build();
        }
        return appDatabase;
    }
}
