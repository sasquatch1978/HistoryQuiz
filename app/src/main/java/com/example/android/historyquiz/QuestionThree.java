package com.example.android.historyquiz;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class QuestionThree extends Fragment {

    static String SUBMIT_THREE = "submit_three";
    Button submitQ3;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate question three.
        View view = inflater.inflate(R.layout.question_three, container, false);

        // Submit button.
        submitQ3 = view.findViewById(R.id.submitQ3);

        // Restore the submit button state after rotation.
        if (savedInstanceState != null) {
            submitQ3.setEnabled(savedInstanceState.getBoolean(SUBMIT_THREE));
        }

        // Set the submit button to the disabled text color.
        if (!submitQ3.isEnabled()) {
            submitQ3.setTextColor(getResources().getColor(R.color.disabledButtonText));
        }

        setRetainInstance(true);
        return view;
    }

    // Saves the submit button state for rotation.
    @Override
    public void onSaveInstanceState(Bundle outState) {
        // Save custom values into the bundle.
        outState.putBoolean(SUBMIT_THREE, submitQ3.isEnabled());
        // Always call the superclass so it can save the view hierarchy state.
        super.onSaveInstanceState(outState);
    }
}

