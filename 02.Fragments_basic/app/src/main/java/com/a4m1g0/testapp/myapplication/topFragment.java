package com.a4m1g0.testapp.myapplication;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class topFragment extends Fragment {
    private String TAG = "topFragment";

    private EditText testInput1;
    private EditText testInput2;

    TopFragmentListener activityCommander;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (!(context instanceof Activity))
            return;

        try {
            activityCommander = (TopFragmentListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_top, container, false);

        testInput1 = (EditText) view.findViewById(R.id.edit1);
        testInput2 = (EditText) view.findViewById(R.id.edit2);
        final Button button = (Button) view.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked(v);
            }
        });

        return view;
    }

    private void buttonClicked(View v) {
        if (activityCommander != null)
            activityCommander.printText(testInput1.getText().toString(), testInput2.getText().toString());
        else
            Log.e(TAG, "activity not assigned");

    }

    interface TopFragmentListener {
        void printText(String text1, String text2);
    }
}
