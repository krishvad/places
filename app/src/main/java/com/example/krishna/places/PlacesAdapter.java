package com.example.krishna.places;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by Krishna on 5/29/17.
 */

public class PlacesAdapter extends ArrayAdapter<Places> {
    private ArrayList<Places> mPlaces;
    private Context mContext;

    public PlacesAdapter (Context context, ArrayList<Places> places) {

        super(context, 0, places);
        mPlaces = places;
        mContext = context;
    }

   @Override
    public View getView (int position, View currentView, ViewGroup parent) {
       if (currentView == null) {
           LayoutInflater.from(mContext).inflate(R.layout.places_grid_list, parent, false);
       }

       return currentView;

   }
}
