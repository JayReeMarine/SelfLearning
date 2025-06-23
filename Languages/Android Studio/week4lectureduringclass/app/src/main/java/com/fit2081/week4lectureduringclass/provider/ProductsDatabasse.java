package com.fit2081.week4lectureduringclass.provider;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Product.class},version = 1)
public abstract class ProductsDatabasse extends RoomDatabase{

    public static final String DATABASE_NAME="products_database";

    public abstract ProductDao productDao();

    private static volatile ProductsDatabasse instance;

    private static final int NUMBER_OF_THREADS = 4;

    static final ExecutorService databaseWriteExecturos= Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static ProductsDatabasse getInstance(final Context context){

        if(instance==null){
            synchronized (ProductsDatabasse.class){
                if(instance==null){
                    instance= Room.databaseBuilder(context,ProductsDatabasse.class,DATABASE_NAME).build();
                }
            }
        }

        return instance;
    }


}
