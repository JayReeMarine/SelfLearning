package com.fit2081.week4lec.provider;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Database(entities = {Product.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class ProductsDatabase extends RoomDatabase {

    public static final String DATABASE_NAME = "products_database";

    public abstract ProductDao productDao();

    private static volatile ProductsDatabase instance;

    private static final int NUMBER_OF_THREADS = 4;

    static final ExecutorService databaseWriteExecutors= Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static ProductsDatabase getInstance(final Context context){
        if(instance==null){
            synchronized (ProductsDatabase.class){
                if(instance==null){
                    instance= Room.databaseBuilder(context,ProductsDatabase.class,DATABASE_NAME).build();
                }

            }


        }


        return instance;
    }

}
