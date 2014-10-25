package com.example.rescuingleftovercuisine;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import backend.Event;

import java.util.ArrayList;

public class EventsActivity extends Activity {

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

                startActivity(detail);
            }
        });
    }

}