package com.zhoujian.javathread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo implements TestDemo {
    private int x = 0;
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    /**
     * Lock 与 synchronized
     * Lock 必须手动unlock
     * 如果发生异常，Lock就不能被释放，就会出问题
     *
     *
     * ReentrantReadWriteLock: 读写锁在保证安全的情况下，提高性能
     */


    Lock readLock = lock.readLock();
    Lock writeLock = lock.writeLock();

    private void count() {
        writeLock.lock();
        try {
            x++;
        } finally {
            writeLock.unlock();
        }
    }

    private void print(int time) {
        readLock.lock();
        try {
            System.out.print(x + " ");
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public void runTest() {
    }
}