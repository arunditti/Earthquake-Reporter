package com.arunditti.android.earthquakereporter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by arunditti on 11/29/17.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //Check if there is existing list item view called convertView that we can reuse otherwise,
        // if convertView is null, then inflate a new list item layout
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        //Find the earthquakes at the given position in the list of earthquakes
        Earthquake currentEarthquakelocation = getItem(position);

        //Find the TextView with the view ID magnitue_text_view
        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.magnitude_text_view);
        magnitudeTextView.setText(currentEarthquakelocation.getMagnitude());

        //Find the TextView with the view ID location_text_view
        TextView locationTextView = (TextView) listItemView.findViewById(R.id.location_text_view);
        locationTextView.setText(currentEarthquakelocation.getLocation());

        //Find the TextView with the view ID date_text_view
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date_text_view);
        dateTextView.setText(currentEarthquakelocation.getDate());

        //Return the list item view that is now showing the appropriate data
        return listItemView;
    }
}
