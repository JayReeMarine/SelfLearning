package com.fit2081.fleetappprep;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.fit2081.fleetappprep.provider.Car;
import com.fit2081.fleetappprep.provider.Fleet;
import com.fit2081.fleetappprep.provider.FleetViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements IDeleteFleet {

    String[] makers = {"BMW", "Toyota", "Audi", "Tesla", "Kia"};
    String[] models = {"X7", "Camry", "A8", "Rio", "Kluger"};
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private FleetAdapter adapter;

    ArrayList<Fleet> fleets;
    private FleetViewModel mFleetViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fleets = new ArrayList<>();
        recyclerView = findViewById(R.id.recycler_id);

        layoutManager = new LinearLayoutManager(this);  //A RecyclerView.LayoutManager implementation which provides similar functionality to ListView.
        recyclerView.setLayoutManager(layoutManager);   // Also StaggeredGridLayoutManager and GridLayoutManager or a custom Layout manager
        adapter = new FleetAdapter(this);
        adapter.setData(fleets);
        recyclerView.setAdapter(adapter);

        mFleetViewModel = new ViewModelProvider(this).get(FleetViewModel.class);
        mFleetViewModel.getAllFleets().observe(this, newData -> {
            adapter.setData((ArrayList<Fleet>) newData);
            adapter.notifyDataSetChanged();
        });

    }

    public void onAddFleetBtn(View v) {
        int randMaker;
        int randModel;
        int randCars;
        ArrayList<Car> cars = new ArrayList<>();
        randCars = (int) (Math.random() * 10);
        for (int i = 0; i < randCars; i++) {
            randMaker = (int) (Math.random() * makers.length);
            randModel = (int) (Math.random() * models.length);

            cars.add(new Car(makers[randMaker], models[randModel]));
        }

        Fleet fleet = new Fleet("Fleet" + randCars, cars);
        mFleetViewModel.insert(fleet);
    }

    @Override
    public void onDeleteInvoiceById(int id) {

        mFleetViewModel.deleteFleet(id);

    }
}