package com.example.rescuingleftovercuisine;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import backend.Event;

/**
 * Created by Damas on 10/24/14.
 */
public class EventsActivity extends Activity {

    ArrayAdapter<Event> adapter = null;
    ArrayList<Event> eventData = new ArrayList<Event>(); //Create an events class

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        ListView eventsList = (ListView) findViewById(R.id.lv_events);
        //sample event Data
        for(int i = 0; i < 10; i++) {
            Event test = new Event("Test Event " + i, "Today");
            eventData.add(test);
        }

        adapter = new ArrayAdapter<Event>(this, android.R.layout.simple_list_item_2, android.R.id.text1, eventData){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
//                LayoutInflater inflater = (LayoutInflater) getApplicationContext()
//                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//
//                View view = inflater.inflate(R.layout.activity_events, parent, false);
                View view =  super.getView(position, convertView, parent);

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
                /*
                String eventName = adapter.getItem(position);
                Intent detail = new Intent(this, DetailActivity.class);
                detail.putExtra(Intent.EXTRA_TEXT, eventName);
                startActivity(detail); */
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}