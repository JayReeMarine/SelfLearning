package com.fit2081.a2_30324181;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.provider.Telephony;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ItemMap extends AppCompatActivity implements OnMapReadyCallback{


    SupportMapFragment mapFragment;

    Geocoder geocoder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_map);

        //map fragment is based on supportMapfragment
        mapFragment=(SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        geocoder=new Geocoder(this, Locale.getDefault());
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        LatLng latLng = new LatLng(-37.813629, 144.963058);
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(3));


        googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(@NonNull LatLng latLng) {

                List<Address> addresses=new ArrayList<>();
                try {
                    addresses = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1);
                    LatLng newLating = new LatLng(latLng.latitude, latLng.longitude);
                } catch (Exception e){
                    //bad internet connection
                }
                String message;
                if(addresses.size()>0){
                    String countryName = addresses.get(1).getCountryName();
                    Toast.makeText(ItemMap.this, "The selected country is " + countryName, Toast.LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(ItemMap.this, "No Country at this location!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}