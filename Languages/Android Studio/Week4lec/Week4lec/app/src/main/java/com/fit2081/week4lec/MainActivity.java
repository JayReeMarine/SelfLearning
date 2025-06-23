package com.fit2081.week4lec;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.fit2081.week4lec.provider.Product;
import com.fit2081.week4lec.provider.ProductViewModel;
import com.fit2081.week4lec.provider.ProductsDatabase;

public class MainActivity extends AppCompatActivity {


    ProductViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





    }

    public void onAddProductBtnClick(View view){
        double costRand=(Math.random()*1000);
        Product p1 = new Product("TV", costRand);

        viewModel.insertNewProduct(p1);
    }


    public void onShowActivity2BtnClick(View view){
        startActivity(new Intent(this,MainActivity2.class));
    }


}