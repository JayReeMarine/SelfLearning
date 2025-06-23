package com.fit2081.week4lectureduringclass.provider;

import android.app.Application;

import java.util.List;

public class ProductRepo {

    private ProductDao productDao;

    private List<Product> productList;

    public ProductRepo(Application app) {
        ProductsDatabasse  db = ProductsDatabasse.getInstance(app);
        productDao= db.productDao();

        productList=productDao.getAllProducts();
    }

    void addNewProduct(Product product){
        productDao.addProduct(product);
    }

    List<Product>getAllMyProducts(){
        return productList;
    }


}
