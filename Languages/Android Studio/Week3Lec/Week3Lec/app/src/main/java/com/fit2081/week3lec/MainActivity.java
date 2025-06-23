package com.fit2081.week3lec;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    DrawerLayout drawerLayout;
    NavigationView navigationView;

    Toolbar toolbar;

    FloatingActionButton fab;

    ArrayList<String> dataSource;
    ListView listView;
    TextView tv;

    ArrayAdapter<String> adapter;

    RecyclerView recyclerView;
    Week3RecyclerAdapter personAdapter;

    ArrayList<Person> people;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.nav_open, R.string.nav_close);
        toggle.syncState();

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new Week3NavListener());

        fab=findViewById(R.id.fab);
        fab.setOnClickListener(new Week3FabListener());
        dataSource=new ArrayList<>();



        listView=findViewById(R.id.listview_id);
        adapter=new ArrayAdapter<>(this, R.layout.listview_item_layout,dataSource);
        listView.setAdapter(adapter);


        recyclerView=findViewById(R.id.recycler_id);

        layoutManager = new LinearLayoutManager(this);  //A RecyclerView.LayoutManager implementation which provides similar functionality to ListView.
        recyclerView.setLayoutManager(layoutManager);   // Also StaggeredGridLayoutManager and GridLayoutManager or a custom Layout manager


        personAdapter=new Week3RecyclerAdapter();
        people=new ArrayList<>();
        Person person=new Person("Alex",31,"Perth");
        personAdapter.setData(people);
        recyclerView.setAdapter(personAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        String msg="";

        if (id == R.id.options_menu_item_1) {
            msg="Options Item 1";

            dataSource.clear();
            adapter.notifyDataSetChanged();
        } else if (id == R.id.options_menu_item_2) {

            Person person=new Person("Tim",23,"Mel");
            people.add(person);
            personAdapter.notifyDataSetChanged();

            msg="Options Item 2";



        } else if (id == R.id.options_menu_item_3) {
            msg="Options Item 3";


        }
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();

        return true;
    }

    class Week3FabListener implements  View.OnClickListener{

        @Override
        public void onClick(View v) {
            int rand=(int)(Math.random()*1000);
            dataSource.add("Value ("+rand+")");
            adapter.notifyDataSetChanged();


            Snackbar.make(v,"Thank you for Clicking FAB",Snackbar.LENGTH_SHORT ).setAction("UNDO", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), "OK.. We will undo your work", Toast.LENGTH_LONG).show();
                }
            }).show();


        }
    }

    class Week3NavListener implements NavigationView.OnNavigationItemSelectedListener {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            int id = item.getItemId();
            String msg="";

            if (id == R.id.nav_menu_item_1) {
                msg="Item 1";

                getSupportFragmentManager().beginTransaction().replace(R.id.fragments_container_id,new Fragment1()).commit();
                getSupportFragmentManager().beginTransaction().replace(R.id.fratments_container_2_id,new Fragment1()).commit();



            } else if (id == R.id.nav_menu_item_2) {
                msg="Item 2";
                getSupportFragmentManager().beginTransaction().replace(R.id.fragments_container_id,new Fragment2()).commit();
                getSupportFragmentManager().beginTransaction().replace(R.id.fratments_container_2_id,new Fragment2()).commit();


            } else if (id == R.id.nav_menu_item_3) {
                msg="Item 3";


            }
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();

            return true;
        }
    }



}