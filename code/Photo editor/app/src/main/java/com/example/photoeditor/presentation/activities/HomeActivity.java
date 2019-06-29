package com.example.photoeditor.presentation.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.photoeditor.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void Camera(View view){

    }

    public void Back(View view){
        Intent back= new Intent(this, MainActivity.class);
        startActivity(back);
    }
}
