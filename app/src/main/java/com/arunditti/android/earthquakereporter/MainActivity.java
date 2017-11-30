package com.arunditti.android.earthquakereporter;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create a fake list of earthquake locations.
        ArrayList<Earthquake> earthquakes = new ArrayList<Earthquake>();

        // Earthquake earthquake = new Earthquake("1", "San fransisco", "1");
        // earthquakes.add(earthquake);

        earthquakes.add (new Earthquake("1","San Francisco", "1"));
        earthquakes.add (new Earthquake("1","San Francisco", "1"));
        earthquakes.add (new Earthquake("1","San Francisco", "1"));
        earthquakes.add (new Earthquake("1","San Francisco", "1"));
        earthquakes.add (new Earthquake("1","San Francisco", "1"));
        earthquakes.add (new Earthquake("1","San Francisco", "1"));

        // Create a new {@link ArrayAdapter} of earthquakes
       EarthquakeAdapter adapter = new EarthquakeAdapter(this, earthquakes);

        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(adapter);
    }
}