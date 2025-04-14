package com.fit2081.week4_lab30324181.provider;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Converters {
    @TypeConverter
    public static ArrayList<DeviceFeature> fromString(String  value) {
        Type listType = new TypeToken<ArrayList<DeviceFeature>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromArrayList(ArrayList<DeviceFeature> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }
}
