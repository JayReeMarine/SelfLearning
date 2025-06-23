package com.fit2081.week5mapslec;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    Geocoder geocoder;
    SupportMapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        geocoder = new Geocoder(this, Locale.getDefault());

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        LatLng latLng = new LatLng(-37.813629, 144.963058);
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
//        googleMap.animateCamera(CameraUpdateFactory.zoomTo(5));
        googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(@NonNull LatLng latLng) {

                List<Address> addresses = new ArrayList<>();
                try {

                    addresses = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1);
                    LatLng newLating = new LatLng(latLng.latitude, latLng.longitude);

                    String countryName = addresses.get(0).getCountryName();
                    googleMap.addMarker(new MarkerOptions().position(newLating).title(countryName));
                } catch (Exception e) {
                    // show an error to the user
                }
                String msg;
                if (addresses.size() > 0)
                    msg = addresses.get(0).getCountryName();
                else
                    msg = "No Country";
                Log.d("Week5_maps_app", msg);

            }
        });

    }
}