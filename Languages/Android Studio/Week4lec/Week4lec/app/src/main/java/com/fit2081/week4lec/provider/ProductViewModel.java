package com.fit2081.week4lec.provider;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ProductViewModel extends AndroidViewModel {

    private ProductRepo repo;

    private LiveData<List<Product>> productList;

    public ProductViewModel(@NonNull Application application) {
        super(application);
        repo = new ProductRepo(application);
        productList = repo.getAllMyProducts();
    }


    public void insertNewProduct(Product product) {
        repo.addNewProduct(product);
    }

    public LiveData<List<Product>> getMyProducts() {
        return productList;
    }
}
