package com.zhangll.classloader;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * l类加载过程查看
 * @see java.lang.ClassLoader  loadClass(String name, boolean resolve)
 * 先找父构造的加载器，再找自身的，是一个深度优先算法
 */
public class MyClassLoader extends ClassLoader {
    private final Path DEFAULT_CLASS_DIR = Paths.get("E:", "github", "nettytest","target","classes");
    private final  Path classDir;

    MyClassLoader(){
        super();
        this.classDir = DEFAULT_CLASS_DIR;
    }
    public MyClassLoader(String classDir, ClassLoader parent) {
        super(parent);
        this.classDir = Paths.get(classDir);
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        return super.loadClass(name, resolve);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        String path = name.replace(".",File.separator);
//        String path = classDir.getFileName();
        Path resolve = classDir.resolve(path + ".class");
        byte[] classbyts = null;
        try {
            classbyts = readClassBytes(resolve);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(classbyts == null) {

        }else {
            return this.defineClass(name,classbyts,0,classbyts.length);
        }
        return super.findClass(name);
    }

    private byte[] readClassBytes(Path resolve) throws ClassNotFoundException, IOException {
        if (resolve.toFile().exists()) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                Files.copy(resolve, byteArrayOutputStream);
                return byteArrayOutputStream.toByteArray();
            } catch (IOException e) {
                e.printStackTrace();
                throw new IOException(e);
            }
        } else {
            throw new ClassNotFoundException("无法找到" + resolve);
        }

    }

    public static void main(String[] args) {
        MyClassLoader myClassLoader = new MyClassLoader(Paths.get("E:", "github", "nettytest","target","classes").toString(),MyClassLoader.class.getClassLoader().getParent());
        try {

            Class<?> aClass = myClassLoader.findClass("com.zhangll.classloader.RootClassLoader");
            ClassLoader classLoader = aClass.getClassLoader();
            System.out.println(classLoader.getParent());

            Object o =  aClass.newInstance();
            System.out.println(o);
            Method welcome = aClass.getMethod("welcome");
            System.err.println("invoke  " + welcome.invoke(o));

//            Method money = aClass.getMethod("money").setAccessible(true);
            Method[] methods = aClass.getDeclaredMethods();
            for (Method method : methods) {
                method.setAccessible(true);
                String name = method.getName();
                if(name == "money"){
                    System.out.println("money " + method.invoke(o));
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
