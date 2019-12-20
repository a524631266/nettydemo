package com.test.string;

/**
 * 个人认为，这个问题有些严肃。
 * 首先看博主的语言，应该用的是java，所以，这里语言我就假设用的是java编译器，生成应用程序的空间。
 * 其次，java编译器有很多不同版本，所以，用最经典的oracle编译器来说的
 * 在编译器词法扫描过程中，根据用户的输入
 */
public class Test {
    public static void main(String[] args) {
        String str= "abc";
        str += "123";
        String str1 = "abc" + new String("123");
        String str3 = "abc" + "123";
        String str2 = str1.intern();
        System.out.println(str == "abc123");
        System.out.println(str == str1);
        System.out.println(str2 == "abc123");
        System.out.println(str3 == str2);
        System.out.println("123" == new String("123"));
        System.out.println("123" == "123");
        System.exit(0);
    }
}
