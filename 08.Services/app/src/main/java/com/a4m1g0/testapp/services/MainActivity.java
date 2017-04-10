package com.a4m1g0.testapp.services;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView maintv;
    int i = 0;
    MyBoundService myBoundService;
    boolean isBound = false;

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


        // BOUND SERVICE
        intent = new Intent(this, MyBoundService.class);
        bindService(intent, myConnection, Context.BIND_AUTO_CREATE);
    }

    public void buttonClick(View view) {
        maintv.setText(String.format(Locale.ROOT, "%d", i++));
    }


    public void buttonClickBoundService(View view) {
        maintv.setText(myBoundService.getCurrentTime());
    }

    private ServiceConnection myConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyBoundService.MyLocalBinder binder = (MyBoundService.MyLocalBinder) service;

            myBoundService = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };
}
