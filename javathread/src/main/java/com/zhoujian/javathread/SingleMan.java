package com.zhoujian.javathread;

class SingleMan {

    /**
     * volatile:只能保证引用和基本类型的操作具有同步性
     * 保证 sInstance = new SingleMan()是原子操作
     */
    private static volatile SingleMan sInstance;

    private SingleMan() {
    }

    public static SingleMan newInstance() {
        if (sInstance == null) {
            //静态方法
            synchronized (SingleMan.class) {
                if (sInstance == null) {
                    //初始化没有完成，已经赋值了
                    sInstance = new SingleMan();
                }
            }
        }
        return sInstance;
    }


    /**
     * 有性能问题，每次都会被锁
     */
//    public synchronized static SingleMan newInstance() {
//        //静态方法
//        if (sInstance == null) {
//            sInstance = new SingleMan();
//        }
//        return sInstance;
//    }


}
