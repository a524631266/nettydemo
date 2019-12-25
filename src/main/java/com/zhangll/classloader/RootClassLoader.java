package com.zhangll.classloader;

/**
 * 纯C++写的，所以获取为null
 */
public class RootClassLoader {
    public static void main(String[] args) {
        ClassLoader classLoader = String.class.getClassLoader();
        // null
        System.out.println("Bootstrap" + classLoader);
        //
        System.out.println(System.getProperty("sun.boot.class.path"));
    }
}
