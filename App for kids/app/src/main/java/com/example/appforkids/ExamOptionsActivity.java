package com.example.appforkids;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ExamOptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_options);

        EditText editText = findViewById(R.id.examOptionsActivity_examItemsNumberPlainText);
        Button button = findViewById(R.id.examOptionsActivity_startExamButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString();
                if (text.length() == 0)
                    Toast.makeText(ExamOptionsActivity.this, "Please enter the number of questions",
                            Toast.LENGTH_SHORT).show();
                else {
                    int limit = Integer.parseInt(text);
                    if (limit == 0)
                        Toast.makeText(ExamOptionsActivity.this, "Number of questions must be > 0",
                                Toast.LENGTH_SHORT).show();
                    else {
                        Intent intent = new Intent(ExamOptionsActivity.this, ExamWithListViewActivity.class);
                        intent.putExtra("numberOfQuestions", limit);
                        ExamOptionsActivity.this.startActivity(intent);
                    }
                }
            }
        });
    }
}