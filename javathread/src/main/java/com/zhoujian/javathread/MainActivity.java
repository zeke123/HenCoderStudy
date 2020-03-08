package com.zhoujian.javathread;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        thread();

//        runnable();
//        threadFactory();
//        executor();
//        callable();
        runSynchronized1Demo();
//        runSynchronized2Demo();
//        runSynchronized3Demo();
//        runReadWriteLockDemo();
    }

    /**
     * 使用 Thread 类来定义工作
     */
    private static void thread() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("Thread started!");
            }
        };
        // 开启线程  源码
        //native方法  与平台相关，与虚拟机交互
        thread.start();
        //线程与进程
        //进程里数据不共享，一个进程可以包含多个线程
        //线程之间共享资源

        //CPU线程和操作系统线程

    }

    /**
     * 使用 Runnable 类来定义工作
     */
    private static void runnable() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread with Runnable started!");
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        // Thread :重写Thread中的run方法
        // Runnable:重写Runnable中的run方法，可以重用
    }

    private static void threadFactory() {
        //线程工厂
        ThreadFactory factory = new ThreadFactory() {
            AtomicInteger count = new AtomicInteger(0);

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "Thread-" + count.incrementAndGet()); // ++count
            }
        };

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " started!");
            }
        };

        //创建一个线程
        Thread thread = factory.newThread(runnable);
        thread.start();
        Thread thread1 = factory.newThread(runnable);
        thread1.start();
    }

    private static void executor() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread with Runnable started!");
            }
        };

        Executor executor = Executors.newCachedThreadPool();
        //单个线程
        //Executors.newSingleThreadExecutor();
        //固定数量线程池
        //Executors.newFixedThreadPool();
        //可以设置时间
        Executors.newSingleThreadScheduledExecutor();

        //shutdownNow：直接结束所有线程
        //shutdown:如果有排队的，等排队执行完结束
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);

        BlockingDeque<Runnable> queue = new LinkedBlockingDeque<>(10000);

        ThreadPoolExecutor myExecutor = new ThreadPoolExecutor(5, 100, 5, TimeUnit.SECONDS, queue);
    }

    public static ExecutorService newCachedThreadPool() {
        //线程池
        // corePoolSize:默认大小
        return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
    }

    /**
     * 有返回值的Runnable
     */
    private static void callable() {
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() {
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "Done!";
            }
        };

        ExecutorService executor = Executors.newCachedThreadPool();
        Future<String> future = executor.submit(callable);

        try {
            //future.isDone();
            String result = future.get();
            System.out.println("result: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void runSynchronized1Demo() {
        new Synchronized1Demo().runTest();
    }

    private static void runSynchronized2Demo() {
        new Synchronized2Demo().runTest();
    }

    private static void runSynchronized3Demo() {
        new Synchronized3Demo().runTest();
    }

    private static void runReadWriteLockDemo() {
        new ReadWriteLockDemo().runTest();
    }
}
