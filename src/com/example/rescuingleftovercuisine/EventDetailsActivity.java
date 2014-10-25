package com.example.rescuingleftovercuisine;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EventDetailsActivity extends Activity {

    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
    private Uri fileUri;
    private File startImageFile;
    private File fileEndImageFile;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_details);

        TextView detailName = (TextView) findViewById(R.id.detail_name);
        TextView detailTIme = (TextView) findViewById(R.id.detail_time);
       TextView description = (TextView) findViewById(R.id.description);
        TextView location = (TextView) findViewById(R.id.location);
        final ArrayList<Uri> uris = new ArrayList<Uri>();

        String locationString = getIntent().getStringExtra("location");

        detailName.setText(getIntent().getStringExtra("title"));
        detailTIme.setText(getIntent().getStringExtra("time"));
       description.setText(getIntent().getStringExtra("description"));
        location.setText(getIntent().getStringExtra("location"));

        final Button signup = (Button) findViewById(R.id.signup_button);
        final Button cancel = (Button) findViewById(R.id.cancel_button);
        final Button receiptButton = (Button) findViewById(R.id.button_receipt);
        final Button startButton = (Button) findViewById(R.id.button_start);
        final Button reportButton = (Button) findViewById(R.id.report_button);
        final Button endButton = (Button) findViewById(R.id.button_end);
        final HorizontalScrollView scrollView = (HorizontalScrollView) findViewById(R.id.horizontalScrollView);
        final TextView spotsFilled = (TextView) findViewById(R.id.spots_filled);

        LinearLayout topLinearLayout = new LinearLayout(this);
        topLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
        int[] images = {R.drawable.fb1, R.drawable.fb2, R.drawable.fb3};
        spotsFilled.setText("Spots filled: " + getIntent().getIntExtra("currentNum", 0) + " / " + getIntent().getIntExtra("maxNum", 0));
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

        final Intent emailIntent = new Intent(Intent.ACTION_SEND_MULTIPLE);
        emailIntent.setType("application/image");
        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"mlabwa1@gmail.com"});
        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Receipt");
        String body = "";
        body += "Event Title: " + detailName.getText() + "\n";
        body += "Event Time: " + detailTIme.getText() + "\n";
        body += "Location: " + location.getText() + "\n";
        body += "Description: " + description.getText() + "\n";
        body += "The pickup, delivery, and receipt pictures are attached.";

        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, body);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startImageFile = getOutputMediaFile();
                fileUri = Uri.fromFile(startImageFile); // create a file to save the image
                i.putExtra(MediaStore.EXTRA_OUTPUT, fileUri); // set the image file name
                startActivityForResult(i, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);

                // while (startImageFile.exists()) { }
                Bitmap myBitmap = BitmapFactory.decodeFile(startImageFile.getAbsolutePath());
                startButton.setVisibility(View.GONE);
                endButton.setVisibility(View.VISIBLE);
                Uri temp1 = fileUri;
                uris.add(temp1);
               // emailIntent.putExtra(Intent.EXTRA_STREAM, fileUri);

            }

        });

        endButton.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                             fileEndImageFile = getOutputMediaFile();
                                             fileUri = Uri.fromFile(fileEndImageFile); // create a file to save the image
                                             i.putExtra(MediaStore.EXTRA_OUTPUT, fileUri); // set the image file name
                                             startActivityForResult(i, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);

                                             //while (fileEndImageFile.exists()) {
                                             Bitmap myBitmap = BitmapFactory.decodeFile(fileEndImageFile.getAbsolutePath());
                                             receiptButton.setVisibility(View.VISIBLE);
                                             endButton.setVisibility(View.GONE);
                                             Uri temp2 = fileUri;
                                             uris.add(temp2);

                                         }

                                     }
        );

        receiptButton.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                             fileEndImageFile = getOutputMediaFile();
                                             fileUri = Uri.fromFile(fileEndImageFile); // create a file to save the image
                                             i.putExtra(MediaStore.EXTRA_OUTPUT, fileUri); // set the image file name
                                             startActivityForResult(i, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);

                                             //while (fileEndImageFile.exists()) {
                                             Bitmap myBitmap = BitmapFactory.decodeFile(fileEndImageFile.getAbsolutePath());
                                             reportButton.setVisibility(View.VISIBLE);
                                             receiptButton.setVisibility(View.GONE);
                                             Uri temp3 = fileUri;
                                             uris.add(temp3);


                                         }

                                     }
        );

        reportButton.setOnClickListener(new View.OnClickListener() {
                                             @Override
                                             public void onClick(View v) {

                                                 reportButton.setVisibility(View.GONE);
                                                 emailIntent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, uris);
                                                 startActivity(Intent.createChooser(emailIntent, "Send mail..."));

                                             }

                                         }
        );



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                // Image captured and saved to fileUri specified in the Intent
                //Toast.makeText(this, "Image saved to:\n" + data.getData(), Toast.LENGTH_LONG).show();

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