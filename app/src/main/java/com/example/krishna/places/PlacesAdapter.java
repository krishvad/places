package com.example.krishna.places;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Krishna on 5/29/17.
 */

public class PlacesAdapter extends ArrayAdapter<Places> {
    private Context mContext;

    public PlacesAdapter (Context context, ArrayList<Places> places) {

        super(context, 0, places);
        mContext = context;
    }

   @Override
    public View getView (int position, View currentView, ViewGroup parent) {
       View listItemView = currentView;
       if (currentView == null) {
           listItemView = LayoutInflater.from(mContext).inflate(R.layout.places_grid_list, parent, false);
       }
       Places currentPlace = getItem(position);
       TextView placesTextView = (TextView) listItemView.findViewById(R.id.tile_text);
       ImageView placesImageView = (ImageView) listItemView.findViewById(R.id.tile_image);

       placesTextView.setText(currentPlace.getPlaceName());
       placesImageView.setImageResource(currentPlace.getPlaceImage());

       if (currentView == null) {
           Log.d("current view is null", "current view is null");
       } else {
           Log.d("current view NOT null", "current view is  NOT null");

       }
       return listItemView;

   }
}
