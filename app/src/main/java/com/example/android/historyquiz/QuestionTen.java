package com.example.android.historyquiz;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class QuestionTen extends Fragment {

    static String SUBMIT_TEN = "submit_ten";
    Button submitQ10;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate question ten.
        View view = inflater.inflate(R.layout.question_ten, container, false);

        // Submit button.
        submitQ10 = view.findViewById(R.id.submitQ10);

        // Restore the submit button state after rotation.
        if (savedInstanceState != null) {
            submitQ10.setEnabled(savedInstanceState.getBoolean(SUBMIT_TEN));
        }

        // Set the submit button to the disabled text color.
        if (!submitQ10.isEnabled()) {
            submitQ10.setTextColor(getResources().getColor(R.color.disabledButtonText));
        }

        setRetainInstance(true);
        return view;
    }

    // Saves the submit button state for rotation.
    @Override
    public void onSaveInstanceState(Bundle outState) {
        // Save custom values into the bundle.
        outState.putBoolean(SUBMIT_TEN, submitQ10.isEnabled());
        // Always call the superclass so it can save the view hierarchy state.
        super.onSaveInstanceState(outState);
    }
}
