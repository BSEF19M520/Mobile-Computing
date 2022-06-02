package com.example.appforkids;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class ExamItemAdapter extends ArrayAdapter<ExamItem> {
    public ExamItemAdapter(@NonNull Context context, @NonNull List<ExamItem> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ExamItem item = getItem(position);
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.exam_item, parent,
                false);
        ImageView imageView = convertView.findViewById(R.id.examItem_imageView);

        imageView.setImageResource(item.getImageId());
        int correctAnswerNumber = getRandomCorrectOptionNumber();
        Stack<String> wrongOptions = getRandomWrongAnswers(item.getCorrectAnswer());
        for (int i = 1; i <= 4; i++) {
            int radioButtonId = getContext().getResources().getIdentifier(
                    "examItem_radioButton" + i, "id", getContext().getPackageName());
            RadioButton radioButton = convertView.findViewById(radioButtonId);
            if (i == correctAnswerNumber) {
                radioButton.setText(item.getCorrectAnswer());
                item.setCorrectAnswerRadioButtonId(radioButtonId);
            }
            else
                radioButton.setText(wrongOptions.pop());

            radioButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    item.setSelectedAnswer(radioButton.getText().toString());
                    item.setSelectedAnswerRadioButtonId(view.getId());
                }
            });
        }

        return convertView;
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
}
