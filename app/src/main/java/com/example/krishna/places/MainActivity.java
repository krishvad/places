package com.example.krishna.places;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    ViewPager mViewPager;
    PlacesPagerAdapter placesPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Set tabs
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(placesPagerAdapter);

        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.setupWithViewPager(mViewPager);
    }


}
