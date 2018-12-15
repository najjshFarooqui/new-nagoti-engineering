package com.example.applligent.newnagoriengg;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomDatabase;
import android.support.annotation.NonNull;
@Database(entities =Item.class, version =1)
public abstract class MyDatabase extends RoomDatabase {
public abstract ItemDao itemDao();
}
