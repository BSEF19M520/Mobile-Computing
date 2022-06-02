package com.example.appforkids;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Stack;

public class ExamWithListViewActivity extends AppCompatActivity {

    List<ExamItem> examItems;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_with_list_view);

        int numberOfQuestions = getIntent().getIntExtra("numberOfQuestions", 0);
        examItems = this.randomlySelect(this.getAlphabetImagesIds(), numberOfQuestions);
        ExamItemAdapter adapter = new ExamItemAdapter(this, examItems);

        listView = findViewById(R.id.examActivityWithListView_listView);
        listView.setAdapter(adapter);

        Button submitButton = findViewById(R.id.examActivityWithListView_submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleSubmit();
            }
        });

    }

    private boolean validate() {
        for (int i = 0; i < examItems.size(); i++) {
            ExamItem examItem = (ExamItem) listView.getItemAtPosition(i);
            if (examItem.getSelectedAnswer() == null) {
                Toast.makeText(this,
                        "No option selected for question #" + (i+1)
                        , Toast.LENGTH_LONG).show();
                return false;
            }
        }
        return true;
    }

    private void handleSubmit() {
        if (validate()) {
            int score = 0;
            for (int i = 0; i < examItems.size(); i++) {
                ExamItem examItem = (ExamItem) listView.getItemAtPosition(i);
                View examItemView = listView.getChildAt(i);
                if (examItem.getSelectedAnswer().equalsIgnoreCase(examItem.getCorrectAnswer())) {
                    score++;
                } else {
                    examItemView.findViewById(examItem.getSelectedAnswerRadioButtonId())
                            .setBackgroundColor(this.getResources().getColor(R.color.red));
                }
                examItemView.findViewById(examItem.getCorrectAnswerRadioButtonId())
                        .setBackgroundColor(this.getResources().getColor(R.color.green));
            }
            String scoreText = "Score: " + score + "/" + examItems.size();
            ((TextView) this.findViewById(R.id.examActivityWithListView_scoreTextView)).setText(scoreText);
        }
    }


    private List<ExamItem> getAlphabetImagesIds() {
        // using reflection to dynamically load the images from drawable
        // key is the name of the image
        // value is the id
        List<ExamItem> list = new ArrayList<>();
        Field[] fields = R.drawable.class.getFields();
        String imagePrefix = "alphabet_image_";

        for (Field field : fields) {
            String fieldName = field.getName();
            if (fieldName.startsWith(imagePrefix)) {
                // removing prefix
                String imageName = this.capitalize(fieldName.substring(fieldName.lastIndexOf("_") + 1));
                int id = this.getResources().getIdentifier(
                        fieldName, "drawable", this.getPackageName()
                );
                list.add(new ExamItem(id, imageName));
            }
        }
        return list;
    }

    private List<ExamItem> randomlySelect(List<ExamItem> examItems, int limit) {
        if (limit >= examItems.size())
            return examItems;

        Random random = new Random();
        List<ExamItem> selectedItems = new LinkedList<>();

        for (int i = 0; i < limit; i++) {
            int randomIndex = random.nextInt(examItems.size());
            selectedItems.add(examItems.get(randomIndex));
            examItems.remove(randomIndex);
        }
        return selectedItems;
    }


    private String capitalize(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }

}