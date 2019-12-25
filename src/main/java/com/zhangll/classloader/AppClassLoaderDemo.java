package com.zhangll.classloader;

public class AppClassLoaderDemo {
    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("com.zhangll.classloader.RootClassLoader");
            // sun.misc.Launcher$AppClassLoader@18b4aac2
            System.out.println(aClass.getClassLoader());
            String property = System.getProperty("java.class.path");
            System.out.println(property);
            String[] split = property.split(";");
            for (String s : split) {
                System.out.println(s);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
