package com.fit2081.week2_lab_30324181;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    EditText number1;
    EditText number2;
    EditText text1;

    TextView resultText;

    Button btnPrint;
    int result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.SEND_SMS, android.Manifest.permission.RECEIVE_SMS, Manifest.permission.READ_SMS}, 0);


        number1 =findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        text1 = findViewById(R.id.text1);
        btnPrint = findViewById(R.id.resultBtn);
        resultText = findViewById(R.id.resultView);



        btnPrint.setOnClickListener( v -> {

            String number1_St = number1.getText().toString();
            String numbers_St = number2.getText().toString();
            String text1_St = text1.getText().toString().trim();

            if (number1_St.isEmpty() || numbers_St.isEmpty() || text1_St.isEmpty()) {
                Toast.makeText(MainActivity.this, "Please fill in all fields.", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                int num1 = Integer.parseInt(number1_St);
                int num2 = Integer.parseInt(numbers_St);

                switch (text1_St) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    default:
                        Toast.makeText(MainActivity.this, "Invalid operation.", Toast.LENGTH_SHORT).show();
                        return;
                }
                resultText.setText(String.valueOf(result));
            } catch (NumberFormatException e) {
                Toast.makeText(MainActivity.this, "Invalid result.", Toast.LENGTH_SHORT).show();
            }
        });

        MyCustomBroadcastReciever myCustomBroadcastReciever = new MyCustomBroadcastReciever();
        registerReceiver(myCustomBroadcastReciever, new IntentFilter(Wk2SMSReceiver.SMS_FILTER),RECEIVER_EXPORTED);

    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("number1_result",number1.getText().toString());
        editor.putString("number2_result",number2.getText().toString());
        editor.putString("text1_result",text1.getText().toString());
        editor.putString("resultText_result",resultText.getText().toString());
        editor.apply();

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        String number1_result = sharedPreferences.getString("number1_result","0");
        String number2_result = sharedPreferences.getString("number2_result","0");
        String text1_result = sharedPreferences.getString("text1_result","+");
        String resultText_result = sharedPreferences.getString("resultText_result","");


        number1.setText(String.valueOf(number1_result));
        number2.setText(String.valueOf(number2_result));
        text1.setText(String.valueOf(text1_result));
        resultText.setText(String.valueOf(resultText_result));



    }


    class MyCustomBroadcastReciever extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

            String msg = intent.getStringExtra(Wk2SMSReceiver.SMS_MSG_KEY);


            StringTokenizer sT = new StringTokenizer(msg, "|");
            String newNumber1 = sT.nextToken();
            String newNumber2 = sT.nextToken();
            String newText1 = sT.nextToken();

            number1.setText(newNumber1);
            number2.setText(newNumber2);
            text1.setText(newText1);

            Toast.makeText(context,"New Broadcast Received inside Mainactivity",Toast.LENGTH_SHORT).show();
        }
    }
}