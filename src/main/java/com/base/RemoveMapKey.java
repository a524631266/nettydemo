package com.base;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RemoveMapKey {
    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>(){
            {
                put(1,2);
                put(2,3);
                put(3,null);
                put(4,5);
            }

        };
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            System.out.println(next);
            if(map.getOrDefault(next,null) == null) {
                // ConcurrentModificationException
                map.remove(next);
//                iterator.remove();
            }
        }
        System.out.println(map);
    }
}
