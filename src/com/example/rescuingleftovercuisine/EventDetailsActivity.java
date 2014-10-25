package com.example.rescuingleftovercuisine;

import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

;

public class EventDetailsActivity extends Activity {

    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
    private Uri fileUri;
    private File fileStartImageFile;
    private File fileEndImageFile;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_details);

        TextView detailName = (TextView) findViewById(R.id.detail_name);
        TextView detailTIme = (TextView) findViewById(R.id.detail_time);
        TextView description = (TextView) findViewById(R.id.description);
        TextView location = (TextView) findViewById(R.id.location);

        String locationString = getIntent().getStringExtra("location");
        String[] cords = locationString.split(",");

        Location loc = new Location("");
//        loc.setLatitude(Double.valueOf(cords[0]));
//        loc.setLongitude(Double.valueOf(cords[1]));

        detailName.setText(getIntent().getStringExtra("title"));
        detailTIme.setText(getIntent().getStringExtra("time"));
        description.setText(getIntent().getStringExtra("description"));
        location.setText(getIntent().getStringExtra("location"));

        final Button signup = (Button) findViewById(R.id.signup_button);
        final Button cancel = (Button) findViewById(R.id.cancel_button);
        final Button startButton = (Button) findViewById(R.id.button_start);
        final Button endButton = (Button) findViewById(R.id.button_end);
        final HorizontalScrollView scrollView = (HorizontalScrollView) findViewById(R.id.horizontalScrollView);
        final TextView spotsFilled = (TextView) findViewById(R.id.spots_filled);

        LinearLayout topLinearLayout = new LinearLayout(this);
        topLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
        int[] images = {R.drawable.fb1, R.drawable.fb2, R.drawable.fb3};
        spotsFilled.setText(getIntent().getIntExtra("currentNum", 0) + " / " + getIntent().getIntExtra("maxNum", 0));
        for (int i = 0; i < images.length; i++) {
            final ImageView imageView = new ImageView(this);
            imageView.setTag(i);
            imageView.setImageResource(images[i]);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setMaxHeight(80);
            imageView.setMaxWidth(80);

            imageView.setPadding(10, 5, 5, 10);
            topLinearLayout.addView(imageView);

        }

        scrollView.addView(topLinearLayout);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup.setVisibility(View.GONE);
                startButton.setVisibility(View.VISIBLE);
                cancel.setVisibility(View.VISIBLE);
                scrollView.setVisibility(View.VISIBLE);
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup.setVisibility(View.VISIBLE);
                startButton.setVisibility(View.GONE);
                cancel.setVisibility(View.GONE);
                scrollView.setVisibility(View.GONE);

            }
        });


        final ImageView startImage = (ImageView) findViewById(R.id.imageView_start);
        final ImageView endImage = (ImageView) findViewById(R.id.imageView_end);
        /*
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                fileStartImageFile = getOutputMediaFile();
                fileUri = Uri.fromFile(fileStartImageFile); // create a file to save the image
                i.putExtra(MediaStore.EXTRA_OUTPUT, fileUri); // set the image file name
                startActivityForResult(i, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);

                if (fileStartImageFile.exists()) {
                    Bitmap myBitmap = BitmapFactory.decodeFile(fileStartImageFile.getAbsolutePath());
                    ImageView startImage = (ImageView) findViewById(R.id.imageView_start);
                    startImage.setImageBitmap(myBitmap);
                    startImage.setVisibility(View.VISIBLE);
                    startButton.setVisibility(View.GONE);

                }
            }
        });

<<<<<<< HEAD
        endButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                fileEndImageFile = getOutputMediaFile();
                fileUri = Uri.fromFile(fileEndImageFile); // create a file to save the image
                i.putExtra(MediaStore.EXTRA_OUTPUT, fileUri); // set the image file name
                startActivityForResult(i, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);

                if (fileEndImageFile.exists()) {
                    Bitmap myBitmap = BitmapFactory.decodeFile(fileEndImageFile.getAbsolutePath());
                    ImageView endImage = (ImageView) findViewById(R.id.imageView_end);
                    endImage.setImageBitmap(myBitmap);
                    endImage.setVisibility(View.VISIBLE);
                    endButton.setVisibility(View.GONE);

                }
            }
        }); */
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                // Image captured and saved to fileUri specified in the Intent
                // Toast.makeText(this, "Image saved to:\n" + data.getData(), Toast.LENGTH_LONG).show();

            } else if (resultCode == RESULT_CANCELED) {
                // User cancelled the image capture
            } else {
                // Image capture failed, advise user
            }
        }
    }

    /**
     * Create a File for saving an image or video
     */
    private static File getOutputMediaFile() {
        // To be safe, you should check that the SDCard is mounted
        // using Environment.getExternalStorageState() before doing this.

        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "MyCameraApp");
        // This location works best if you want the created images to be shared
        // between applications and persist after your app has been uninstalled.

        // Create the storage directory if it does not exist
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                Log.d("MyCameraApp", "failed to create directory");
                return null;
            }
        }

        // Create a media file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File mediaFile;
        mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                "IMG_" + timeStamp + ".jpg");

        return mediaFile;
    }
}