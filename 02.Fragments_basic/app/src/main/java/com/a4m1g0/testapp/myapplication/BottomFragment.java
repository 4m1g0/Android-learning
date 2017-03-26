package com.a4m1g0.testapp.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BottomFragment extends Fragment {

    TextView inputText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bottom, container, false);
        inputText = (TextView) view.findViewById(R.id.text1);

        return view;
    }

    public void setText(String text) {
        inputText.setText(text);
    }

}
