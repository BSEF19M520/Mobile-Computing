package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(com.google.android.material.R.style.Theme_AppCompat_Light);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        TextView welcomeTextView = this.findViewById(R.id.welcomeTextView);
        Intent intent = this.getIntent();
        welcomeTextView.setText("Welcome " + intent.getStringExtra("name"));
    }
}