package com.example.android.historyquiz;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class QuestionEight extends Fragment {

    static String SUBMIT_EIGHT = "submit_eight";
    Button submitQ8;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate question eight.
        View view = inflater.inflate(R.layout.question_eight, container, false);

        // Submit button.
        submitQ8 = view.findViewById(R.id.submitQ8);

        // Restore the submit button state after rotation.
        if (savedInstanceState != null) {
            submitQ8.setEnabled(savedInstanceState.getBoolean(SUBMIT_EIGHT));
        }

        // Set the submit button to the disabled text color.
        if (!submitQ8.isEnabled()) {
            submitQ8.setTextColor(getResources().getColor(R.color.disabledButtonText));
        }

        setRetainInstance(true);
        return view;
    }

    // Saves the submit button state for rotation.
    @Override
    public void onSaveInstanceState(Bundle outState) {
        // Save custom values into the bundle.
        outState.putBoolean(SUBMIT_EIGHT, submitQ8.isEnabled());
        // Always call the superclass so it can save the view hierarchy state.
        super.onSaveInstanceState(outState);
    }
}
