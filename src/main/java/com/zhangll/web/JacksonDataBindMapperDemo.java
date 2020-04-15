package com.zhangll.web;



import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.livy.shaded.jackson.databind.ObjectMapper;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;


class MyValue {
    public String name;
    public int age;
    public SessionState sessionState;

    @Override
    public String toString() {
        return "MyValue{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sessionState=" + sessionState +
                '}';
    }
}
class ResultClass {
    public final long time;
    public final int result_2_5;
    public ResultClass(){
        this(0,0);
    }
    ResultClass(long time, int result_2_5) {
        this.time = time;
        this.result_2_5 = result_2_5;
    }
}
class JacksonDataBindMapperDemo {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        // data/data.json 必须要最多匹配，否则会报错 ，即 文件多了字段， 可以少字段
        ResultClass[] myValue = objectMapper.readValue(new File("data/data2.json"), ResultClass[].class);
//        System.out.println(myValue.name);
//        System.out.println(myValue.age);
//
//        byte[] bytes = objectMapper.writeValueAsBytes(new MyValue() {
//            {
//                this.name = "abc";
//                this.age = 123;
//            }
//        });
//        //
//        HttpPost httpPost = new HttpPost();
//        httpPost.setEntity(new ByteArrayEntity(bytes));
//
////        System.out.println(new ByteArrayEntity(bytes));
//        System.out.println(objectMapper.readValue(bytes, MyValue.class));

        System.out.println(myValue);


    }
}
