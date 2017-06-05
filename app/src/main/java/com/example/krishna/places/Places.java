package com.example.krishna.places;

/**
 * Created by Krishna on 5/29/17.
 */

public class Places {
    private int mImageResourceId;
    private String mText;

    public Places (int imageResourceId,String resourceText) {
        mImageResourceId = imageResourceId;
        mText = resourceText;
    }

    public int getImageResourceId () {
        return mImageResourceId;
    }

    public String getText () {
        return mText;
    }
}
