package com.fit2081.myfirstproejct_fit2081;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText number1ET;
    EditText number2ET;
    TextView resultsTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1ET=findViewById(R.id.number_1_id);
        number2ET=findViewById(R.id.number_2_id);
        resultsTV=findViewById(R.id.results_id);

    }
    public void onAdditionBtnClick(View view){

        int number1 = Integer.parseInt( number1ET.getText().toString());
        int number2 = Integer.parseInt( number2ET.getText().toString());
        int result = number1+number2;
        resultsTV.setText(Integer.toString(result));
    }
    public void onMultiBtnClick(View view){

        int number1 = Integer.parseInt( number1ET.getText().toString());
        int number2 = Integer.parseInt( number2ET.getText().toString());
        int result = number1*number2;
        resultsTV.setText(Integer.toString(result));
    }
}