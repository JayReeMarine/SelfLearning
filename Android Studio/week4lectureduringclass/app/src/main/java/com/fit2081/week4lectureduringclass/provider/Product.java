package com.fit2081.week4lectureduringclass.provider;


import static com.fit2081.week4lectureduringclass.provider.Product.TABLE_NAME;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = TABLE_NAME)
public class Product {

    private static final String TABLE_NAME = "products";

    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name ="product_id")
    private int id;

    @ColumnInfo(name = "product_name")
    private String name;

    @ColumnInfo(name = "product_cost")
    private double cost;

    public Product(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public void setId(int id) {
        this.id = id;
    }
}
