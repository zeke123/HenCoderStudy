package com.zhoujian.pluginnable_plugin;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.Nullable;

import com.zhoujian.pluginbase.IRemoteActivity;

public class BaseActivity extends Activity implements IRemoteActivity {

    public Activity activity;

    @Override
    public void attach(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void setContentView(int layoutResID) {
        if (activity == null) {
            super.setContentView(layoutResID);
        } else {
            activity.setContentView(layoutResID);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

    }

    @Override
    public ClassLoader getClassLoader() {
        if (activity == null) {
            return super.getClassLoader();
        } else {
            return activity.getClassLoader();
        }
    }

    @Override
    public LayoutInflater getLayoutInflater() {
        if (activity == null) {
            return super.getLayoutInflater();
        } else {
            return activity.getLayoutInflater();
        }
    }


    @Override
    public WindowManager getWindowManager() {
        if (activity == null) {
            return super.getWindowManager();
        } else {
            return activity.getWindowManager();
        }
    }

    @Override
    public Window getWindow() {
        if (activity == null) {
            return super.getWindow();
        } else {
            return activity.getWindow();
        }
    }

    public void onCreate(@Nullable Bundle savedInstanceState) {
        if (activity == null) {
            super.onCreate(savedInstanceState);
        }
    }

    public void onStart() {
        if (activity == null) {
            super.onStart();
        }
    }

    public void onDestroy() {
        if (activity == null) {
            super.onDestroy();
        }
    }

    public void onPause() {
        if (activity == null) {
            super.onPause();
        }
    }

    public void onResume() {
        if (activity == null) {
            super.onResume();
        }
    }
}
