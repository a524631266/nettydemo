package com.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Consumer;

@FunctionalInterface
interface FunctionA<K> {
    void acc(K k);
}

public class InterFaceFunctionDemo {
    public static void main(String[] args) {
        FunctionA<String> functionA = a -> System.out.println(a);
        functionA.acc("efa");
//        Collections.unmodifiableList(new ArrayList(){{
//            add("abc");
//            add("cde");
//        }}).forEach(functionA);
    }
}
