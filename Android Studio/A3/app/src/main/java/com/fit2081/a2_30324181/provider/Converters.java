package com.fit2081.a2_30324181.provider;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
public class Converters {
    @TypeConverter
    public static ArrayList<Invoice> fromString(String  value) {
        Type listType = new TypeToken<ArrayList<Invoice>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromArrayList(ArrayList<Invoice> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }
}
