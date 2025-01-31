package com.fit2081.a2_30324181.provider;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Invoice.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class InvoicesDatabase extends RoomDatabase{
    public static final String DATABASE_NAME = "invoices_database";

    public abstract InvoiceDao invoiceDao();

    private static volatile InvoicesDatabase instance;

    private static final int NUMBER_OF_THREADS = 4;

    static final ExecutorService databaseWriteExecutors= Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static InvoicesDatabase getInstance(final Context context){
        if(instance==null){
            synchronized (InvoicesDatabase.class){
                if(instance==null){
                    instance= Room.databaseBuilder(context,InvoicesDatabase.class,DATABASE_NAME).build();
                }

            }


        }


        return instance;
    }
}
