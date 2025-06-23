package com.fit2081.week2lecture;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity implements ISendData {

    public static final String TAG="WEEK2_APP_TAG";
    EditText counterET;
    EditText resultET;

    SharedPreferences sP;

    int counter=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counterET=findViewById(R.id.counter_id);
        resultET=findViewById(R.id.result_id);

        Log.d(TAG,"onCreate"); //System.out.println("msg");) //print("msg");

        sP=getSharedPreferences(Keys.SP_FILENAME,MODE_PRIVATE);

        counter=sP.getInt(Keys.COUNTER_KEY,0); //read integer from SP
        counterET.setText(counter+"");

        registerReceiver(new MyDataReceiver(),new IntentFilter("FIT2081.WEEK2.APP"),RECEIVER_EXPORTED);

        MyDataReceiver.bindInstance(this);

        ActivityCompat.requestPermissions(this, new String[]{"android.permission.RECEIVE_SMS", "android.permission.READ_SMS"}, 0);
        registerReceiver(new SMSReceiver(),new IntentFilter("android.provider.Telephony.SMS_RECEIVED"),RECEIVER_EXPORTED);

        SMSReceiver.bindInstance(this);

    }

    public void onSendDataBtnClick(View v){
        Intent intent=new Intent();
        intent.setAction("FIT2081.WEEK2.APP");
        intent.putExtra(Keys.BC_KEY,counterET.getText().toString());
        intent.putExtra(Keys.COUNTER_KEY,counter);
        sendBroadcast(intent);
    }

    public void onCounterBtnClick(View v){
        counter++;
        counterET.setText(counter+"");
        SharedPreferences.Editor editor=sP.edit();
        editor.putInt(Keys.COUNTER_KEY,counter);// save integer into sharedpreferences
        editor.apply();


    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG,"onSaveInstanceState");
        outState.putInt("KEY",counter);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle inState) {
        super.onRestoreInstanceState(inState);
        Log.d(TAG,"onRestoreInstanceState");
        counter=inState.getInt("KEY");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }

    @Override
    public void processData(String data) {
        StringTokenizer sT=new StringTokenizer(data,";");
        String issuerName=sT.nextToken();
        String buyerName=sT.nextToken();

        
        resultET.setText(data);

    }
}