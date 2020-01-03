package com.base;

import java.util.HashMap;
import java.util.function.BiConsumer;

public class HashMapBracket {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<String, String>() {{
            put("abc", "123");
            put("cde", "234");
        }};
        // 方式1
        System.out.println("方式1");
        BiConsumer<? super String, ? super String> biConsumer = new BiConsumer<String, String>() {
            @Override
            public void accept(String s, String s2) {
                System.out.println("key:" + s + ",value:" + s2);
            }
        };
        int a = 1;
        hashMap.forEach(biConsumer);
        System.out.println("方式2");
        // 方式2
        hashMap.forEach((key, value ) -> {
            System.out.println("key:" + key + ",value:" + value);
//            a = 2; .// 报错，说明表达式不能够访问外部变量
        });
    }
}
