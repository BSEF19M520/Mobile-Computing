package com.example.appforkids;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ViewAlphabetImagesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_alphabet_images);

        ImageView firstImageView = this.findViewById(R.id.imagesActivity_firstImageView);
        TextView firstTextView = this.findViewById(R.id.imagesActivity_firstTextView);

        ImageView secondImageView = this.findViewById(R.id.imagesActivity_secondImageView);
        TextView secondTextView = this.findViewById(R.id.imagesActivity_secondTextView);

        ImageView thirdImageView = this.findViewById(R.id.imagesActivity_thirdImageView);
        TextView thirdTextView = this.findViewById(R.id.imagesActivity_thirdTextView);

        String alphabet = this.getIntent().getStringExtra("alphabet");
        Map<String, Integer> imagesMap = this.getAlphabetImagesIds(alphabet);
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(imagesMap.entrySet());

        firstTextView.setText(entries.get(0).getKey());
        firstImageView.setImageResource(entries.get(0).getValue());

        secondTextView.setText(entries.get(1).getKey());
        secondImageView.setImageResource(entries.get(1).getValue());

        thirdTextView.setText(entries.get(2).getKey());
        thirdImageView.setImageResource(entries.get(2).getValue());
    }

    private Map<String, Integer> getAlphabetImagesIds(String alphabet) {
        // using reflection to dynamically load the images from drawable
        // key is the name of the image
        // value is the id
        Map<String, Integer> imagesMap = new HashMap<>();
        Field[] fields = R.drawable.class.getFields();
        String imagePrefix = "alphabet_image_" + alphabet.toLowerCase();

        int limit = 3; // to limit the number of retrieved pictures

        for (Field field : fields) {
            if (imagesMap.size() > limit)
                break;
            String fieldName = field.getName();
            if (fieldName.startsWith(imagePrefix)) {
                // removing prefix
                String imageName = this.capitalize(fieldName.substring(fieldName.lastIndexOf("_") + 1));
                Integer id = this.getResources().getIdentifier(
                        fieldName, "drawable", this.getPackageName()
                );
                imagesMap.put(imageName, id);
            }
        }
        return imagesMap;
    }

    private String capitalize(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }


}