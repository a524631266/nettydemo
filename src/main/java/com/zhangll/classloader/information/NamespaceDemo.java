package com.zhangll.classloader.information;

import com.zhangll.classloader.MyClassLoader;

public class NamespaceDemo {
    public static void sameClassLoader() throws ClassNotFoundException {
        // 获取的是相同的加载器
        ClassLoader classLoader = NamespaceDemo.class.getClassLoader();
        ClassLoader classLoader1 = MyClassLoader.class.getClassLoader();
        Class<?> aClass = classLoader.loadClass("com.zhangll.classloader.information.NamespaceDemo");
        Class<?> aClass2 = classLoader1.loadClass("com.zhangll.classloader.information.NamespaceDemo");
        System.out.println(aClass.hashCode());
        System.out.println(aClass2.hashCode());
        Class<?> aClass3 = classLoader.loadClass("com.zhangll.classloader.information.NamespaceDemo");
        Class<?> aClass4 = classLoader1.loadClass("com.zhangll.classloader.information.NamespaceDemo");
        System.out.println(aClass3.hashCode());
        System.out.println(aClass4.hashCode());

        System.out.println(aClass.getClassLoader());
    }

    public static void notsameClassLoader() throws ClassNotFoundException {
        // 定义的是不同的类加载器
        MyClassLoader classLoader = new MyClassLoader(MyClassLoader.DEFAULT_CLASS_DIR.toAbsolutePath().toString(),null);
        MyClassLoader classLoader1 = new MyClassLoader(MyClassLoader.DEFAULT_CLASS_DIR.toAbsolutePath().toString(), null);
        // 默认的AppClassloader
//        MyClassLoader classLoader = new MyClassLoader();
//        MyClassLoader classLoader1 = new MyClassLoader();

        Class<?> aClass = classLoader.loadClass("com.zhangll.classloader.information.NamespaceDemo");
        Class<?> aClass2 = classLoader1.loadClass("com.zhangll.classloader.information.NamespaceDemo");
        System.out.println(aClass.getClassLoader());
        System.out.println(aClass2.getClassLoader());
        System.out.println(aClass.hashCode());
        System.out.println(aClass2.hashCode());
        System.out.println(aClass == aClass2);

    }
    public static void main(String[] args) throws ClassNotFoundException {
        NamespaceDemo.sameClassLoader();

        System.out.println("----------------------");

        NamespaceDemo.notsameClassLoader();


        Class.forName("com.zhangll.classloader.RootClassLoader");
    }
}
