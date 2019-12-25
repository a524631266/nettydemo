package com.zhangll.classloader;

/**
 * 由java写的，所以会由classLoader
 */
public class ExtClassLoader {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(System.getProperty("java.ext.dirs"));
        Class<?> aClass = Class.forName("java.lang.String");
        // null
        System.out.println(aClass.getClassLoader());
    }
}
