package com.example.appforkids;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button repoButton = this.findViewById(R.id.mainActivity_repoButton);
        repoButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(getString(R.string.repoLink)));
                startActivity(intent);
          }
        });

        Button lessonsButton = this.findViewById(R.id.mainActivity_lessonsButton);
        lessonsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LessonsActivity.class);
                startActivity(intent);
            }
        });

        Button examButton = this.findViewById(R.id.mainActivity_examButton);
        examButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ExamActivity.class);
                startActivity(intent);
            }
        });
    }
}