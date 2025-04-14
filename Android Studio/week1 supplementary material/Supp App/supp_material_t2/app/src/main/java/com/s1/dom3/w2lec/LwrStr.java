package com.s1.dom3.w2lec;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LwrStr extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent=getIntent();
        String myStr=intent.getStringExtra(MainActivity.STR_KEY);
        myStr=myStr.toLowerCase();

        TextView textView=findViewById(R.id.strInLwr);
        textView.setText(myStr);

    }
}
