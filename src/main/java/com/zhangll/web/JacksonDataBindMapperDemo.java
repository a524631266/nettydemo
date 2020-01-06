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
class JacksonDataBindMapperDemo {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        // data/data.json 必须要最多匹配，否则会报错 ，即 文件多了字段， 可以少字段
        MyValue myValue = objectMapper.readValue(new File("data/data.json"), MyValue.class);
        System.out.println(myValue.name);
        System.out.println(myValue.age);

        byte[] bytes = objectMapper.writeValueAsBytes(new MyValue() {
            {
                this.name = "abc";
                this.age = 123;
            }
        });
        //
        HttpPost httpPost = new HttpPost();
        httpPost.setEntity(new ByteArrayEntity(bytes));

//        System.out.println(new ByteArrayEntity(bytes));
        System.out.println(objectMapper.readValue(bytes, MyValue.class));


    }
}
