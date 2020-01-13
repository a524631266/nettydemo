package com.zhangll.serialiable;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.ByteBufferOutputStream;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.nio.ByteBuffer;

public class SerializerWriteObjectAndClass {
    public static void main(String[] args) {
        Kryo kryo = new Kryo();
        ByteBufferOutputStream stream = new ByteBufferOutputStream();
        Output output = new Output();
        kryo.writeClassAndObject(output,Person.class);

        output.flush();
        ByteBuffer byteBuffer = stream.getByteBuffer();

        int instream ;
        Input input = new Input(byteBuffer);

    }
}
