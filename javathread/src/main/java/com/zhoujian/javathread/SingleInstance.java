package com.zhoujian.javathread;

public class SingleInstance {

    private volatile static SingleInstance instance;

    private SingleInstance() {

    }

    public static SingleInstance getInstance() {
        if (instance == null) {
            synchronized (SingleInstance.class) {
                if (instance == null) {
                    instance = new SingleInstance();
                }
            }
        }
        return instance;
    }
}
