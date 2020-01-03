package com.test.string;

import org.apache.commons.lang.StringEscapeUtils;

public class StringEscapeUtilsTest {
    public static void main(String[] args) {
        String code = " iasi .asd ,dfasd    kjkasdfkk 特别‘是锕’,,  asd \n asdf";
        String s = StringEscapeUtils.escapeJava(code);
        System.out.println(s);
    }
}
