package com.base;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class UsingIterable implements Iterable<String>{
    protected final String[] strings;
    private int length = 0;
    private int index = 0;
    public UsingIterable(String[] strings) {
        this.strings = strings;
        this.length = strings.length;
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            @Override
            public boolean hasNext() {
                return length >= index+1;
            }

            @Override
            public String next() {
                return strings[index ++];
            }
        };
    }

    @Override
    public void forEach(Consumer<? super String> action) {

    }

    @Override
    public Spliterator<String> spliterator() {
        return null;
    }

    public static void main(String[] args) {
        String[] strings = {"abcde", "deafd", "fead"};
        UsingIterable strings2 = new UsingIterable(strings);
        Iterator<String> iterator = strings2.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }
    }
}
