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
import com.example.krishna.placesDetail.PlacesDetailMainView;
import com.example.krishna.places.R;

import java.util.ArrayList;

/**
 * Created by Krishna on 6/25/17.
 */

public class AttractionsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.places_grid, container, false);
        final ArrayList<Places> places = new ArrayList<Places>();

        places.add (new Places (
                R.drawable.universal, R.string.universal_name,
                R.string.universal_about, R.string.univeral_address,
                R.string.universal_contact, R.string.universal_lat, R.string.universal_lng));

        places.add (new Places (
                R.drawable.getty, R.string.gryff_name,
                R.string.gryff_about, R.string.gryff_address,
                R.string.gryff_contact, R.string.gryff_lat, R.string.gryff_lng));

        places.add (new Places (
                R.drawable.sm_pier, R.string.sm_pier_name,
                R.string.sm_pier_about, R.string.sm_pier_address,
                R.string.sm_pier_contact, R.string.sm_pier_lat, R.string.sm_pier_lng));

        places.add (new Places (
                R.drawable.disney_land, R.string.disney_land_name,
                R.string.disney_land_about, R.string.disney_land_address,
                R.string.disney_land_contact, R.string.disney_land_lat, R.string.disney_land_lng));

        places.add (new Places (
                R.drawable.getty, R.string.getty_name,
                R.string.getty_about, R.string.getty_address,
                R.string.getty_contact, R.string.getty_lat, R.string.getty_lng));

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
                intent.putExtra("primaryColor", "#3F51B5");
                Log.v ("Place image is", "place image: " + place.getPlaceImage());
                intent.putExtra("toolbar_logo", (place.getPlaceImage()));

                startActivity(intent);
            }
        });
        return rootView;



    }
}
