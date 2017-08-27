package com.example.krishna.placesDetail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.krishna.places.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class PlacesDetailMainView extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private String mPlaceName;
    private String mPlaceAbout;
    private String mPlaceContact;
    private String mPlaceAddress;
    private double mPlacelat;
    private double mPlaceLng;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.places_detail);

        //getActionBar().setDisplayHomeAsUpEnabled(true);
        getExtraValues(getIntent());
        ((TextView) findViewById(R.id.about)).setText(mPlaceAbout);
        ((TextView) findViewById(R.id.contact)).setText(mPlaceContact);
        ((TextView) findViewById(R.id.address)).setText(mPlaceAddress);

        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng placeLocator = new LatLng(mPlacelat, mPlaceLng);
        mMap.addMarker(new MarkerOptions().position(placeLocator).title(mPlaceName));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(placeLocator, 15));

    }

    private void getExtraValues (Intent intent) {
        mPlaceName = intent.getStringExtra("name");
        mPlaceAddress = intent.getStringExtra("address");
        mPlaceContact = intent.getStringExtra("contact");
        mPlaceAbout = intent.getStringExtra("about");
        mPlacelat = Double.parseDouble(intent.getStringExtra("latitude"));
        mPlaceLng = Double.parseDouble(intent.getStringExtra("longitude"));


    }
}