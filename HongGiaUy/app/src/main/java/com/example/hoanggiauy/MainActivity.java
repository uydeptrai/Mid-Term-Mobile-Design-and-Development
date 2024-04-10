package com.example.hoanggiauy;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.hoanggiauy.DetailsActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button buttonTrue, buttonFalse, buttonSubmit;
    private ImageButton buttonLeftArrow, buttonRightArrow;

    private String[] questions = {
            "Tôi là IronMan",
            "Tôi là Thor",
            "Tôi là Hulk",
    };

    private int currentQuestionIndex = 0;

    // Danh sách để lưu trữ các câu trả lời
    private ArrayList<String> answersList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        buttonTrue = findViewById(R.id.buttonTrue);
        buttonFalse = findViewById(R.id.buttonFalse);
        buttonLeftArrow = findViewById(R.id.buttonLeftArrow);
        buttonRightArrow = findViewById(R.id.buttonRightArrow);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        displayCurrentQuestion();

        buttonLeftArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentQuestionIndex > 0) {
                    currentQuestionIndex--;
                    displayCurrentQuestion();
                }
            }
        });

        buttonRightArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentQuestionIndex < questions.length - 1) {
                    currentQuestionIndex++;
                    displayCurrentQuestion();
                }
            }
        });

        buttonTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Thêm câu trả lời vào danh sách
                answersList.add("True");
                buttonTrue.setBackgroundColor(getResources().getColor(R.color.colorTrue));
                new android.os.Handler().postDelayed(
                        new Runnable() {
                            public void run() {
                                buttonTrue.setBackgroundColor(getResources().getColor(android.R.color.holo_purple));
                            }
                        },
                        500
                );
            }
        });

        buttonFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Thêm câu trả lời vào danh sách
                answersList.add("False");
                buttonFalse.setBackgroundColor(getResources().getColor(R.color.colorFalse));
                new android.os.Handler().postDelayed(
                        new Runnable() {
                            public void run() {
                                buttonFalse.setBackgroundColor(getResources().getColor(android.R.color.holo_purple));
                            }
                        },
                        500
                );
            }
        });

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                // Truyền danh sách câu trả lời sang DetailsActivity
                intent.putStringArrayListExtra("answersList", answersList);
                startActivity(intent);
            }
        });
    }

    private void displayCurrentQuestion() {
        if (currentQuestionIndex >= 0 && currentQuestionIndex < questions.length) {
            textView.setText(questions[currentQuestionIndex]);
        }
    }
}
