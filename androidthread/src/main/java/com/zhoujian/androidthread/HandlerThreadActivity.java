package com.zhoujian.androidthread;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HandlerThreadActivity extends AppCompatActivity {

    private HandlerThread handlerThread;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //创建HandlerThread
        handlerThread = new HandlerThread("handlerThread");

        //开启线程
        handlerThread.start();

        //创建Handler对象
        Handler handler = new Handler(handlerThread.getLooper()) {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                //可以运行耗时操作
                Log.i("HandlerThreadActivity", "获取消息:" + msg.what);
                Log.i("HandlerThreadActivity", "线程名字:" + Thread.currentThread().getName());

            }
        };


        //在主线程发送消息
        handler.sendEmptyMessage(1);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (handlerThread != null) {
            handlerThread.quit();

        }
    }
}
