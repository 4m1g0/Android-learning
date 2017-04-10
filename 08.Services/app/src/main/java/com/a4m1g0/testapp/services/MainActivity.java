package com.a4m1g0.testapp.services;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView maintv;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        maintv = (TextView) findViewById(R.id.maintv);

        // INTENT SERVICE
        // Queue first action
        Intent intent = new Intent(getApplicationContext(), MyIntentService.class);
        intent.setAction(MyIntentService.ACTION_SAY_HELLO);
        intent.putExtra(MyIntentService.EXTRA_NAME, "Don Pepito");
        startService(intent);

        // Queue second action
        // This request will be queued until the service finish handling the first one
        intent = new Intent(getApplicationContext(), MyIntentService.class);
        intent.setAction(MyIntentService.ACTION_SAY_GOODBYE);
        intent.putExtra(MyIntentService.EXTRA_NAME, "Don Jose");
        startService(intent);

        // NORMAL SERVICE
        // This service will keep running forever in background.
        // If the app is killed it is also killed but system will restart it asap due to return START_STICKY; statement
        intent = new Intent(this, MyService.class);
        startService(intent);
    }

    public void buttonClick(View view) {
        maintv.setText("" + i++);
    }
}
