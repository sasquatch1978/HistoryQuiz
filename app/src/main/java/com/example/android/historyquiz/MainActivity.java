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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hides the keyboard when app opens until it is needed.
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        name = (EditText) findViewById(R.id.name);
    }

    public void begin (View v){
        String person = name.getText().toString();

        if (person.equals("")) {
            // Display message. //
            Toast toast = Toast.makeText(this, "Please Enter Your Name.", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 585);
            toast.show();
            // Exit method early. //
            return;
        }

        Intent intent = new Intent(this, Quiz.class);
        intent.putExtra("NAME", String.valueOf(person));
        Toast toast = Toast.makeText(this, "Good luck, " + person + ".", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 585);
        toast.show();
        startActivity(intent);
    }
}
