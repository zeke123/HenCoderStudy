package com.zhoujian.androidthread;

import android.util.Log;

public class WaitDemo implements TestDemo {


    private String sharedString;

    @Override
    public void runTest() {
        final Thread thread1 = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                printString();
            }
        };
        thread1.start();

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                initString();
            }
        };
        thread2.start();
    }


    private synchronized void printString() {
        while (sharedString == null) {
            try {
                wait();// 别人操作线程
                // wait()需要在synchronized里调用
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Log.i("Android-Thread", "String==" + sharedString);
    }

    private synchronized void initString() {
        sharedString = "测试数据";
        //notify(); 随机唤醒一个
        //notify() notifyAll() 需要在synchronized里调用
        notifyAll();//所有都唤醒
    }

    //join
    //yield


}