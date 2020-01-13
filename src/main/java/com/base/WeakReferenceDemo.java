package com.base;

import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

public class WeakReferenceDemo {
    public static void main(String[] args) throws InterruptedException {
        String s = new String("123");
        WeakReference<String> weak = new WeakReference<String>(s);
        // "123"这个对象有两个引用，一个强引用 s 变量（变量在栈中），另一个弱引用 weak变量（变量在栈中）
        // 只有s被设置成null的时候，该对象所指向的对象new String("123")就只有一个弱引用
        s = null;

        System.out.println("value:" + weak.get());
        // 当在下一次gc时候，会删除弱引用中的只有弱引用的对象
        System.gc();
        TimeUnit.SECONDS.sleep(10);
        System.out.println("value:" + weak.get());
    }
}
