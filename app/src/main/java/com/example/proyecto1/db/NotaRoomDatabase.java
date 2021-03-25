package com.example.proyecto1;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

@Database(entities = {NotaEntity.class}, version = 1)
public class NotaRoomDatabase extends RoomDatabase {

    public NotaDao notaDao;
    private  static volatile NotaRoomDatabase INSTANCE;

    public static NotaRoomDatabase getDatabase(final Context context){
        if (INSTANCE == null){
            synchronized (NotaRoomDatabase.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            NotaRoomDatabase.class,"notas_database").build();
                }
            }
        }

        return INSTANCE;
    }

    @NonNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @NonNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    @Override
    public void clearAllTables() {

    }
}
