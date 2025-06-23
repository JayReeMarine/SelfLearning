package com.fit2081.domainlogo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainActivity extends AppCompatActivity {

    EditText domainTv;
    ImageView logoView;
    ExecutorService executor;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logoView = findViewById(R.id.image_view);
        domainTv = findViewById(R.id.domain_id);


        executor = Executors.newSingleThreadExecutor();
        handler = new Handler(Looper.getMainLooper());


    }

    public void handleGetLogoBtn(View v) {
        String theDomain = domainTv.getText().toString();
        String request = "https://logo.clearbit.com/" + theDomain;
        //Bitmap myBitmap;


        executor.execute(() -> {
            // this code will run in the background
            try {

                java.net.URL url = new java.net.URL(request);
                HttpURLConnection connection = (HttpURLConnection) url
                        .openConnection();
                connection.setDoInput(true);
                connection.connect();
                InputStream input = connection.getInputStream();

                Bitmap myBitmap = BitmapFactory.decodeStream(input);

                // now lets update the UI
                handler.post(() -> {
                    logoView.setImageBitmap(myBitmap);
                });
            } catch (IOException e) {
                e.printStackTrace();
            }


        });
    }
}



