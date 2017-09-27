package com.example.krishna.placesDetail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
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
    private String[] mPlaceContact;
    private String mPlaceAddress;
    private double mPlaceLatitude;
    private double mPlaceLng;
    private String mPrimaryColor;


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.places_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar == null) {
            Log.d ("action", "action bar is null");
        }
        actionBar.setBackgroundDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.universal, null));

//        ActionBar.LayoutParams layoutParams = new ActionBar.LayoutParams(2,2);
//        layoutParams.gravity= Gravity.TOP;
//        view.setLayoutParams(layoutParams);
//        actionBar.se
        // actionBar.setBackgroundDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.ca_science_center, null));

        getExtraValues(getIntent());
        ((TextView) findViewById(R.id.about)).setText(
                mPlaceAbout != null ? mPlaceAbout : "No info found");
        if (mPlaceContact.length == 2) {
            ((TextView) findViewById(R.id.contactPhone)).setText(
                    mPlaceContact[0] != null ? mPlaceContact[0] : "No contact phone found");
            ((TextView) findViewById(R.id.contactUrl)).setText(
                    mPlaceContact[1] != null ? mPlaceContact[1] : "No web address found");
        } else {
            ((TextView) findViewById(R.id.contactPhone)).setText("No contact or web address found");
        }
        ((TextView) findViewById(R.id.address)).setText(
                mPlaceAddress != null ? mPlaceAddress : "No Address found");

        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng placeLocator = new LatLng(mPlaceLatitude, mPlaceLng);
        mMap.addMarker(new MarkerOptions().position(placeLocator).title(mPlaceName));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(placeLocator, 15));

    }

    private void getExtraValues (Intent intent) {
        mPlaceName = intent.getStringExtra("name");
        mPlaceAddress = intent.getStringExtra("address");
        mPlaceContact = intent.getStringExtra("contact").split("_");

        mPlaceAbout = intent.getStringExtra("about");
        mPlaceLatitude = Double.parseDouble(intent.getStringExtra("latitude"));
        mPlaceLng = Double.parseDouble(intent.getStringExtra("longitude"));
        mPrimaryColor = intent.getStringExtra("primaryColor");


    }
}