package com.zhangll.process;

import java.util.concurrent.atomic.AtomicBoolean;

public class TestProcess {

    public static void main(String[] args) {
        Process driverprocess = null;
        AtomicBoolean ab = new AtomicBoolean();
        boolean b = ab.compareAndSet(false, true);
        for (int i = 0; i < 100; i++) {
            b = ab.compareAndSet(false, true);
        }
        System.out.println(b);
    }
}
