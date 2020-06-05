package com.example.vsomeiphelloworld;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class ServiceVsomeipHelloWorldClient extends Service {
    private static final String TAG = "ServiceVsomeipHelloWorldClient";

    public ServiceVsomeipHelloWorldClient() {
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d(TAG, "onCreate()");
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy()");

        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind()");

        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand()");

        System.loadLibrary("ServiceVsomeipHelloWorldClientJNI");

        Log.d(TAG, runNative());

        return START_REDELIVER_INTENT;
    }

    public native String runNative();
}

