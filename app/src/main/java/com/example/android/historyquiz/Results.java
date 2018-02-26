package com.example.android.historyquiz;

import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Results extends AppCompatActivity {

    int points;
    int result;

    TextView results;
    TextView correct;
    TextView percent;

    private Handler handler = new Handler();

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
        } else if (points >= 8) {
            results.setText("You did good, " + person + ".");
        } else if (points >= 6) {
            results.setText("You did ok, " + person + ".");
        } else {
            results.setText("Not so good, " + person + ".");
        }

        correct.setText(points + " out of 10 correct.");

        // Progress Bar
        Resources res = getResources();
        Drawable drawable = res.getDrawable(R.drawable.circular);
        final ProgressBar mProgress = findViewById(R.id.circularProgressbar);
        mProgress.setProgress(result);  // Main Progress
        mProgress.setSecondaryProgress(100); // Secondary Progress
        mProgress.setMax(100); // Maximum Progress
        mProgress.setProgressDrawable(drawable);
        new Thread(new Runnable() {

            @Override
            public void run() {
                while (result < result) {
                    result += 1;

                    handler.post(new Runnable() {

                        @Override
                        public void run() {
                            mProgress.setProgress(result);
                            percent.setText(result + "%");

                        }
                    });
                    try {
                        Thread.sleep(8); // Thread will take approx 1.5 seconds to finish.
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
