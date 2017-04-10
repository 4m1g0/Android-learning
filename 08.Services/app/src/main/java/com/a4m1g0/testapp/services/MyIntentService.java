package com.a4m1g0.testapp.services;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.util.Log;

public class MyIntentService extends IntentService {
    public static final String TAG = "MyIntentService";

    public static final String ACTION_SAY_HELLO = "com.a4m1g0.testapp.services.action.SAY_HELLO";
    public static final String ACTION_SAY_GOODBYE = "com.a4m1g0.testapp.services.action.SAY_GOODBYE";

    public static final String EXTRA_NAME = "com.a4m1g0.testapp.services.extra.NAME";

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_SAY_GOODBYE.equals(action)) {
                final String name = intent.getStringExtra(EXTRA_NAME);
                handleActionGoodbye(name);
            } else if (ACTION_SAY_HELLO.equals(action)) {
                final String name = intent.getStringExtra(EXTRA_NAME);
                handleActionHello(name);
            }
        }
    }

    private void handleActionGoodbye(String name) {
        Log.i(TAG, "Good bye, " + name);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void handleActionHello(String name) {
        Log.i(TAG, "Hello, " + name);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
