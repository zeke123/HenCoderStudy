package com.zhoujian.javathread;

public class Synchronized1Demo implements TestDemo {

    private int x = 0;
    private int y = 0;


    @Override
    public void runTest() {
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 1_000_000_000; i++) {
                    count(i);
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 1_000_000_000; i++) {
                    count(i);
                }
            }
        }.start();
    }


    /**
     * 线程切换
     * synchronized:让别的线程不能访问这个方法
     * 如果有线程正在执行 synchronized 的方法，其他线程过来会等待
     * 同一时间，只有一个线程能执行这个方法，保证方法访问的互斥性
     */
    private synchronized void count(int newValue) {
        x = newValue;
        //可能被切线程
        y = newValue;
        if (x != y) {
            System.out.println("x: " + x + ", y:" + y);
        }
    }
}
