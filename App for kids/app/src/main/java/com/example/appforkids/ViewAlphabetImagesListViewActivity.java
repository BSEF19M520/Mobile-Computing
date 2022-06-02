package com.example.appforkids;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ViewAlphabetImagesListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_alphabet_images_list_view);

        String alphabet = this.getIntent().getStringExtra("alphabet");

        ListView listView = this.findViewById(R.id.viewAlphabetImagesActivity_listView);
        List<LessonItem> lessonItems = getAlphabetImagesIds(alphabet);

        LessonItemAdapter lessonItemAdapter = new LessonItemAdapter(this, lessonItems);
        listView.setAdapter(lessonItemAdapter);
    }

    private List<LessonItem> getAlphabetImagesIds(String alphabet) {
        // using reflection to dynamically load the images from drawable
        // key is the name of the image
        // value is the id
        List<LessonItem> lessonItems = new ArrayList<>();
        Field[] fields = R.drawable.class.getFields();
        String imagePrefix = "alphabet_image_" + alphabet.toLowerCase();

        for (Field field : fields) {
            String fieldName = field.getName();
            if (fieldName.startsWith(imagePrefix)) {
                // removing prefix
                String imageName = this.capitalize(fieldName.substring(fieldName.lastIndexOf("_") + 1));
                int id = this.getResources().getIdentifier(
                        fieldName, "drawable", this.getPackageName()
                );
                lessonItems.add(new LessonItem(id, imageName));
            }
        }
        return lessonItems;
    }

    private String capitalize(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }

}