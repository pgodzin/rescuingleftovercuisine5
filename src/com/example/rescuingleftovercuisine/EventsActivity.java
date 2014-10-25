package com.example.rescuingleftovercuisine;

import android.app.Activity;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import backend.Event;

import java.util.ArrayList;

public class EventsActivity extends Activity implements LocationListener {

    private GoogleMap map;
    ArrayAdapter<Event> adapter = null;
    ArrayList<Event> eventData = new ArrayList<Event>(); //Create an events class

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        ListView eventsList = (ListView) findViewById(R.id.lv_events);
        //sample event Data
        for (int i = 0; i < 10; i++) {
            Event test = new Event("Test Event " + i, "Today");
            test.setEventDescription("Test descritption! A pickup will happen here blah blah blah blah....");
            test.setEventLocation("40.756832, -73.977269");
            eventData.add(test);
        }

        adapter = new ArrayAdapter<Event>(this, android.R.layout.simple_list_item_2, android.R.id.text1, eventData) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                View view = super.getView(position, convertView, parent);

                TextView eventTitle = (TextView) view.findViewById(android.R.id.text1);
                TextView eventTime = (TextView) view.findViewById(android.R.id.text2);

                eventTitle.setText(eventData.get(position).getEventTitle());
                eventTime.setText(eventData.get(position).getEventTime());

                return view;
            }
        };

        eventsList.setAdapter(adapter);

        eventsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Item " + position + " selected", Toast.LENGTH_SHORT).show();

                //call detail activity to view details of this activity

                Event event = adapter.getItem(position);
                Intent detail = new Intent(EventsActivity.this, EventDetailsActivity.class);
                String title = event.getEventTitle();
                String time = event.getEventTime();
                detail.putExtra("title", title);
                detail.putExtra("time", time);
                detail.putExtra("location", event.getEventLocation());
                detail.putExtra("description", event.getEventDescription());

                startActivity(detail);
            }
        });

        //map logic
        loadMap();

        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        // Creating a criteria object to retrieve provider
        Criteria criteria = new Criteria();

        // Getting the name of the best provider
        String provider = locationManager.getBestProvider(criteria, true);

        // Getting Current Location
        Location location = locationManager.getLastKnownLocation(provider);

        if(location!=null){
            onLocationChanged(location);
        }
        locationManager.requestLocationUpdates(provider, 20000, 0, this);

        markPickups();
    }

    /*
    Load the map.
    There's an issue where map loads the last known location or the center of the earth
     */
    private void loadMap() {
        if (map != null) {
            return;
        }
        MapFragment mapFrag = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        map = mapFrag.getMap();

        if (map == null) {
            return;
        }

        map.setMyLocationEnabled(true);

    }

    /*
    Mark all pickup locations for all events
     */
    private void markPickups(){
        for(int i = 0; i < eventData.size(); i++){
            Event event = eventData.get(i);
            String[] cords = event.getEventLocation().split(",");
            LatLng dest = new LatLng(Double.valueOf(cords[0]), Double.valueOf(cords[1]));

            map.addMarker(new MarkerOptions()
                    .position(dest)
                    .title(event.getEventTitle())
                    .snippet(event.getEventTime())
                    .icon(BitmapDescriptorFactory
                            .fromResource(R.drawable.ic_launcher)));

        }
    }

    @Override
    public void onLocationChanged(Location location) {
        double latitude = location.getLatitude();

        // Getting longitude of the current location
        double longitude = location.getLongitude();

        // Creating a LatLng object for the current location
        LatLng latLng = new LatLng(latitude, longitude);

        map.moveCamera(CameraUpdateFactory.newLatLng(latLng));

        // Zoom in, animating the camera.
        map.animateCamera(CameraUpdateFactory.zoomTo(14), 2000, null);
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}