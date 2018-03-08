package com.example.android.historyquiz;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class QuestionSeven extends Fragment {

    static String SUBMIT_SEVEN = "submit_seven";
    Button submitQ7;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate question seven.
        View view = inflater.inflate(R.layout.question_seven, container, false);

        // Submit button.
        submitQ7 = view.findViewById(R.id.submitQ7);

        // Restore the submit button state after rotation.
        if (savedInstanceState != null) {
            submitQ7.setEnabled(savedInstanceState.getBoolean(SUBMIT_SEVEN));
        }

        // Set the submit button to the disabled text color.
        if (!submitQ7.isEnabled()) {
            submitQ7.setTextColor(getResources().getColor(R.color.disabledButtonText));
        }

        setRetainInstance(true);
        return view;
    }

    // Saves the submit button state for rotation.
    @Override
    public void onSaveInstanceState(Bundle outState) {
        // Save custom values into the bundle.
        outState.putBoolean(SUBMIT_SEVEN, submitQ7.isEnabled());
        // Always call the superclass so it can save the view hierarchy state.
        super.onSaveInstanceState(outState);
    }
}
