package com.zhangll.livy.httpclient;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class ScheduleThreadPoolDemo {
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static void main(String[] args) {
        //        executorService
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2,
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread thread = new Thread(r, "HttpClient -");
                        System.out.println("factory: "+ Thread.currentThread() + Thread.currentThread().hashCode() + "      "+ sdf.format(new Date()));
                        thread.setDaemon(true);
                        return thread;
                    }
                });


        System.out.println(sdf.format(new Date()));
        scheduledExecutorService.schedule(() -> {
            System.out.println("name: " + Thread.currentThread().hashCode() + "      "+ sdf.format(new Date()));
        }, 1, TimeUnit.SECONDS);
        scheduledExecutorService.schedule(() -> {
            System.out.println("name: " + Thread.currentThread().hashCode() + "      "+ sdf.format(new Date()));
        }, 2, TimeUnit.SECONDS);

        // 提交任务
        System.out.println("1111");
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
