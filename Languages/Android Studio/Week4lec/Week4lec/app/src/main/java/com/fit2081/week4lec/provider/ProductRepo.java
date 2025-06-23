package com.fit2081.week4lec.provider;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ProductRepo {

    private ProductDao productDao;

    private LiveData<List<Product>> productList;

    public ProductRepo(Application app) {
        ProductsDatabase db = ProductsDatabase.getInstance(app);
        productDao = db.productDao();

        productList = productDao.getAllProducts();
    }

    void addNewProduct(Product product) {
        ProductsDatabase.databaseWriteExecutors.execute(()->{
            productDao.addProduct(product);
        });

    }

    LiveData<List<Product>> getAllMyProducts() {
        return productList;
    }


}
