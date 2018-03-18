package com.example.android.historyquiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Results extends AppCompatActivity {

    String person;

    TextView correct;
    TextView toastText;
    View layout;

    SharedPreferences sharedPreferences;
    private static final String PREF_NAME = "prefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme); // Sets the theme back to the app theme, each new activity uses splash theme.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        int points;
        int result;

        // Retrieves name from shared preferences.
        sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        person = (sharedPreferences.getString("username", ""));

        // Retrieves score from intent.
        String score = getIntent().getStringExtra("SCORE");
        points = Integer.parseInt(String.valueOf(score));

        // TextViews
        TextView results = findViewById(R.id.results);
        TextView percent = findViewById(R.id.percent);
        correct = findViewById(R.id.correct);

        // Custom Toast
        LayoutInflater inflater = getLayoutInflater();
        layout = inflater.inflate(R.layout.toast, (ViewGroup) findViewById(R.id.toast_layout_root));
        toastText = layout.findViewById(R.id.toastText);

        // Calculate percentage for number correct.
        result = points * 100 / 14;

        // Progress Bar
        percent.setText(getString(R.string.percentCorrect, result)); // Percentage text
        correct.setText(getString(R.string.numberCorrect, points)); // Number correct
        Resources res = getResources();
        Drawable drawable = res.getDrawable(R.drawable.circular);
        final ProgressBar mProgress = findViewById(R.id.circularProgressbar);
        mProgress.setProgress(result);  // Main Progress
        mProgress.setSecondaryProgress(100); // Secondary Progress
        mProgress.setMax(100); // Maximum Progress
        mProgress.setProgressDrawable(drawable);

        // Tells user how they did.
        if (result == 100) {
            results.setText(getString(R.string.outstanding, person));
        } else if (result >= 80) {
            results.setText(getString(R.string.good, person));
        } else if (result >= 60) {
            results.setText(getString(R.string.ok, person));
        } else {
            results.setText(getString(R.string.notGood, person));
        }
    }

    // Restarts quiz.
    public void reset(View v) {
        // Return to quiz activity.
        Intent intent = new Intent(this, Quiz.class);
        // Delay toast 1/10 of a second, until next activity starts.
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                toastText.setText(getString(R.string.luckRetry, person));
                Toast toast = new Toast(getApplication());
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 585);
                toast.setView(layout);
                toast.show();
            }
        }, 100);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finish();
    }

    // Share with Google+.
    public void share(View v) {
        Intent shareIntent = ShareCompat.IntentBuilder.from(Results.this)
                .setType("text/plain")
                .setText(getString(R.string.shareMessage) + correct.getText().toString())
                .getIntent()
                .setPackage("com.google.android.apps.plus");
        if (shareIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(shareIntent);
        }
    }
}


