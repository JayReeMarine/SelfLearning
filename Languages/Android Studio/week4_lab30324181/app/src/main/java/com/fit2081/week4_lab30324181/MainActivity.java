package com.fit2081.week4_lab30324181;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.fit2081.week4_lab30324181.provider.DeviceFeature;
import com.fit2081.week4_lab30324181.provider.application;
import com.fit2081.week4_lab30324181.provider.ApplicationViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private ApplicationAdapter adapter;

    ArrayList<application> applications;
    private ApplicationViewModel mAllApplicationsViewModel;


    EditText deviceName, year,deviceFeaturesName,SortOrder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        deviceName = findViewById(R.id.deviceName);
        year = findViewById(R.id.year);
        deviceFeaturesName = findViewById(R.id.deviceFeaturesName);
        SortOrder= findViewById(R.id.sortOrder);
        year.setText("2024");



        applications = new ArrayList<>();
        recyclerView = findViewById(R.id.recycler_id);

        layoutManager = new LinearLayoutManager(this);  //A RecyclerView.LayoutManager implementation which provides similar functionality to ListView.
        recyclerView.setLayoutManager(layoutManager);   // Also StaggeredGridLayoutManager and GridLayoutManager or a custom Layout manager
        adapter = new ApplicationAdapter();
        adapter.setData(applications);
        recyclerView.setAdapter(adapter);

        mAllApplicationsViewModel =new ViewModelProvider(this).get(ApplicationViewModel.class);
        mAllApplicationsViewModel.getAllFleets().observe(this, newData -> {
            adapter.setData((ArrayList<application>) newData);
            adapter.notifyDataSetChanged();
        });

    }
    ArrayList<DeviceFeature> deviceFeatures;
    public void onAddFeatureBtn(View v) {
        String featureNameText = deviceFeaturesName.getText().toString();
        String sortOrderText = SortOrder.getText().toString();
        int sortOrderValue = Integer.parseInt(sortOrderText);

        deviceFeatures = new ArrayList<>();
        deviceFeatures.add(new DeviceFeature(featureNameText,sortOrderValue));

        Toast.makeText(this, "feature is added", Toast.LENGTH_SHORT).show();
//
//        Fleet fleet = new Fleet("Fleet" + randCars, cars);
//        mFleetViewModel.insert(fleet);
    }

    public void onAddApplication(View v){
        String deviceNameText = deviceName.getText().toString();
        String yearText = year.getText().toString();
        int yearValue = Integer.parseInt(yearText);

        application application = new application(deviceNameText,yearValue,deviceFeatures);

        mAllApplicationsViewModel.insert(application);
        Toast.makeText(this, "application is added", Toast.LENGTH_SHORT).show();

    }

}