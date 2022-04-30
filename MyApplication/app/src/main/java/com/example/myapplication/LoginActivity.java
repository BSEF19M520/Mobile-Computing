package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(com.google.android.material.R.style.Theme_AppCompat_Light);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
}