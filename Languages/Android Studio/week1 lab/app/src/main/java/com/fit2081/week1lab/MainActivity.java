package com.fit2081.week1lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences;
    EditText id, bookTitle,isbn,author,description,price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id = findViewById(R.id.id);
        bookTitle = findViewById(R.id.name);
        isbn = findViewById(R.id.isbn);
        author = findViewById(R.id.author);
        description = findViewById(R.id.description);
        price = findViewById(R.id.price);
        //set up the preferences!!! this will be saved in private which I cannot check via project file
        //init share pref file
        preferences = getSharedPreferences("name",MODE_PRIVATE);
    }

//    public void showBtnClick(View view){
//        String title = bookTitle.getText().toString();
//        String bookPrice= price.getText().toString();
//        String message = "Book title : " + title + "\nPrice : " + bookPrice + "$";
//        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
//    }

    public void clearFields(View view){
        id.setText("");
        bookTitle.setText("");
        isbn.setText("");
        author.setText("");
        description.setText("");
        price.setText("");
    }

    public void saveData(View view){
        //init editor to edit content of the file
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("ID",id.getText().toString());
        editor.putString("Title",bookTitle.getText().toString());
        editor.putString("ISBN",isbn.getText().toString());
        editor.putString("Author",author.getText().toString());
        editor.putString("Description",description.getText().toString());
        editor.putString("Price",price.getText().toString());

        editor.apply();

        String title = bookTitle.getText().toString();
        String bookPrice= price.getText().toString();
        String message = "Book title : " + title + "\nPrice : " + bookPrice + "$";
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();

        id.setText("");
        bookTitle.setText("");
        isbn.setText("");
        author.setText("");
        description.setText("");
        price.setText("");
    }

    public void getPreferences(View view){
        id.setText(preferences.getString("ID",""));
        bookTitle.setText(preferences.getString("Title",""));
        isbn.setText(preferences.getString("ISBN",""));
        author.setText(preferences.getString("Author",""));
        description.setText(preferences.getString("Description",""));
        price.setText(preferences.getString("Price",""));
    }

    public void onClickLaunch(View view){
//        DashboardActivity dashboardActivity = new DashboardActivity();
        String name = bookTitle.getText().toString();
        Intent newIntent = new Intent(this, DashboardActivity.class);

//        String title = bookTitle.getText().toString();
        newIntent.putExtra(KEYS.BUNDLE_NAME_KEY,name);
        startActivity(newIntent);


    }

}