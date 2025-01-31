package com.fit2081.week1lab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        TextView textViewName = findViewById(R.id.textView_Name);

        String fromParentActivity = getIntent().getExtras().getString(KEYS.BUNDLE_NAME_KEY);
        textViewName.setText(fromParentActivity);

    }
}