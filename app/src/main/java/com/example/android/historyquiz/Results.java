package com.example.android.historyquiz;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Results extends AppCompatActivity {

    String person;

    TextView correct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        int points;
        int result;

        // Gets info from other activities.
        person = getIntent().getStringExtra("NAME");
        String score = getIntent().getStringExtra("SCORE");
        points = Integer.parseInt(String.valueOf(score));

        // TextViews
        TextView results = findViewById(R.id.results);
        TextView percent = findViewById(R.id.percent);
        correct = findViewById(R.id.correct);

        // Calculate percentage for number correct.
        result = points * 100 / 10;

        // Progress Bar
        percent.setText(result + "%"); // Percentage text
        correct.setText(points + " out of 10 correct."); // Number correct
        Resources res = getResources();
        Drawable drawable = res.getDrawable(R.drawable.circular);
        final ProgressBar mProgress = findViewById(R.id.circularProgressbar);
        mProgress.setProgress(result);  // Main Progress
        mProgress.setSecondaryProgress(100); // Secondary Progress
        mProgress.setMax(100); // Maximum Progress
        mProgress.setProgressDrawable(drawable);

        // Tells user how they did.
        if (points == 10) {
            results.setText("Outstanding, " + person + "!");
        } else if (points >= 8) {
            results.setText("Good job, " + person + "!");
        } else if (points >= 6) {
            results.setText("You did ok, " + person + ".");
        } else {
            results.setText("Not so good, " + person + ".");
        }
    }

    // Disable back button.
    @Override
    public void onBackPressed() {
        // Display message.
        Toast toast = Toast.makeText(this, "No need to go back.", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 585);
        toast.show();
    }

    // Restarts quiz.
    public void reset(View v) {
        Intent intent = new Intent(this, Quiz.class);
        intent.putExtra("NAME", person);
        Toast toast = Toast.makeText(this, "Good luck, " + person + ".", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 585);
        toast.show();
        startActivity(intent);
    }

    // Share with Google+.
    public void share(View v) {
        Intent shareIntent = ShareCompat.IntentBuilder.from(Results.this)
                .setType("text/plain")
                .setText("On The World History Quiz I got, " + correct.getText().toString())
                .getIntent()
                .setPackage("com.google.android.apps.plus");
        if (shareIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(shareIntent);
        }
    }
}


