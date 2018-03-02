package com.example.android.historyquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme); // Sets the theme back to the app theme after splash screen.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hides the keyboard when app opens until it is needed.
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        // EditText
        name = findViewById(R.id.name);
    }

    // Start the quiz.
    public void begin (View v){
        String person = name.getText().toString();

        if (person.equals("")) {
            // Display message.
            Toast toast = Toast.makeText(this, R.string.enterName, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 585);
            toast.show();
            return;
        }

        Intent intent = new Intent(this, Quiz.class);
        intent.putExtra("NAME", String.valueOf(person));
        Toast toast = Toast.makeText(this, getString(R.string.luck, person), Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 585);
        toast.show();
        startActivity(intent);
    }
}
