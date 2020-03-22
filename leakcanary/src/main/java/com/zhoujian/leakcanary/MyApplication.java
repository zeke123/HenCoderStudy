package com.zhoujian.leakcanary;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

import java.util.ArrayList;

public class MyApplication extends Application {

    ArrayList<Object> lackedViews = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }
}
