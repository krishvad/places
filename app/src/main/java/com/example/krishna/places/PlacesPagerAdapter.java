package com.example.krishna.places;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.krishna.fragments.AttractionsFragment;
import com.example.krishna.fragments.MuseumsFragment;

public class PlacesPagerAdapter extends FragmentPagerAdapter {

    public PlacesPagerAdapter (FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new AttractionsFragment();
            case 1:
                return new MuseumsFragment();
            case 2:
                return new AttractionsFragment();
            case 3:
                return new AttractionsFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Attractions";
            case 1:
                return "Museums";
            case 2:
                return "Beaches";
            case 3:
                return "Hiking Trails";

        }
        return null;
    }

}
