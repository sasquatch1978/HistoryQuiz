package com.example.android.historyquiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements TextWatcher,
        CompoundButton.OnCheckedChangeListener {

    EditText name;
    TextView toastText;
    View layout;

    private CheckBox rem_username;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    private static final String PREF_NAME = "prefs";
    private static final String KEY_REMEMBER = "remember";
    private static final String KEY_USERNAME = "username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme); // Sets the theme back to the app theme after splash screen.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hides the keyboard when app opens until it is needed.
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        // Name EditText
        name = findViewById(R.id.name);

        // Remember user CheckBox.
        rem_username = findViewById(R.id.userCheck);

        // Custom Toast
        LayoutInflater inflater = getLayoutInflater();
        layout = inflater.inflate(R.layout.toast, (ViewGroup) findViewById(R.id.toast_layout_root));
        toastText = layout.findViewById(R.id.toastText);

        sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.apply();

        // Sets check mark on CheckBox to checked or unchecked based on last state.
        if (sharedPreferences.getBoolean(KEY_REMEMBER, false))
            rem_username.setChecked(true);
        else
            rem_username.setChecked(false);

        // Set the saved username to the name EditText.
        name.setText(sharedPreferences.getString(KEY_USERNAME, ""));

        // Creates the listeners.
        name.addTextChangedListener(this);
        rem_username.setOnCheckedChangeListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        managePrefs();
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    // This watches for the CheckBox to be checked or unchecked.
    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        managePrefs();
    }

    // Saves username based on whether CheckBox is checked or not.
    private void managePrefs() {
        if (rem_username.isChecked()) {
            editor.putString(KEY_USERNAME, name.getText().toString().trim());
            editor.putBoolean(KEY_REMEMBER, true);
            editor.apply();
        } else {
            editor.putBoolean(KEY_REMEMBER, false);
            editor.remove(KEY_USERNAME);
            editor.apply();
        }
    }

    // Start the quiz.
    public void begin(View v) {
        // Check to see if a name is entered.
        if (name.getText().toString().equals("")) {
            // Display message.
            toastText.setText(getString(R.string.enterName));
            Toast toast = new Toast(this);
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 585);
            toast.setView(layout);
            toast.show();
            return;
        }

        // Start the quiz activity.
        Intent intent = new Intent(this, Quiz.class);
        // Show a scoring info toast, delayed 1/10 of a second, when next activity starts.
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                toastText.setText(getString(R.string.scoreInfo, name.getText()));
                final Toast scoreToast = new Toast(getApplication());
                scoreToast.setDuration(Toast.LENGTH_LONG);
                scoreToast.setGravity(Gravity.CENTER, 0, 395);
                scoreToast.setView(layout);
                scoreToast.show();

                // Make the toast show for longer than usual.
                new CountDownTimer(6000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        scoreToast.show();
                    }

                    public void onFinish() {
                        scoreToast.cancel();
                    }
                }.start();
            }
        }, 100);

        startActivity(intent);
    }
}
