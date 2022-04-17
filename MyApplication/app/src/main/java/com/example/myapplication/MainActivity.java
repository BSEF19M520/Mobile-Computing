package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.atomic.AtomicBoolean;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(com.google.android.material.R.style.Theme_AppCompat_Light);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LayoutInflater layoutInflater = getLayoutInflater();
        View mainActivityView = layoutInflater.inflate(R.layout.activity_main, null);
        TextView textView = (TextView) mainActivityView.findViewById(R.id.textView);
        String initialText = (String) textView.getText();
        final AtomicBoolean toggle = new AtomicBoolean(true);
        Button button = (Button) mainActivityView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (toggle.getAndSet(!toggle.get()))
                    textView.setText("Text changed");
                else
                    textView.setText(initialText);
            }
        });
    }

}