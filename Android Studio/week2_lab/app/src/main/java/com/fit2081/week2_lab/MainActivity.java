package com.fit2081.week2_lab;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    EditText editTextNewNumber;
    TextView textViewResult;
    SharedPreferences sP;

    int resultInt = 0;

    Button btnAdd;

    String LOGCAT_FILTER_TAG = "my_filter";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //SMS time
        /* Request permissions to access SMS */
        ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.SEND_SMS, android.Manifest.permission.RECEIVE_SMS, Manifest.permission.READ_SMS}, 0);

        editTextNewNumber = findViewById(R.id.value);
        textViewResult = findViewById(R.id.result);
        btnAdd = findViewById(R.id.btn_add);

        //set defulat value
        textViewResult.setText(String.valueOf(resultInt));


//        btnAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

        btnAdd.setOnClickListener(v -> {
            //YOUR java functionality goes here --> lamda function

            String newNumberString = editTextNewNumber.getText().toString();

            try{
                int newNumberInt = Integer.parseInt(newNumberString);

                //resultInt = resultInt + newNumberInt;
                //or
                resultInt+= newNumberInt;

                textViewResult.setText(String.valueOf(resultInt));

            } catch (Exception e) {
                //capture expection
                Toast.makeText(this,"please provide valid integer",Toast.LENGTH_SHORT).show();
            }


        });

        //broad cast code
        MyCustomBroadcastReciever myCustomBroadcastReciever = new MyCustomBroadcastReciever();
        registerReceiver(myCustomBroadcastReciever, new IntentFilter(MySMSReceiver.SMS_FILTER),RECEIVER_EXPORTED);
//        sP = getSharedPreferences("com.fit2081.week2_lab", MODE_PRIVATE);
//
//        int savedValue = sP.getInt(VALUE_KEY, 0);
//        int savedResult = sP.getInt(RESULT_KEY, 0);
//
//        value.setText(String.valueOf(savedValue));
//        result.setText(String.valueOf(savedResult));
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        //there is two way of save instance state
        //option 1 : not persistent storeage
        outState.putInt("NV_result",resultInt);

        //option 2 : persistent storage (shared pref)
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("V_newNumber",editTextNewNumber.getText().toString());
        editor.putInt("NV_result",resultInt);
        editor.apply();

        Log.d(LOGCAT_FILTER_TAG,"onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        //there is two way of save restoring state
        //option 1: not persistent storage
        int nvResult= savedInstanceState.getInt("NV_result");

        textViewResult.setText(String.valueOf(nvResult));
        //option 2: persistan stoargae
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        String vNewNumber = sharedPreferences.getString("V_newNumber","");
        resultInt = sharedPreferences.getInt("NV_result",0);

        textViewResult.setText(String.valueOf(resultInt));
        editTextNewNumber.setText(vNewNumber);


        Log.d(LOGCAT_FILTER_TAG,"onRestoreInstanceState");
    }

    class MyCustomBroadcastReciever extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

            /*
             * Retrieve the message from the intent
             * */
            String msg = intent.getStringExtra(MySMSReceiver.SMS_MSG_KEY);
            /*
             * String Tokenizer is used to parse the incoming message
             * The protocol is to have the account holder name and account number separate by a semicolon
             * */

            StringTokenizer sT = new StringTokenizer(msg, ";");
            String newNumber = sT.nextToken();
            String result = sT.nextToken();
            /*
             * Now, its time to update the UI
             * */
            editTextNewNumber.setText(newNumber);
            textViewResult.setText(result);
            resultInt = Integer.parseInt(result);



            Toast.makeText(context,"New Broadcast Received inside Mainactivity",Toast.LENGTH_SHORT).show();
        }
    }

    //    public void addBtn(View view){
//        int enteredValue = Integer.parseInt(value.getText().toString());
//        int currentResult = Integer.parseInt(result.getText().toString());
//
//        currentResult += enteredValue;
//
//        result.setText(String.valueOf(currentResult));
//
//        SharedPreferences.Editor editor = sP.edit();
//        editor.putInt(VALUE_KEY, enteredValue);
//        editor.putInt(RESULT_KEY, currentResult);
//        editor.apply();
//    }
}