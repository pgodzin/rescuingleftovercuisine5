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
import backend.Data_Array;

import backend.Event;

import java.util.ArrayList;

public class EventsActivity extends Activity {

    ArrayAdapter<Event> adapter = null;
    ArrayAdapter<Event> later_adapter = null;

    ArrayList<Event> eventData = new ArrayList<Event>(); //Create an events class
    ArrayList<Event> laterEventData = new ArrayList<Event>(); //Create an events class

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        Event[] arr = Data_Array.events();

        ListView eventsList = (ListView) findViewById(R.id.lv_events);

        for (int i = 0; i < 2; i++) {
            eventData.add(arr[i]);
        }

        ListView laterEventsList = (ListView) findViewById(R.id.lv_later);

        for (int i = 2; i < arr.length; i++) {
            laterEventData.add(arr[i]);
        }

        adapter = new ArrayAdapter<Event>(this, R.layout.list_item, R.id.li_event, eventData) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                View view = super.getView(position, convertView, parent);

                TextView eventTitle = (TextView) view.findViewById(R.id.li_event);
                TextView eventTime = (TextView) view.findViewById(R.id.datetime);
                TextView location = (TextView) view.findViewById(R.id.location);

                eventTitle.setText(eventData.get(position).getEventTitle());
                eventTime.setText(eventData.get(position).getEventDate() + " at " +
                        eventData.get(position).getEventTime());
                location.setText(eventData.get(position).getEventLocation());

                return view;
            }
        };

        later_adapter = new ArrayAdapter<Event>(this, R.layout.list_item, R.id.li_event, laterEventData) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                View view = super.getView(position, convertView, parent);

                TextView eventTitle = (TextView) view.findViewById(R.id.li_event);
                TextView eventTime = (TextView) view.findViewById(R.id.datetime);
                TextView location = (TextView) view.findViewById(R.id.location);

                eventTitle.setText(laterEventData.get(position).getEventTitle());
                eventTime.setText(laterEventData.get(position).getEventDate() + " at " +
                        laterEventData.get(position).getEventTime());
                location.setText(laterEventData.get(position).getEventLocation());

                return view;
            }
        };

        eventsList.setAdapter(adapter);
        laterEventsList.setAdapter(later_adapter);

        eventsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Event event = adapter.getItem(position);
                Intent detail = new Intent(EventsActivity.this, EventDetailsActivity.class);
                String title = event.getEventTitle();
                String time = event.getEventTime();
                String location = event.getEventLocation();
                String description = event.getEventDescription();
                int currentNum = event.getCurrentNum();
                int maxNum = event.getMaxNum();
                String leader = event.getLeadRescuer();

                detail.putExtra("title", title);
                detail.putExtra("time", time);
                detail.putExtra("location", location);
                detail.putExtra("description", description);
                detail.putExtra("currentNum", currentNum);
                detail.putExtra("maxNum", maxNum);
                detail.putExtra("leader", leader);


                startActivity(detail);
            }
        });

        laterEventsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Event event = adapter.getItem(position);
                Intent detail = new Intent(EventsActivity.this, EventDetailsActivity.class);
                String title = event.getEventTitle();
                String time = event.getEventTime();
                String location = event.getEventLocation();
                String description = event.getEventDescription();
                int currentNum = event.getCurrentNum();
                int maxNum = event.getMaxNum();
                String leader = event.getLeadRescuer();

                detail.putExtra("title", title);
                detail.putExtra("time", time);
                detail.putExtra("location", location);
                detail.putExtra("description", description);
                detail.putExtra("currentNum", currentNum);
                detail.putExtra("maxNum", maxNum);
                detail.putExtra("leader", leader);

                startActivity(detail);
            }
        });

        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        // Creating a criteria object to retrieve provider
        Criteria criteria = new Criteria();

        // Getting the name of the best provider
        String provider = locationManager.getBestProvider(criteria, true);

        // Getting Current Location
        Location location = locationManager.getLastKnownLocation(provider);

        //markPickups();
    }
}