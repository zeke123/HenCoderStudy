package com.zhoujian.javathread;

public class Synchronized3Demo implements TestDemo {

    private int x = 0;
    private int y = 0;
    private String name;
    private final Object monitor1 = new Object();
    //monitor:监视器
    //被监视器监视的方法，同一时间只能有一个线程来访问
    private final Object monitor2 = new Object();


    /**
     * synchronized:互斥访问的本质
     * 本质上是:保护方法内部的资源,保证数据的安全性
     * <p>
     * synchronized 如果都写在方法上，只有一个监视器，默认是当前类对象
     * 这个监视器监视下的方法，同一时间只能有一个线程可以访问
     */

    private void count(int newValue) {
        synchronized (monitor1) {
            x = newValue;
            y = newValue;
        }
    }

    /**
     * synchronized 代码块可以使用不同的监视器
     */
    private void minus(int delta) {
        synchronized (monitor1) {
            x -= delta;
            y -= delta;
        }
    }

    private void setName(String newName) {
        synchronized (monitor2) {
            name = newName;
        }
    }

    @Override
    public void runTest() {

    }

    /**
     * 死锁：多重锁嵌套可能引起死锁
     *
     *
     * 与线程无关，主要用于数据库方面
     * 乐观锁：
     * 悲观锁
     */
}
