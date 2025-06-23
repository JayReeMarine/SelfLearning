package com.fit2081.bookstoreapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import androidx.core.view.GestureDetectorCompat;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

import android.Manifest;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity implements BookSMSInterface {

    EditText titleEt;
    EditText bookIdEt;
    EditText isbnEt;
    EditText authorEt;
    EditText descriptionEt;
    EditText priceEt;

    private GestureDetector mDetector;
    private ScaleGestureDetector mScaleDetector;


    public static final String TITLE_KEY = "Title-key";
    public static final String ISBN_KEY = "isbn-key";
    public static final String BOOK_ID = "id-key";
    public static final String AUTHOR_KEY = "author-key";
    public static final String DESCRIPTION_KEY = "description-key";
    public static final String PRICE_KEY = "price-key";

    //     Week 5
    private DrawerLayout drawerlayout;
    private NavigationView navigationView;

    Toolbar toolbar;

    FloatingActionButton fab;

    ArrayList<BookItem> db;
//    RecyclerView.Adapter adapter;
//    RecyclerView recyclerView;
//    RecyclerView.LayoutManager layoutManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_layout);

        titleEt = findViewById(R.id.title_id);
        bookIdEt = findViewById(R.id.book_id);
        isbnEt = findViewById(R.id.isbn_id);
        authorEt = findViewById(R.id.author_id);
        descriptionEt = findViewById(R.id.descritpion_id);
        priceEt = findViewById(R.id.price_id);

        //Week 3
        if (savedInstanceState == null || savedInstanceState.isEmpty())
            loadBookSharedPreferences();


        // Week 4

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS, Manifest.permission.RECEIVE_SMS, Manifest.permission.READ_SMS}, 0);

        //register the SMS handler
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.provider.Telephony.SMS_RECEIVED");
        SMSReceiver receiver = new SMSReceiver(this);
        registerReceiver(receiver, filter);


        // Week 5

        //Week 5
        drawerlayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerlayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerlayout.addDrawerListener(toggle);
        toggle.syncState();
        // navigationView.setNavigationItemSelectedListener(new MyNavigationListener());

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addBookHandler();
            }
        });


//        recyclerView = findViewById(R.id.recyclerview);
//
//        layoutManager = new LinearLayoutManager(this);  //A RecyclerView.LayoutManager implementation which provides similar functionality to ListView.
//        recyclerView.setLayoutManager(layoutManager);   // Also StaggeredGridLayoutManager and GridLayoutManager or a custom Layout manager
//
//
//
        db = new ArrayList<>();
//        recyclerView = findViewById(R.id.recyclerview);
//        adapter = new RecyclerAdapter(db);
//        recyclerView.setAdapter(adapter);
//
//        adapter.notifyDataSetChanged();

        navigationView.setNavigationItemSelectedListener(new BookStoreNavHandler());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.option_clear_all_fields) {
            clearAllFields();
            // Do something
        } else if (id == R.id.option_load_data) {
            loadBookSharedPreferences();
            // Do something
        }


        // tell the OS
        return true;
    }


    public void addBookHandler() {
        String title = titleEt.getText().toString();
        double price = Double.parseDouble(priceEt.getText().toString());
        String bookId = bookIdEt.getText().toString();
        String desc = descriptionEt.getText().toString();
        String author = authorEt.getText().toString();
        String isbn = isbnEt.getText().toString();
        db.add(new BookItem(bookId, title, isbn, author, desc, price));
//        adapter.notifyDataSetChanged();

        //Week 3
        saveBookSharedPreferences();
    }

    public void clearAllItemsDb() {
        db.clear();
//        adapter.notifyDataSetChanged();
    }

    public void removeLastBook() {
        if (db.size() > 0) {
            db.remove(db.size() - 1);
//            adapter.notifyDataSetChanged();
        }
    }

    public void onClearFields(View view) {
        clearAllFields();
    }

    private void clearAllFields() {
        titleEt.setText("");
        bookIdEt.setText("");
        isbnEt.setText("");
        authorEt.setText("");
        descriptionEt.setText("");
        priceEt.setText("");
    }


    // Week 3


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(TITLE_KEY, titleEt.getText().toString());
        outState.putString(ISBN_KEY, isbnEt.getText().toString());

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle inState) {
        titleEt.setText(inState.getString(TITLE_KEY));
        isbnEt.setText(inState.getString(ISBN_KEY));
    }

    private void saveBookSharedPreferences() {
        SharedPreferences sP = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sP.edit();
        editor.putString(BOOK_ID, bookIdEt.getText().toString());
        editor.putString(TITLE_KEY, titleEt.getText().toString());
        editor.putString(ISBN_KEY, isbnEt.getText().toString());
        editor.putString(AUTHOR_KEY, authorEt.getText().toString());
        editor.putString(DESCRIPTION_KEY, descriptionEt.getText().toString());
        editor.putString(PRICE_KEY, priceEt.getText().toString());

        editor.apply();
    }

    private void saveQuizAnswers() {
        SharedPreferences sharedPreferences = getSharedPreferences("week3.quiz", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("Q1", 15);
        editor.putBoolean("IS Correct", true);
        editor.apply();
    }

    public void onLoadBookClick(View view) {
        loadBookSharedPreferences();
    }

    private void loadBookSharedPreferences() {
        SharedPreferences sP = getPreferences(MODE_PRIVATE);
        bookIdEt.setText(sP.getString(BOOK_ID, ""));
        titleEt.setText(sP.getString(TITLE_KEY, ""));
        isbnEt.setText(sP.getString(ISBN_KEY, ""));
        authorEt.setText(sP.getString(AUTHOR_KEY, ""));
        descriptionEt.setText(sP.getString(DESCRIPTION_KEY, ""));
        priceEt.setText(sP.getString(PRICE_KEY, ""));

    }

    // Week 4

    @Override
    public void sendData(String data) {
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
        StringTokenizer sT = new StringTokenizer(data, "|");
        String bookId = sT.nextToken();
        String title = sT.nextToken();
        String isbn = sT.nextToken();
        String author = sT.nextToken();
        String desc = sT.nextToken();
        double price = Double.parseDouble(sT.nextToken());
        updateUI(bookId, title, isbn, author, desc, price);

    }


    private void updateUI(String bookId, String title, String isbn, String author, String desc, double price) {
        bookIdEt.setText(bookId); // +"" to convert int to string
        titleEt.setText(title);
        isbnEt.setText(isbn);
        authorEt.setText(author);
        descriptionEt.setText(desc);
        priceEt.setText(Double.toString(price));
    }

    class BookStoreNavHandler implements NavigationView.OnNavigationItemSelectedListener {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            int id = item.getItemId();
            switch (id) {
                case R.id.nav_add_book:
                    addBookHandler();
                    break;
                case R.id.nav_remove_all_books:
                    clearAllItemsDb();
                    break;
                case R.id.nav_remove_last_book:
                    removeLastBook();
                    break;
            }
            drawerlayout.closeDrawers();
            return true;
        }
    }
}