package com.zhangll.classloader.thread;

public class AlterLocalVarible {
    final static int Max = 5;
    static volatile int init_value = 0;

    public static void main(String[] args) {
        new Thread(() -> {
            // 此时
            while (init_value < Max) {
                init_value++;
                System.out.println("local init_value" + init_value);
            }
        }).start();

        new Thread(() -> {
            // 此时
            System.out.println(Thread.currentThread().getName() + " init_" + init_value);
            while (init_value < Max) {
                init_value++;
                System.out.println("local2 init_value" + init_value);
            }
        }).start();
    }
}
