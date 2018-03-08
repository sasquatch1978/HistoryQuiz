package com.example.android.historyquiz;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class QuestionFive extends Fragment {

    static String SUBMIT_FIVE = "submit_five";
    Button submitQ5;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate question five.
        View view = inflater.inflate(R.layout.question_five, container, false);

        // Submit button.
        submitQ5 = view.findViewById(R.id.submitQ5);

        // Restore the submit button state after rotation.
        if (savedInstanceState != null) {
            submitQ5.setEnabled(savedInstanceState.getBoolean(SUBMIT_FIVE));
        }

        // Set the submit button to the disabled text color.
        if (!submitQ5.isEnabled()) {
            submitQ5.setTextColor(getResources().getColor(R.color.disabledButtonText));
        }

        setRetainInstance(true);
        return view;
    }

    // Saves the submit button state for rotation.
    @Override
    public void onSaveInstanceState(Bundle outState) {
        // Save custom values into the bundle.
        outState.putBoolean(SUBMIT_FIVE, submitQ5.isEnabled());
        // Always call the superclass so it can save the view hierarchy state.
        super.onSaveInstanceState(outState);
    }
}

