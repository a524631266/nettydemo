package com.zhangll.livy.httpclient;

import java.util.concurrent.*;

public class TestThreadPool {
    public static void main(String[] args) {
//        ThreadPoolExecutor.AbortPolicy
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                while(true){
                    System.out.println("123");
                }
            }
        });
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                while(true){
                    System.out.println("4556");
                }
            }
        });

    }
}
