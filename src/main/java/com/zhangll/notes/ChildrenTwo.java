package com.zhangll.notes;

public class ChildrenTwo implements FatherInterface {
    private static String name = "children02";
    public String sayHello() {
        return "Hi my name is ";
    }

    public String getName() {
        return name;
    }
}
