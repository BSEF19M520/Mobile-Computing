package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

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
        setContentView(R.layout.register);
        textView = this.findViewById(R.id.mainActivityTextView);
        String initialText = (String) textView.getText();
        final AtomicBoolean toggle = new AtomicBoolean(true);
        button = this.findViewById(R.id.mainActivityToggleButton);
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