package com.example.krishna.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.krishna.places.Places;
import com.example.krishna.places.PlacesAdapter;
import com.example.krishna.places.R;
import com.example.krishna.placesDetail.PlacesDetailMainView;

import java.util.ArrayList;

/**
 * Created by Krishna on 6/25/17.
 */

public class MuseumsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.places_grid, container, false);
        final ArrayList<Places> places = new ArrayList<Places>();

        places.add (new Places (
                R.drawable.nh_museum, R.string.nh_museum_name,
                R.string.nh_museum_about, R.string.nh_museum_address,
                R.string.nh_museum_contact, R.string.nh_museum_lat, R.string.nh_museum_lng));

        places.add (new Places (
                R.drawable.lacma_museum, R.string.lacma_name,
                R.string.lacma_about, R.string.lacma_address,
                R.string.lacma_contact, R.string.lacma_lat, R.string.lacma_lng));

        places.add (new Places (
                R.drawable.la_brea_tarpits, R.string.la_brea_tarpits_name,
                R.string.lacma_about, R.string.la_brea_tarpits_address,
                R.string.la_brea_tarpits_contact,R.string.la_brea_tarpits_lat, R.string.la_brea_tarpits_lng));

        places.add (new Places (
                R.drawable.petersen_auto, R.string.peterson_auto_name,
                R.string.peterson_auto_about, R.string.peterson_auto_address,
                R.string.peterson_auto_contact, R.string.peterson_auto_lat, R.string.peterson_auto_lng));

        places.add (new Places (
                R.drawable.museum_tolerance, R.string.museum_tolerance_name,
                R.string.museum_tolerance_about, R.string.museum_tolerance_address,
                R.string.museum_tolerance_contact, R.string.museum_tolerance_lat, R.string.museum_tolerance_lng));

        places.add (new Places (
                R.drawable.ca_science_center, R.string.ca_science_ctr_name,
                R.string.ca_science_ctr_about, R.string.ca_science_ctr_address,
                R.string.ca_science_ctr_contact, R.string.ca_science_ctr_lat, R.string.ca_science_ctr_lng));


        PlacesAdapter placesAdapter = new PlacesAdapter(getActivity(), places);
        final GridView gridView = (GridView) rootView.findViewById(R.id.grid_view);
        gridView.setAdapter(placesAdapter);
        Log.d("get act before", getActivity().toString());

        //

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Places place = places.get(position);
                Intent intent = new Intent (getActivity(), PlacesDetailMainView.class);
                intent.putExtra("name", getString(place.getPlaceName()));
                intent.putExtra("about", getString(place.getPlaceAbout()));
                intent.putExtra("address", getString(place.getPlaceAddress()));
                intent.putExtra("contact", getString(place.getPlaceContact()));
                intent.putExtra("latitude", getString(place.getPlaceLatitude()));
                intent.putExtra("longitude", getString(place.getPlaceLongitude()));
                intent.putExtra("toolbar_logo", getString(place.getPlaceImage()));
                startActivity(intent);
            }
        });
        return rootView;



    }
}
