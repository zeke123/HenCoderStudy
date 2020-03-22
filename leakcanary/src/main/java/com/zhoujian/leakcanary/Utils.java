package com.zhoujian.leakcanary;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.SystemClock;

import androidx.core.app.ActivityCompat;

import java.util.ArrayList;

public class Utils {

    public static ArrayList<Object> leakViews = new ArrayList<>();


    public static void requestPermission(Activity activity) {

        if (ActivityCompat.checkSelfPermission(activity,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);
        }

    }


    public static void gc() {

        new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("GC开始");

                SystemClock.sleep(100);

                System.out.println("GC结束");

            }
        }).start();


    }


}
