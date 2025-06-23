package com.fit2081.a2_30324181;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;




public class MainActivity extends AppCompatActivity {

    EditText username, password, passwordAgain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        passwordAgain = findViewById(R.id.passwordAgain);
    }

    public void registerBtn(View view){
        String usernameText = username.getText().toString();
        String passwordText = password.getText().toString();
        String passwordAgainText = passwordAgain.getText().toString();

        // Check username length
        if (usernameText.length() < 4) {
            Toast.makeText(this, "Username must be at least 4 characters", Toast.LENGTH_SHORT).show();
            return;
        }

        // Check password length
        if (passwordText.length() < 8) {
            Toast.makeText(this, "Password must be at least 8 characters", Toast.LENGTH_SHORT).show();
            return;
        }

        boolean hasNumeric = false;
        boolean hasUppercase = false;
        // return true when password contain number and uppercase alphabet
        for (char c : passwordText.toCharArray()) {
            if (Character.isDigit(c)) {
                hasNumeric = true;
            }
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            }
        }

        if (!hasNumeric || !hasUppercase) {
            Toast.makeText(this, "Password must include numeric and uppercase letters", Toast.LENGTH_SHORT).show();
            return;
        }

        // Check if passwords match
        if (!passwordText.equals(passwordAgainText)) {
            Toast.makeText(this, "Passwords are not the same", Toast.LENGTH_SHORT).show();
            return;
        }

        // Save credentials and proceed
        SharedPreferences.Editor editor = getSharedPreferences("UserCredentials", MODE_PRIVATE).edit();
        editor.putString("Username", usernameText);
        editor.putString("Password", passwordText);
        editor.apply();

        Toast.makeText(this, "Successfully registered!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, loginPage.class);
        startActivity(intent);
    }

    public void moveLoginBtn(View view){
        Intent intent = new Intent(this, loginPage.class);
        startActivity(intent);
    }




}