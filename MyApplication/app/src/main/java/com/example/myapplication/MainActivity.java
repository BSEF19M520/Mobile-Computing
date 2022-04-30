package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.atomic.AtomicBoolean;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(com.google.android.material.R.style.Theme_AppCompat_Light);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = this.findViewById(R.id.mainActivityTextView);
        final AtomicBoolean toggle = new AtomicBoolean(true);
        button = this.findViewById(R.id.mainActivityToggleButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (toggle.getAndSet(!toggle.get()))
                    textView.setText("Text changed");
                else
                    textView.setText(R.string.toggle_text);
            }
        });

        findViewById(R.id.mainActivityCalculatorActivityButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchToActivity(CalculatorActivity.class);
            }
        });

        findViewById(R.id.mainActivityLoginActivityButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchToActivity(LoginActivity.class);
            }
        });

        findViewById(R.id.mainActivityRegisterActivityButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchToActivity(RegisterActivity.class);
            }
        });

    }

    private void switchToActivity(Class clazz) {
        Intent intent = new Intent(this, clazz);
        this.startActivity(intent);
    }
}