package com.zhangll.classloader;

/**
 * 纯C++写的，所以获取为null
 */
public class RootClassLoader {
    static {
        // 加载阶段 static不会触发，即不会初始化类
        System.out.println("Root static function my is RootClass");
    }
    public RootClassLoader(){}
    public String welcome(){
        return "hello world";
    }
    private String money(){
        return "12312312";
    }
    @Override
    public String toString() {
        return "myName is Root";
    }

    public static void main(String[] args) {
        ClassLoader classLoader = String.class.getClassLoader();
        // null
        System.out.println("Bootstrap" + classLoader);
        //
        System.out.println(System.getProperty("sun.boot.class.path"));
    }
}
