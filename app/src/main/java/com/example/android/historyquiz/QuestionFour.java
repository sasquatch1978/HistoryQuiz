package com.example.android.historyquiz;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class QuestionFour extends Fragment {

    static String SUBMIT_FOUR = "submit_four";
    Button submitQ4;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate question four.
        View view = inflater.inflate(R.layout.question_four, container, false);

        // Submit button.
        submitQ4 = view.findViewById(R.id.submitQ4);

        // Restore the submit button state after rotation.
        if (savedInstanceState != null) {
            submitQ4.setEnabled(savedInstanceState.getBoolean(SUBMIT_FOUR));
        }

        // Set the submit button to the disabled text color.
        if (!submitQ4.isEnabled()) {
            submitQ4.setTextColor(getResources().getColor(R.color.disabledButtonText));
        }

        setRetainInstance(true);
        return view;
    }

    // Saves the submit button state for rotation.
    @Override
    public void onSaveInstanceState(Bundle outState) {
        // Save custom values into the bundle.
        outState.putBoolean(SUBMIT_FOUR, submitQ4.isEnabled());
        // Always call the superclass so it can save the view hierarchy state.
        super.onSaveInstanceState(outState);
    }
}

