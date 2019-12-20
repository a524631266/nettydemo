package com.zhangll.notes;

import java.net.URL;
import java.util.ServiceLoader;

public class TestServiceLoader {
    ChildrenOne childrenOne;
    ChildrenTwo childrenTwo;
    public static void main(String[] args) {
        // 使用方法为在 resource资源库中使用创建文件夹 META-INF/services/文件名
        // 其中文件名一定为父类的权限定名，并在文件中写入文件权限定名
//        ServiceLoader<FatherInterface> load = ServiceLoader.load(FatherInterface.class, TestServiceLoader.getCurrent());
        ServiceLoader<FatherInterface> load = ServiceLoader.load(FatherInterface.class);
        for (FatherInterface fatherInterface : load) {
            System.out.println(fatherInterface.sayHello() + fatherInterface.getName());
            System.out.println(load.hashCode());
        }
        ServiceLoader<FatherInterface> load2 = ServiceLoader.load(FatherInterface.class); // 每次重新加载新的类，而不是旧类，这个很重要概念，这个是工厂方法
        for (FatherInterface fatherInterface : load2) {
            System.out.println(fatherInterface.sayHello() + fatherInterface.getName());
            System.out.println(load2.hashCode());
        }
    }
    public static  ClassLoader getCurrent(){
//        Thread.currentThread().setContextClassLoader(ChildrenOne.class.getClassLoader());
//        Thread.currentThread().setContextClassLoader(ChildrenTwo.class.getClassLoader());

        ClassLoader cl = Thread.currentThread().getContextClassLoader();

        URL resource = cl.getResource("");
        String s = resource.toString();
        if ( cl == null) {
            cl = TestServiceLoader.class.getClassLoader();
        }
//        cl = TestServiceLoader.class.getClassLoader();
        return cl;
    }
}
