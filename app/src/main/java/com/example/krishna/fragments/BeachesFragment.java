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

public class BeachesFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.places_grid, container, false);
        final ArrayList<Places> places = new ArrayList<Places>();

        places.add (new Places (
                R.drawable.leo_c_beach, R.string.leo_c_beach_name,
                R.string.leo_c_beach_about, R.string.leo_c_beach_address,
                R.string.leo_c_beach_contact, R.string.leo_c_beach_lat, R.string.leo_c_beach_lng));

        places.add (new Places (
                R.drawable.muscle_beach, R.string.muscle_beach_name,
                R.string.muscle_beach_about, R.string.muscle_beach_address,
                R.string.muscle_beach_contact, R.string.muscle_beach_lat, R.string.muscle_beach_lng));

        places.add (new Places (
                R.drawable.dockweiler_beach, R.string.dockweiler_beach_name,
                R.string.dockweiler_beach_about, R.string.dockweiler_beach_address,
                R.string.dockweiler_beach_contact, R.string.dockweiler_beach_lat, R.string.dockweiler_beach_lng));

        places.add (new Places (
                R.drawable.venice_beach, R.string.venice_beach_name,
                R.string.venice_beach_about, R.string.venice_beach_address,
                R.string.venice_beach_contact, R.string.venice_beach_lat, R.string.venice_beach_lng));

        places.add (new Places (
                R.drawable.marina_beach, R.string.marina_beach_name,
                R.string.marina_beach_about, R.string.marina_beach_address,
                R.string.marina_beach_contact, R.string.marina_beach_lat, R.string.marina_beach_lng));

        places.add (new Places (
                R.drawable.will_rogers_beach, R.string.will_rogers_beach_name,
                R.string.will_rogers_beach_about, R.string.will_rogers_beach_address,
                R.string.will_rogers_beach_contact, R.string.will_rogers_beach_lat, R.string.will_rogers_beach_lng));

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
                startActivity(intent);
            }
        });
        return rootView;



    }
}
