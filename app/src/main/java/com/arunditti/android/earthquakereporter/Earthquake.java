package com.arunditti.android.earthquakereporter;

import android.widget.EditText;

/**
 * Created by arunditti on 11/29/17.
 */

public class Earthquake {

    //Magnitude of the earthquake
    private double mMagnitude;

    //Location of the earthquake
    private String mLocation;

    //Date of the earthquake
    private long mTimeInMilliseconds;

    private String mUrl;

    /**
     * @param
     * @param magnitude is the magnitude of the earthquake
     * @param location is the location of the earthquake
     * @param timeInMilliseconds is the date the earthquake happened
     */

    public Earthquake(double magnitude, String location, long timeInMilliseconds, String url) {
        mMagnitude = magnitude;
        mLocation = location;
        mTimeInMilliseconds = timeInMilliseconds;
        mUrl = url;
    }

    public double getMagnitude(){
        return mMagnitude;
    }

    public String getLocation() {
        return mLocation;
    }

    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }

    public String getUrl() {
        return mUrl;
    }

}
