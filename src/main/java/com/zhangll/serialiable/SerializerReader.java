package com.zhangll.serialiable;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class SerializerReader {
    public static void main(String[] args) throws FileNotFoundException {
        Kryo kryo = new Kryo();
//        kryo.register(Person.class);
        Input input = new Input(new FileInputStream("data/person.bin"));
        Person person = kryo.readObject(input, Person.class);
        System.out.println("name :" + person.getName() + "; is" + person.getAge());
    }
}
