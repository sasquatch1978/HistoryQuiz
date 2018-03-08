package com.example.android.historyquiz;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class QuestionTwo extends Fragment {

    static String SUBMIT_TWO = "submit_two";
    Button submitQ2;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate question two.
        View view = inflater.inflate(R.layout.question_two, container, false);

        // Submit button.
        submitQ2 = view.findViewById(R.id.submitQ2);

        // Restore the submit button state after rotation.
        if (savedInstanceState != null) {
            submitQ2.setEnabled(savedInstanceState.getBoolean(SUBMIT_TWO));
        }

        // Set the submit button to the disabled text color.
        if (!submitQ2.isEnabled()) {
            submitQ2.setTextColor(getResources().getColor(R.color.disabledButtonText));
        }

        setRetainInstance(true);
        return view;
    }

    // Saves the submit button state for rotation.
    @Override
    public void onSaveInstanceState(Bundle outState) {
        // Save custom values into the bundle.
        outState.putBoolean(SUBMIT_TWO, submitQ2.isEnabled());
        // Always call the superclass so it can save the view hierarchy state.
        super.onSaveInstanceState(outState);
    }
}
