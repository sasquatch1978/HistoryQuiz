package com.example.android.historyquiz;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Quiz extends AppCompatActivity {

    static String QUIZ_POINTS = "quiz_points";
    int score = 0;
    String name;
    ViewPager pager;
    TextView totalPoints;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme); // Sets the theme back to the app theme, each new activity uses splash theme.
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.quiz);

        // Gets info from other activities.
        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        name = bundle.getString("NAME");

        // Hides the keyboard until it is needed.
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        // View pager.
        CustomPagerAdapter adapter = new CustomPagerAdapter(this);
        pager = findViewById(R.id.pager);
        pager.setOffscreenPageLimit(10);
        pager.setAdapter(adapter);

        // Score TextView.
        totalPoints = findViewById(R.id.points);
    }

    // Saves the score for rotation.
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        // Save custom values into the bundle.
        savedInstanceState.putInt(QUIZ_POINTS, score);
        // Always call the superclass so it can save the view hierarchy state.
        super.onSaveInstanceState(savedInstanceState);
    }

    // Retrieves the score after rotation.
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy. //
        super.onRestoreInstanceState(savedInstanceState);
        // Restore state members from saved instance. //
        score = savedInstanceState.getInt(QUIZ_POINTS);
        totalPoints.setText(String.valueOf(score));
    }

    // Disable back button.
    @Override
    public void onBackPressed() {
        // Display message.
        Toast toast = Toast.makeText(this, R.string.noBack, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 585);
        toast.show();
    }

    // Advance the ViewPager one item with a 20 second delay.
    private void advancePager() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                pager.setCurrentItem(pager.getCurrentItem() + 1, true);
            }
        }, 2000);
    }

    // Display a toast if no radio button is selected.
    private void selectAnswer() {
        // Display message.
        Toast toast = Toast.makeText(this, R.string.selectAnswer, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 585);
        toast.show();
    }

    // Display a toast if two checkboxes aren't selected.
    private void twoAnswers() {
        // Display message.
        Toast toast = Toast.makeText(this, R.string.twoAnswers, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 585);
        toast.show();
    }

    // Display a toast if the answer is correct and increase the score one point.
    private void correct() {
        // Display message.
        Toast toast = Toast.makeText(this, R.string.correct, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 585);
        toast.show();

        //Increase the score
        score += 1;
        totalPoints.setText(String.valueOf(score));
    }

    // Question one.
    public void setQ1(View view) {
        RadioGroup q1 = findViewById(R.id.q1);
        RadioButton q1b = findViewById(R.id.q1b);

        // Correct answer.
        if (q1b.isChecked()) {
            // Display message and increase score.
            correct();
        }

        // Do nothing until an answer is entered.
        else if (q1.getCheckedRadioButtonId() == -1) {
            // Display message.
            selectAnswer();
            return;
        }

        // Wrong answer.
        else {
            // Display message.
            Toast toast = Toast.makeText(this, R.string.oneWrong, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 585);
            toast.show();
        }

        // Disable the submit button.
        Button submitQ1 = findViewById(R.id.submitQ1);
        submitQ1.setEnabled(false);
        submitQ1.setTextColor(getResources().getColor(R.color.disabledButtonText));

        // Advance to next question.
        advancePager();
    }

    // Question two.
    public void setQ2(View view) {
        RadioGroup q2 = findViewById(R.id.q2);
        RadioButton q2c = findViewById(R.id.q2c);

        // Correct answer.
        if (q2c.isChecked()) {
            // Display message and increase score.
            correct();
        }

        // Do nothing until an answer is entered.
        else if (q2.getCheckedRadioButtonId() == -1) {
            // Display message.
            selectAnswer();
            return;
        }

        // Wrong answer.
        else {
            // Display message.
            Toast toast = Toast.makeText(this, R.string.twoWrong, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 585);
            toast.show();
        }

        // Disable the submit button.
        Button submitQ2 = findViewById(R.id.submitQ2);
        submitQ2.setEnabled(false);
        submitQ2.setTextColor(getResources().getColor(R.color.disabledButtonText));

        // Advance to next question.
        advancePager();
    }

    // Question three.
    public void setQ3(View view) {
        RadioGroup q3 = findViewById(R.id.q3);
        RadioButton q3a = findViewById(R.id.q3a);

        // Correct answer.
        if (q3a.isChecked()) {
            // Display message and increase score.
            correct();
        }

        // Do nothing until an answer is entered.
        else if (q3.getCheckedRadioButtonId() == -1) {
            // Display message.
            selectAnswer();
            return;
        }

        // Wrong answer.
        else {
            // Display message.
            Toast toast = Toast.makeText(this, R.string.threeWrong, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 585);
            toast.show();
        }

        // Disable the submit button.
        Button submitQ3 = findViewById(R.id.submitQ3);
        submitQ3.setEnabled(false);
        submitQ3.setTextColor(getResources().getColor(R.color.disabledButtonText));

        // Advance to next question.
        advancePager();
    }

    // Question four.
    public void setQ4(View view) {
        CheckBox q4a = findViewById(R.id.q4a);
        CheckBox q4b = findViewById(R.id.q4b);
        CheckBox q4c = findViewById(R.id.q4c);
        CheckBox q4d = findViewById(R.id.q4d);

        int checkBoxSum = 0;

        if (q4a.isChecked()) {
            checkBoxSum += 2;
        }

        if (q4b.isChecked()) {
            checkBoxSum += 4;
        }

        if (q4c.isChecked()) {
            checkBoxSum += 8;
        }

        if (q4d.isChecked()) {
            checkBoxSum += 16;
        }

        // Calculate which boxes are checked.
        String checkBoxAnswer = "" + checkBoxSum;

        // Correct answer.
        if (checkBoxAnswer.equals("10")) {
            // Display message and increase score.
            correct();
        }

        // Do nothing until two answers are entered.
        else if (checkBoxAnswer.equals("0") || checkBoxAnswer.equals("2") || checkBoxAnswer.equals("4") || checkBoxAnswer.equals("8") || checkBoxAnswer.equals("16")) {
            // Display message.
            twoAnswers();
            return;
        }

        // Wrong answer.
        else {
            // Display message.
            Toast toast = Toast.makeText(this, R.string.fourWrong, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 585);
            toast.show();
        }

        // Disable the submit button.
        Button submitQ4 = findViewById(R.id.submitQ4);
        submitQ4.setEnabled(false);
        submitQ4.setTextColor(getResources().getColor(R.color.disabledButtonText));

        // Advance to next question.
        advancePager();
    }

    // Question five.
    public void setQ5(View view) {
        RadioGroup q5 = findViewById(R.id.q5);
        RadioButton q5b = findViewById(R.id.q5b);

        // Correct answer.
        if (q5b.isChecked()) {
            // Display message and increase score.
            correct();
        }

        // Do nothing until an answer is entered.
        else if (q5.getCheckedRadioButtonId() == -1) {
            // Display message.
            selectAnswer();
            return;
        }

        // Wrong answer.
        else {
            // Display message.
            Toast toast = Toast.makeText(this, R.string.fiveWrong, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 585);
            toast.show();
        }

        // Disable the submit button.
        Button submitQ5 = findViewById(R.id.submitQ5);
        submitQ5.setEnabled(false);
        submitQ5.setTextColor(getResources().getColor(R.color.disabledButtonText));

        // Advance to next question.
        advancePager();
    }

    // Question six.
    public void setQ6(View view) {
        CheckBox q6a = findViewById(R.id.q6a);
        CheckBox q6b = findViewById(R.id.q6b);
        CheckBox q6c = findViewById(R.id.q6c);
        CheckBox q6d = findViewById(R.id.q6d);

        int checkBoxSum = 0;

        if (q6a.isChecked()) {
            checkBoxSum += 2;
        }

        if (q6b.isChecked()) {
            checkBoxSum += 4;
        }

        if (q6c.isChecked()) {
            checkBoxSum += 8;
        }

        if (q6d.isChecked()) {
            checkBoxSum += 16;
        }

        // Calculate which boxes are checked.
        String checkBoxAnswer = "" + checkBoxSum;

        // Correct answer.
        if (checkBoxAnswer.equals("18")) {
            // Display message and increase score.
            correct();
        }

        // Do nothing until two answers are entered.
        else if (checkBoxAnswer.equals("0") || checkBoxAnswer.equals("2") || checkBoxAnswer.equals("4") || checkBoxAnswer.equals("8") || checkBoxAnswer.equals("16")) {
            // Display message.
            twoAnswers();
            return;
        }

        // Wrong answer.
        else {
            // Display message.
            Toast toast = Toast.makeText(this, R.string.sixWrong, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 585);
            toast.show();
        }

        // Disable the submit button.
        Button submitQ6 = findViewById(R.id.submitQ6);
        submitQ6.setEnabled(false);
        submitQ6.setTextColor(getResources().getColor(R.color.disabledButtonText));

        // Advance to next question.
        advancePager();
    }

    // Question seven.
    public void setQ7(View view) {
        RadioGroup q7 = findViewById(R.id.q7);
        RadioButton q7a = findViewById(R.id.q7a);

        // Correct answer.
        if (q7a.isChecked()) {
            // Display message and increase score.
            correct();
        }

        // Do nothing until an answer is entered.
        else if (q7.getCheckedRadioButtonId() == -1) {
            // Display message.
            selectAnswer();
            return;
        }

        // Wrong answer.
        else {
            // Display message.
            Toast toast = Toast.makeText(this, R.string.sevenWrong, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 585);
            toast.show();
        }

        // Disable the submit button.
        Button submitQ7 = findViewById(R.id.submitQ7);
        submitQ7.setEnabled(false);
        submitQ7.setTextColor(getResources().getColor(R.color.disabledButtonText));

        // Advance to next question.
        advancePager();
    }

    // Question eight.
    public void setQ8(View view) {
        EditText q8Answer;
        q8Answer = findViewById(R.id.q8answer);
        String answer = q8Answer.getText().toString();

        // Correct answer.
        if (answer.equals(getString(R.string.eightAnswer))) {
            // Display message and increase score.
            correct();
        }

        // Do nothing until an answer is entered.
        else if (answer.equals("")) {
            // Display message.
            Toast toast = Toast.makeText(this, R.string.enterAnswer, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 585);
            toast.show();
            return;
        }

        // Wrong answer.
        else {
            // Display message.
            Toast toast = Toast.makeText(this, R.string.eightWrong, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 585);
            toast.show();
        }

        // Disable the submit button.
        Button submitQ8 = findViewById(R.id.submitQ8);
        submitQ8.setEnabled(false);
        submitQ8.setTextColor(getResources().getColor(R.color.disabledButtonText));

        // Advance to next question.
        advancePager();
    }

    // Question nine.
    public void setQ9(View view) {
        RadioGroup q9 = findViewById(R.id.q9);
        RadioButton q9c = findViewById(R.id.q9c);

        // Correct answer.
        if (q9c.isChecked()) {
            // Display message and increase score.
            correct();
        }

        // Do nothing until an answer is entered.
        else if (q9.getCheckedRadioButtonId() == -1) {
            // Display message.
            selectAnswer();
            return;
        }

        // Wrong answer.
        else {
            // Display message.
            Toast toast = Toast.makeText(this, R.string.nineWrong, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 585);
            toast.show();
        }

        // Disable the submit button.
        Button submitQ9 = findViewById(R.id.submitQ9);
        submitQ9.setEnabled(false);
        submitQ9.setTextColor(getResources().getColor(R.color.disabledButtonText));

        // Advance to next question.
        advancePager();
    }

    // Question ten.
    public void setQ10(View view) {
        RadioGroup q10 = findViewById(R.id.q10);
        RadioButton q10d = findViewById(R.id.q10d);

        // Correct answer.
        if (q10d.isChecked()) {
            // Display message and increase score.
            correct();
        }

        // Do nothing until an answer is entered.
        else if (q10.getCheckedRadioButtonId() == -1) {
            // Display message.
            selectAnswer();
            return;
        }

        // Wrong answer.
        else {
            // Display message.
            Toast toast = Toast.makeText(this, R.string.tenWrong, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 585);
            toast.show();
        }

        // Disable the submit button.
        Button submitQ10 = findViewById(R.id.submitQ10);
        submitQ10.setEnabled(false);
        submitQ10.setTextColor(getResources().getColor(R.color.disabledButtonText));

        // Advance to Results.
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Quiz.this, Results.class);
                intent.putExtra("SCORE", String.valueOf(score));
                intent.putExtra("NAME", name);
                startActivity(intent);
            }
        }, 2000);
    }
}
