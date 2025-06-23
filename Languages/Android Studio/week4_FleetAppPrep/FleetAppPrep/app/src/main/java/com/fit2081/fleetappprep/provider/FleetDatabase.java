package com.fit2081.fleetappprep.provider;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Fleet.class}, version = 1)
@TypeConverters({Converters.class})
public  abstract class FleetDatabase extends RoomDatabase{

    public static final String FLEET_DATABASE_NAME = "fleet_database";

    public abstract FleetDao fleetDao();

    // marking the instance as volatile to ensure atomic access to the variable
    private static volatile FleetDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static FleetDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (FleetDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    FleetDatabase.class, FLEET_DATABASE_NAME)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
