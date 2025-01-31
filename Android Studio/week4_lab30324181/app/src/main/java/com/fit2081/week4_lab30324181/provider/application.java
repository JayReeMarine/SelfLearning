package com.fit2081.week4_lab30324181.provider;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity(tableName="applications")
public class application {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "device_name")
    private String device_name;
    @ColumnInfo(name = "year")
    private int year;

    @ColumnInfo(name = "device_feature")
    private ArrayList<DeviceFeature> device_feature; //TypeConvertors * use Gson, convert to JSON string

    public int getId() {
        return id;
    }
    public application(String device_name, int year, ArrayList<DeviceFeature> device_feature){
        this.device_name = device_name;
        this.year = year;
        this.device_feature = device_feature;
    }

    public String getDevice_name(){return device_name;}
    public int getYear(){return year;}

    public ArrayList<DeviceFeature> getDevice_feature() {
        return device_feature;
    }

    public void setId(int id) {
        this.id = id;
    }
}
