package com.fit2081.week4lec.provider;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ProductDao {

    @Insert
    void addProduct(Product product);

    @Query("select * from products")
    LiveData<List<Product>> getAllProducts();

}
