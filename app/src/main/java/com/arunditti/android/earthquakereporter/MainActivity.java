package com.arunditti.android.earthquakereporter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

        private static final String LOG_TAG = MainActivity.class.getName();

        /** URL for earthquake data from the USGS dataset */
        private static final String USGS_REQUEST_URL =
                "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&orderby=time&minmag=5&limit=10";

        /** Adapter for the list of earthquakes */
        private EarthquakeAdapter mAdapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            // Find a reference to the {@link ListView} in the layout
            ListView earthquakeListView = (ListView) findViewById(R.id.list);

            // Create a new adapter that takes an empty list of earthquakes as input
            mAdapter = new EarthquakeAdapter(this, new ArrayList<Earthquake>());

            // Set the adapter on the {@link ListView}
            // so the list can be populated in the user interface
            earthquakeListView.setAdapter(mAdapter);

            // Set an item click listener on the ListView, which sends an intent to a web browser
            // to open a website with more information about the selected earthquake.
            earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    // Find the current earthquake that was clicked on
                    Earthquake currentEarthquake = mAdapter.getItem(position);

                    // Convert the String URL into a URI object (to pass into the Intent constructor)
                    Uri earthquakeUri = Uri.parse(currentEarthquake.getUrl());

                    // Create a new intent to view the earthquake URI
                    Intent websiteIntent = new Intent(Intent.ACTION_VIEW, earthquakeUri);

                    // Send the intent to launch a new activity
                    startActivity(websiteIntent);
                }
            });

            // Start the AsyncTask to fetch the earthquake data
            EarthquakeAsyncTask task = new EarthquakeAsyncTask();
            task.execute(USGS_REQUEST_URL);
        }

        /**
         * {@link AsyncTask} to perform the network request on a background thread, and then
         * update the UI with the list of earthquakes in the response.

         */
        private class EarthquakeAsyncTask extends AsyncTask<String, Void, List<Earthquake>> {

            /**
             * This method runs on a background thread and performs the network request.
             * We should not update the UI from a background thread, so we return a list of
             * {@link Earthquake}s as the result.
             */
            @Override
            protected List<Earthquake> doInBackground(String... urls) {
                // Don't perform the request if there are no URLs, or the first URL is null
                if (urls.length < 1 || urls[0] == null) {
                    return null;
                }

                List<Earthquake> result = QueryUtils.fetchEarthquakeData(urls[0]);
                return result;
            }

            /**
             * This method runs on the main UI thread after the background work has been
             * completed.
             */
            @Override
            protected void onPostExecute(List<Earthquake> data) {
                // Clear the adapter of previous earthquake data
                mAdapter.clear();

                // If there is a valid list of {@link Earthquake}s, then add them to the adapter's
                // data set. This will trigger the ListView to update.
                if (data != null && !data.isEmpty()) {
                    mAdapter.addAll(data);
                }
            }
        }
    }