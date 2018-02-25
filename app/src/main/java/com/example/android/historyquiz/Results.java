package com.example.android.historyquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Results extends AppCompatActivity {

    int points;
    int result;

    TextView results;
    TextView correct;
    TextView percent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        String person = getIntent().getStringExtra("NAME");
        String score = getIntent().getStringExtra("SCORE");
        points = Integer.parseInt(String.valueOf(score));

        results = findViewById(R.id.results);
        correct = findViewById(R.id.correct);
        percent = findViewById(R.id.percent);

        result = points * 100 / 10;
        percent.setText(String.valueOf(result) + "%");

        if (points == 10) {
            results.setText("You did outstanding, " + person + ".");
        }
        else if  (points >= 8) {
            results.setText("You did good, " + person + ".");
        }
        else if  (points >= 6) {
            results.setText("You did ok, " + person + ".");
        }
        else {
            results.setText("Not so good, " + person + ".");
        }

        correct.setText(points + " out of 10 correct.");
    }
}
