package com.fit2081.week4_lab30324181.provider;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {application.class}, version = 1)
@TypeConverters({Converters.class})
public abstract  class ApplicationDatabase extends RoomDatabase{
    public static final String APPLICATION_DATABASE_NAME = "application_database";

    public abstract ApplicatioinDao applicatioinDao();

    // marking the instance as volatile to ensure atomic access to the variable
    private static volatile ApplicationDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 5;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static ApplicationDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ApplicationDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    ApplicationDatabase.class, APPLICATION_DATABASE_NAME)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
