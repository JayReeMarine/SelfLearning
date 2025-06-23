package com.fit2081.fit2081week3lecture;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    DrawerLayout drawerLayout;
    NavigationView navigationiView;

    Toolbar toolbar;

    FloatingActionButton fab;

    ArrayList<String> dataSource;
    ListView listView;

    ArrayAdapter<String> adapter;

    private Toolbar supportActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.nav_open, R.string.nav_close);
        toggle.syncState();

        navigationiView=findViewById(R.id.nav_view);
        navigationiView.setNavigationItemSelectedListener(new Week3NavListner());

        fab=findViewById(R.id.fab);
        fab.setOnClickListener(new Week3FabListener());
        dataSource=new ArrayList<>();
        listView=findViewById(R.id.listView_id);

        adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,dataSource);
        listView.setAdapter(adapter);



    }

    class Week3FabListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            int rand=(int)(Math.random()*1000);
            dataSource.add("Value ("+rand+")");
            adapter.notifyDataSetChanged();


            Snackbar.make(v,"Thank you for Clicking Fab",Snackbar.LENGTH_SHORT).setAction("UNDO", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), "Ok, we undo", Toast.LENGTH_SHORT).show();
                }
            }).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu,menu);

        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        int id= item.getItemId();

        if (id==R.id.options_menu_item_1){

            Toast.makeText(getApplicationContext(), "Item 1", Toast.LENGTH_SHORT).show();
        }else if(id==R.id.options_menu_item_2){
            dataSource.clear();
            adapter.notifyDataSetChanged();
            Toast.makeText(getApplicationContext(), "Item 2", Toast.LENGTH_SHORT).show();
        }else if (id==R.id.options_menu_item_3){
            Toast.makeText(getApplicationContext(), "Item 3", Toast.LENGTH_SHORT).show();
        }

        return true;
    }

    class Week3NavListner implements NavigationView.OnNavigationItemSelectedListener {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            int id= item.getItemId();

            if (id==R.id.nav_menu_item_1){

                Toast.makeText(getApplicationContext(), "Item 1", Toast.LENGTH_SHORT).show();
            }else if(id==R.id.nav_menu_item_2){
                Toast.makeText(getApplicationContext(), "Item 2", Toast.LENGTH_SHORT).show();
            }else if (id==R.id.nav_menu_item_3){
                Toast.makeText(getApplicationContext(), "Item 3", Toast.LENGTH_SHORT).show();
            }

            return true;

        }
    }


}