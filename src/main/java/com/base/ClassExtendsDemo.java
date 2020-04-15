package com.base;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class Person{
    public String name;
    public int age;
}
class Child extends Person{
    public String age;
}
public class ClassExtendsDemo {
    public static void testExtends(Person person){
        Class<? extends Person> aClass = person.getClass();

        System.out.println(aClass.getName());
    }

    public static void testExtends(Class person){
        try {
            Constructor constructor = person.getConstructor();
            Object o = constructor.newInstance();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Child child = new Child();
        testExtends(child);
    }
}
