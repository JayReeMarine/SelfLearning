package com.fit2081.a2_30324181;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;



public class invoiceListView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice_list_view);
        getSupportFragmentManager().beginTransaction().add(R.id.fragments_invoice,new fragmentInvoice()).commit();
    }
}