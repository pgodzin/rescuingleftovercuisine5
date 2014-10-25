package com.example.rescuingleftovercuisine;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EventDetailsActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_details);

        TextView detailName = (TextView) findViewById(R.id.detail_name);
        TextView detailTIme = (TextView) findViewById(R.id.detail_time);

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

    }
}