package com.fit2081.a2_30324181;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;



public class loginPage extends AppCompatActivity {

    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        username = findViewById(R.id.loginUsername);
        password = findViewById(R.id.loginPassword);
    }

    public void returnRegisterBtn(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void loginBtn(View view){
        String usernameText = username.getText().toString();
        String passwordText = password.getText().toString();


        SharedPreferences preferences = getSharedPreferences("UserCredentials", MODE_PRIVATE);
        String savedUsername = preferences.getString("Username", "");
        String savedPassword = preferences.getString("Password", "");


        if(usernameText.equals(savedUsername) && passwordText.equals(savedPassword)){
            Toast.makeText(this, "Login successfully", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, invoiceGenerator.class);
            startActivity(intent);

        } else {
            Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show();
        }


    }
}