package com.zhangll.notes;

public class ChildrenOne implements FatherInterface {
    private static String name = "children01";
    public String sayHello() {
        return "hello ,my name is" ;
    }

    public String getName() {
        return name;
    }
}
