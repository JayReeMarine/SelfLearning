package com.fit2081.fleetappprep.provider;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


import java.util.ArrayList;

@Entity(tableName="fleets")
public class Fleet {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    private int id;
    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "cars")
    private ArrayList<Car> cars;

    public int getId() {
        return id;
    }

    public Fleet(String name, ArrayList<Car> cars) {
        this.name = name;
        this.cars = cars;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void setId(int id) {
        this.id = id;
    }
}
