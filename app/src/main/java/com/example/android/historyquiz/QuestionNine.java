package com.example.android.historyquiz;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class QuestionNine extends Fragment {

    static String SUBMIT_NINE = "submit_nine";
    Button submitQ9;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate question nine.
        View view = inflater.inflate(R.layout.question_nine, container, false);

        // Submit button.
        submitQ9 = view.findViewById(R.id.submitQ9);

        // Restore the submit button state after rotation.
        if (savedInstanceState != null) {
            submitQ9.setEnabled(savedInstanceState.getBoolean(SUBMIT_NINE));
        }

        // Set the submit button to the disabled text color.
        if (!submitQ9.isEnabled()) {
            submitQ9.setTextColor(getResources().getColor(R.color.disabledButtonText));
        }

        setRetainInstance(true);
        return view;
    }

    // Saves the submit button state for rotation.
    @Override
    public void onSaveInstanceState(Bundle outState) {
        // Save custom values into the bundle.
        outState.putBoolean(SUBMIT_NINE, submitQ9.isEnabled());
        // Always call the superclass so it can save the view hierarchy state.
        super.onSaveInstanceState(outState);
    }
}
