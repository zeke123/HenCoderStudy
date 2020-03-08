package com.zhoujian.androidthread;

import android.os.Bundle;
import android.os.SystemClock;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        runThreadInteractionDemo();

        //不会被打断，不会抛异常
        //SystemClock.sleep(1000);
        runWaitDemo();
//        runCustomizableThreadDemo();







    }

    private void runThreadInteractionDemo() {
        new ThreadInteractionDemo().runTest();
    }

    private void runWaitDemo() {
        new WaitDemo().runTest();

    }

    private void runCustomizableThreadDemo() {
        new CustomizableThreadDemo().runTest();
    }
}
