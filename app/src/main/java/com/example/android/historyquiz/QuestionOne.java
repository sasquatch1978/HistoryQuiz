package com.example.android.historyquiz;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class QuestionOne extends Fragment {

    static String SUBMIT_ONE = "submit_one";
    Button submitQ1;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate question one.
        View view = inflater.inflate(R.layout.question_one, container, false);

        // Submit button.
        submitQ1 = view.findViewById(R.id.submitQ1);

        // Restore the submit button state after rotation.
        if (savedInstanceState != null) {
            submitQ1.setEnabled(savedInstanceState.getBoolean(SUBMIT_ONE));
        }

        // Set the submit button to the disabled text color.
        if (!submitQ1.isEnabled()) {
            submitQ1.setTextColor(getResources().getColor(R.color.disabledButtonText));
        }

        setRetainInstance(true);
        return view;
    }

    // Saves the submit button state for rotation.
    @Override
    public void onSaveInstanceState(Bundle outState) {
        // Save custom values into the bundle.
        outState.putBoolean(SUBMIT_ONE, submitQ1.isEnabled());
        // Always call the superclass so it can save the view hierarchy state.
        super.onSaveInstanceState(outState);
    }
}
