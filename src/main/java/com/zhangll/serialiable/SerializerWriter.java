package com.zhangll.serialiable;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Output;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

class Person {
    private final String name ;
    private final int age;

    public Person() {
        this("abc", 123);
    }

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

/**
 * 官方网 https://github.com/EsotericSoftware/kryo/blob/master/README.md
 */
public class SerializerWriter {
    public final Kryo kryo;

    public SerializerWriter(Kryo kryo) {
        this.kryo = kryo;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Kryo kryo = new Kryo();
        kryo.register(Person.class);
        Person zhangll = new Person("zhangll", 20);

        Output output = new Output(new FileOutputStream("data/person.bin"));
        kryo.writeObject(output, zhangll);
        // 必须刷新
        output.flush();
        output.clear();
    }
}
