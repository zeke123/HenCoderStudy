package com.zhoujian.genericitystudy;

//泛型类型
public class Wrapper<T> {
    private T instance;

    public T getInstance() {
        return instance;
    }

    public void setInstance(T instance) {
        this.instance = instance;
    }
}
