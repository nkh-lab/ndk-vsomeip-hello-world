package com.example.vsomeiphelloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.system.ErrnoException;
import android.system.Os;
import android.util.Log;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("MainActivityJNI");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Android Studio reference example of calling a native method
        TextView tv = findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());

        init_vsomeip();

        startService(new Intent(this, ServiceVsomeipHelloWorldService.class));
        startService(new Intent(this, ServiceVsomeipHelloWorldClient.class));
    }

    public native String stringFromJNI();

    private void init_vsomeip() {
        File vsomeipBaseDir = new File(getCacheDir(), "vsomeip");
        vsomeipBaseDir.mkdir();

        try {
            Os.setenv("VSOMEIP_BASE_PATH", vsomeipBaseDir.getAbsolutePath() + "/", true);
        } catch (ErrnoException e) {
            e.printStackTrace();
        }

        Log.d(TAG, "vsomeipBaseDir: " + vsomeipBaseDir.getAbsolutePath());
        Log.d(TAG, "Os.getenv(\"VSOMEIP_BASE_PATH\"): " + Os.getenv("VSOMEIP_BASE_PATH"));
    }
}
