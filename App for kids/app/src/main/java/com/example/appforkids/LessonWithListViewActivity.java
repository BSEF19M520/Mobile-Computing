package com.example.appforkids;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class LessonWithListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_with_list_view);

        List<String> alphabets = getAlphabetsList();
        ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, alphabets);

        ListView listView = findViewById(R.id.lessonActivityWithListView_listView);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String alphabet = ((TextView) view).getText().toString();
                Intent intent = new Intent(LessonWithListViewActivity.this, ViewAlphabetImagesActivity.class);
                intent.putExtra("alphabet", alphabet);
                LessonWithListViewActivity.this.startActivity(intent);
            }
        });

    }

    private List<String> getAlphabetsList() {
        List<String> alphabets = new ArrayList<>();
        alphabets.add("A");
        alphabets.add("B");
        alphabets.add("C");
        alphabets.add("D");
        alphabets.add("E");
        alphabets.add("F");
        alphabets.add("G");
        alphabets.add("H");
        alphabets.add("I");
        alphabets.add("J");
        alphabets.add("K");
        alphabets.add("L");
        alphabets.add("M");
        alphabets.add("N");
        alphabets.add("O");
        alphabets.add("P");
        alphabets.add("Q");
        alphabets.add("R");
        alphabets.add("S");
        alphabets.add("T");
        alphabets.add("U");
        alphabets.add("V");
        alphabets.add("W");
        alphabets.add("X");
        alphabets.add("Y");
        alphabets.add("Z");
        return alphabets;
    }
}