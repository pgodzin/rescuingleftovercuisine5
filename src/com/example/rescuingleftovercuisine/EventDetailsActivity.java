package com.example.rescuingleftovercuisine;

import android.app.Activity;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class EventDetailsActivity extends Activity implements LocationListener {

    private GoogleMap map;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_details);

        TextView detailName = (TextView) findViewById(R.id.detail_name);
        TextView detailTIme = (TextView) findViewById(R.id.detail_time);

        String locationString = getIntent().getStringExtra("location");
        String[] cords = locationString.split(",");

        Location loc = new Location("");
        loc.setLatitude(Double.valueOf(cords[0]));
        loc.setLongitude(Double.valueOf(cords[1]));

        detailName.setText(getIntent().getStringExtra("title"));
        detailTIme.setText(getIntent().getStringExtra("time"));

        Button start = (Button) findViewById(R.id.button_start);
        Button end = (Button) findViewById(R.id.button_end);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //startActivityForResult;

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

        putDestination(loc);

    }

    public void putDestination(Location destination){
        LatLng dest = new LatLng(destination.getLatitude(), destination.getLongitude());

        map.addMarker(new MarkerOptions()
                .position(dest)
                .title("Next Pickup")
                .snippet("Starbucks")
                .icon(BitmapDescriptorFactory
                .fromResource(R.drawable.ic_launcher)));
    }

    private void loadMap() {
        if (map != null) {
            return;
        }
        MapFragment mapFrag = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        map = mapFrag.getMap();

        if (map == null) {
            return;
        }
        //map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        map.setMyLocationEnabled(true);

    }

    @Override
    public void onLocationChanged(Location location) {

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