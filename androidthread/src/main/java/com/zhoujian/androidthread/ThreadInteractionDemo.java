package com.zhoujian.androidthread;

import android.util.Log;

public class ThreadInteractionDemo implements TestDemo {

    @Override
    public void runTest() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    //如果线程被标记为打断状态,直接return
                    //线程Thread的方法
                    //Thread.interrupted() 会重置打断状态
                    //isInterrupted() 不会重置

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        //发生InterruptedException异常 也会重置打断状态
                        e.printStackTrace();
                        //收尾
                        return;//手动终结
                    }

                    if (isInterrupted()) {
                        //收尾
                        return;//手动终结
                    }
                    Log.i("Android-Thread", "number==" + i);
                }
            }
        };
        //开启线程
        thread.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //被弃用了（太直接，太暴力，结果不可预期）
        //thread.stop();

        //代替者
        //把线程标记为被打断的状态,不是立即的，不是强制的
        thread.interrupt();

    }
}