package com.fit2081.week4lectureduringclass.provider;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ProductDao {

    @Insert
    void addProduct(Product product);

    @Query("select * from products")
    List<Product> getAllProducts();
}
