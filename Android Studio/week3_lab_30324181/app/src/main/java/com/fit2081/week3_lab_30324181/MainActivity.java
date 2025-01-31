package com.fit2081.week3_lab_30324181;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button addCard;
    EditText num1, num2;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    MyRecyclerAdapter adapter;

    ArrayList<Item> data = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        addCard =findViewById(R.id.add_card);
        addCard.setOnClickListener(v -> {
            String num1St = num1.getText().toString();
            String num2St = num2.getText().toString();

            int num1Value = Integer.parseInt(num1St);
            int num2Value = Integer.parseInt(num2St);

            if (num1Value == num2Value) {
                Snackbar.make(v, "the numbers are equal", Snackbar.LENGTH_SHORT)
                        .setAction("Clear the numbers", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                num1.getText().clear();
                                num2.getText().clear();
                            }
                        }).show();
            } else {
                int result = Math.max(num1Value, num2Value);
                Item item = new Item(String.valueOf(result));
                data.add(item);
                adapter.notifyDataSetChanged();
            }

            });


        recyclerView = findViewById(R.id.my_recycler_view);

        layoutManager = new LinearLayoutManager(this);  //A RecyclerView.LayoutManager implementation which provides similar functionality to ListView.
        recyclerView.setLayoutManager(layoutManager);   // Also StaggeredGridLayoutManager and GridLayoutManager or a custom Layout manager


        adapter = new MyRecyclerAdapter();
        adapter.setData(data);
        recyclerView.setAdapter(adapter);

    }

}