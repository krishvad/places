package com.example.krishna.places;

/**
 * Created by Krishna on 5/29/17.
 */

public class Places {
    private int mPlaceImage;
    private int mPlaceName;
    private int mPlaceAddress;
    private int mPlaceAbout;
    private int mPlaceContact;
    private int mPlaceLat;
    private int mPlaceLng;


    public Places (int placeImage,int placeName, int placeAbout, int placeAddress, int placeContact, int placelat, int placeLng) {
        mPlaceImage = placeImage;
        mPlaceName = placeName;
        mPlaceAbout = placeAbout;
        mPlaceAddress = placeAddress;
        mPlaceContact = placeContact;
        mPlaceLat = placelat;
        mPlaceLng = placeLng;

    }

    public int getPlaceImage () {
        return mPlaceImage;
    }

    public int getPlaceName () {
        return mPlaceName != 0 ? mPlaceName : 0;
    }

    public int getPlaceAddress() {
        return mPlaceAddress != 0 ? mPlaceAddress : 0;
    }

    public int getPlaceAbout () {
        return mPlaceAbout != 0 ? mPlaceAbout : 0;
    }

    public int getPlaceContact() {
        return mPlaceContact != 0 ? mPlaceContact : 0;

    }

    public int getPlaceLatitude() {
        return mPlaceLat != 0 ? mPlaceLat : 0;
    }

    public int getPlaceLongitude() {
        return mPlaceLng != 0 ? mPlaceLng : 0;
    }

}
