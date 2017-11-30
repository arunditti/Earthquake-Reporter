package com.arunditti.android.earthquakereporter;

import android.widget.EditText;

/**
 * Created by arunditti on 11/29/17.
 */

public class Earthquake {

    //Magnitude of the earthquake
    private String mMagnitude;

    //Location of the earthquake
    private String mLocation;

    //Date of the earthquake
    private String mDate;

    /**
     * @param
     * @param magnitude is the magnitude of the earthquake
     * @param location is the location of the earthquake
     * @param date is the date the earthquake happened
     */

    public Earthquake(String magnitude, String location, String date) {
        mMagnitude = magnitude;
        mLocation = location;
        mDate = date;
    }

    public String getMagnitude(){
        return mMagnitude;
    }

    public String getLocation() {
        return mLocation;
    }

    public String getDate() {
        return mDate;
    }

}
