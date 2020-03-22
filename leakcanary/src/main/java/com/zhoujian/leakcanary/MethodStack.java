package com.zhoujian.leakcanary;

import android.os.SystemClock;

public class MethodStack implements Runnable {
    private Object ref;

    MethodStack(Object ref) {
        this.ref = ref;
    }

    static void startWithTarget(Object ref) {
        new Thread(new MethodStack(ref)).start();
    }

    @Override
    public void run() {
        Object ref = this.ref;
        this.ref = null;
        while (true) {
            SystemClock.sleep(100);
            System.out.println(ref);

        }
    }
}
