package com.zhoujian.javathread;

public class Synchronized2Demo implements TestDemo {


    private int x = 0;

    @Override
    public void runTest() {
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 1_000_000; i++) {
                    count();
                }
                System.out.println("final x from 1: " + x);
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 1_000_000; i++) {
                    count();
                }
                System.out.println("final x from 2: " + x);
            }
        }.start();
    }

    /**
     * synchronized 保证方法互斥性
     */
    private synchronized void count() {
        x++;
    }
}
