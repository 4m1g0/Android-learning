package com.a4m1g0.testapp.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements topFragment.TopFragmentListener {
    private String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void printText(String text1, String text2) {
        Log.e(TAG, "Message received in mainActivity");
        BottomFragment botFragment = (BottomFragment) getSupportFragmentManager().findFragmentById(R.id.fragment2);

        botFragment.setText(text1 + " " + text2);
    }
}
