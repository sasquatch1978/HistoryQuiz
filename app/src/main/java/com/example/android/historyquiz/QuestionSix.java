package com.example.android.historyquiz;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class QuestionSix extends Fragment {

    static String SUBMIT_SIX = "submit_six";
    Button submitQ6;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate question six.
        View view = inflater.inflate(R.layout.question_six, container, false);

        // Submit button.
        submitQ6 = view.findViewById(R.id.submitQ6);

        // Restore the submit button state after rotation.
        if (savedInstanceState != null) {
            submitQ6.setEnabled(savedInstanceState.getBoolean(SUBMIT_SIX));
        }

        // Set the submit button to the disabled text color.
        if (!submitQ6.isEnabled()) {
            submitQ6.setTextColor(getResources().getColor(R.color.disabledButtonText));
        }

        setRetainInstance(true);
        return view;
    }

    // Saves the submit button state for rotation.
    @Override
    public void onSaveInstanceState(Bundle outState) {
        // Save custom values into the bundle.
        outState.putBoolean(SUBMIT_SIX, submitQ6.isEnabled());
        // Always call the superclass so it can save the view hierarchy state.
        super.onSaveInstanceState(outState);
    }
}
