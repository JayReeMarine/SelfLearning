package com.fit2081.week4lec.provider;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Converters {

    @TypeConverter
    public static ArrayList<PProvider> fromString(String value){

        Type pproviderType=new TypeToken<ArrayList<PProvider>>(){}.getType();

      return   new Gson().fromJson(value,pproviderType);

    }

    @TypeConverter
    public static String fromArrayList(ArrayList<PProvider> providers) {

        Gson gson = new Gson();
        String json = gson.toJson(providers);

        return json;


    }
}
