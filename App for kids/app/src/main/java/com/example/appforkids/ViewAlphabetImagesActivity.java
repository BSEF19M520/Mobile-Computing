package com.example.appforkids;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class ViewAlphabetImagesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_alphabet_images);

        String alphabet = this.getIntent().getStringExtra("alphabet");
        Log.d("alphabet activity", alphabet);
        //first we create an array list to hold all the resources ids
        ArrayList<Integer> imageListId = new ArrayList<Integer>();

//we iterate through all the items in the drawable folder
        Field[] drawables = R.drawable.class.getFields();
        for (Field f : drawables) {
            Log.d("LOGGG", f.getName());
        }
            //if the drawable name contains "pic" in the filename...
//            imageListId.add(getResources().getIdentifier(f.getName(), "drawable", getPackageName()));
//        }

//now the ArrayList "imageListId" holds all ours image resource ids
        for (int imgResourceId : imageListId) {
            //do whatever you want here
        }

    }
}