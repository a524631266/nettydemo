package com.zhangll.livy.httpclient;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

public class TestThreadLocalDemo {
    static class ThreadId{
        static final AtomicLong nextId = new AtomicLong(0);
        // 同一个线程只要会初始化一次
        static final ThreadLocal<Long> tl = ThreadLocal.withInitial(() -> {
            System.out.println(Thread.currentThread().getName() + ": init");
            return nextId.getAndIncrement();
        });
        public static long get(){
            return tl.get();
        }
    }

    public static void main(String[] args) {
//        ThreadId threadId = new ThreadId();
//        long l = threadId.get();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Thread thread = new Thread() {
            @Override
            public void run() {
                long l = ThreadId.get();
                System.out.println(currentThread().getName() + ":::L " + l);
            }
        };
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                long l = ThreadId.get();
                System.out.println(Thread.currentThread().getName() + ":::L " + l);
            }
        };
        executorService.submit(runnable1);
        executorService.submit(runnable1);
        executorService.submit(runnable1);
        executorService.submit(runnable1);

        executorService.shutdown();
    }
}
