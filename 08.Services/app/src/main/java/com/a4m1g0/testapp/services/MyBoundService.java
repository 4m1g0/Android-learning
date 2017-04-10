package com.a4m1g0.testapp.services;

import android.app.Service;
import android.content.Intent;
import java.text.SimpleDateFormat;
import android.os.Binder;
import android.os.IBinder;
import android.text.style.LocaleSpan;

import java.util.Date;
import java.util.Locale;

public class MyBoundService extends Service {

    private final IBinder myBinder = new MyLocalBinder();

    public MyBoundService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }

    public String getCurrentTime() {
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss", Locale.ROOT);
        return df.format(new Date());
    }

    public class MyLocalBinder extends Binder {
        MyBoundService getService() {
            return MyBoundService.this;
        }
    }
}
