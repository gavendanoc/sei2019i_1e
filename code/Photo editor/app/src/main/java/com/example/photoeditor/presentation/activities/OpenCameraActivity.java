package com.example.photoeditor.presentation.activities;

import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.photoeditor.R;

public class OpenCameraActivity extends AppCompatActivity {

    ImageView photo;
    Uri path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_camera);
        photo = (ImageView) findViewById(R.id.photo);
        path = (Uri) getIntent().getParcelableExtra("photo");
        photo.setImageURI(path);
    }
}
