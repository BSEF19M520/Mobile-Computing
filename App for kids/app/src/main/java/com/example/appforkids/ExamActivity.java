package com.example.appforkids;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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

public class ExamActivity extends AppCompatActivity {

    final int QUESTIONS_LIMIT = 5;
    List<Map.Entry<String, Integer>> imagesList;
    List<Integer> correctOptionsNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);

        correctOptionsNumbers = new LinkedList<>();
        imagesList = this.randomlySelect(this.getAlphabetImagesIds());
        this.populate();
    }

    private boolean validate() {
        for (int questionNumber = 1; questionNumber <= QUESTIONS_LIMIT; questionNumber++) {
            int id = this.getResources().getIdentifier(
                    "examActivity_radioGroup" + questionNumber, "id", this.getPackageName()
            );
            if (((RadioGroup) this.findViewById(id)).getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "No option selected for question #" + questionNumber
                        , Toast.LENGTH_LONG).show();
                return false;
            }
        }
        return true;
    }

    private void handleSubmit() {
        if (validate()) {
            int correctAnswers = 0;
            for (int questionNumber = 1; questionNumber <= QUESTIONS_LIMIT; questionNumber++) {
                int radioGroupId = this.getResources().getIdentifier(
                        "examActivity_radioGroup" + questionNumber, "id", this.getPackageName()
                );
                int correctRadioButtonId = this.getResources().getIdentifier(
                        "examActivity_radioGroup" + questionNumber + "_radioButton" + this.correctOptionsNumbers.get(questionNumber - 1),
                        "id", this.getPackageName()
                );
                RadioButton selectedRadioButton = this.findViewById(((RadioGroup) this.findViewById(radioGroupId)).getCheckedRadioButtonId());
                RadioButton correctRadioButton = this.findViewById(correctRadioButtonId);
                if (correctRadioButton.getId() == selectedRadioButton.getId()) {
                    correctAnswers++;
                } else {
                    selectedRadioButton.setBackgroundColor(this.getResources().getColor(R.color.red));
                }
                correctRadioButton.setBackgroundColor(this.getResources().getColor(R.color.green));
            }
            String score = "Score: " + correctAnswers + "/" + QUESTIONS_LIMIT;
            ((TextView) this.findViewById(R.id.examActivity_scoreTextView)).setText(score);
        }
    }

    private void populate() {
        for (int questionNumber = 1; questionNumber <= QUESTIONS_LIMIT; questionNumber++) {
            int correctOptionNumber = this.getRandomCorrectOptionNumber();
            correctOptionsNumbers.add(correctOptionNumber);
            // setting image
            ((ImageView) this.findViewById(this.getResources().getIdentifier(
                    "examActivity_imageView" + questionNumber, "id", this.getPackageName()
            ))).setImageResource(imagesList.get(questionNumber - 1).getValue());

            // setting options
            Stack<String> randomWrongAnswers = this.getRandomWrongAnswers(imagesList.get(questionNumber - 1).getKey());
            for (int radioButtonNumber = 1; radioButtonNumber <= 4; radioButtonNumber++) {
                int id = this.getResources().getIdentifier(
                        "examActivity_radioGroup" + questionNumber + "_radioButton" + radioButtonNumber,
                        "id", this.getPackageName()
                );
                if (radioButtonNumber == correctOptionNumber) {
                    ((RadioButton) this.findViewById(id)).setText(imagesList.get(questionNumber - 1).getKey());
                } else {
                    ((RadioButton) this.findViewById(id)).setText(randomWrongAnswers.pop());
                }
            }
        }

        ((Button) this.findViewById(R.id.examActivity_submitButton)).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ExamActivity.this.handleSubmit();
                    }
                }
        );
    }

    private Stack<String> getRandomWrongAnswers(String correct) {
        List<String> options = new ArrayList<>();
        options.add("Aeroplane");
        options.add("Ball");
        options.add("Cat");
        options.add("Doll");
        options.add("Owl");
        options.add("Monkey");
        // removing if the correct option is in the list
        options.remove(correct);
        Stack<String> selectedWrongAnswers = new Stack<>();

        Random random = new Random();
        int limit = 3;
        for (int i = 0; i < limit; i++) {
            int randomIndex = random.nextInt(options.size());
            selectedWrongAnswers.add(options.get(randomIndex));
            options.remove(randomIndex);
        }
        return selectedWrongAnswers;
    }

    // returns which number of radio button will be the correct option assigned
    private int getRandomCorrectOptionNumber() {
        // range: [1, 4]
        return new Random().nextInt(4) + 1;
    }

    private Map<String, Integer> getAlphabetImagesIds() {
        // using reflection to dynamically load the images from drawable
        // key is the name of the image
        // value is the id
        Map<String, Integer> imagesMap = new HashMap<>();
        Field[] fields = R.drawable.class.getFields();
        String imagePrefix = "alphabet_image_";

        for (Field field : fields) {
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

    private List<Map.Entry<String, Integer>> randomlySelect(Map<String, Integer> imagesMap) {
        Random random = new Random();
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(imagesMap.entrySet());
        List<Map.Entry<String, Integer>> selectedEntries = new LinkedList<>();

        for (int i = 0; i < QUESTIONS_LIMIT; i++) {
            int randomIndex = random.nextInt(entries.size());
            selectedEntries.add(entries.get(randomIndex));
            entries.remove(randomIndex);
        }
        return selectedEntries;
    }


    private String capitalize(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }


}