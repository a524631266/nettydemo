package com.zhangll.algorithm;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 从 goods {2,2,4,6,3} 中 取出使得数据，不小于这个14的最小值组合
 */
public class Knapsack2 {
    public static void main(String[] args) {
        int[] goods = {2,2,4,3,5,8,6};
        final int Limit = 20;
        // 装填变量1
        int weight = 0;
        int initMin = 0;
        for (int i = 0; i < goods.length; i++) {
            if(initMin < Limit){
                initMin += goods[i];
            }else {
                break;
            }
        }

        // 动态规划求解 goods 在限定值内的最大可取值
        boolean[] states = (boolean[]) Array.newInstance(boolean.class, initMin+1);
        // 初始化
        for (int i = 0; i < goods.length; i++) {
            states[goods[i]] = true;
        }
        states[0] = true;
        // 存储状态
        Map<Integer , Set> map = new HashMap<Integer , Set>();
        //  状态
        for (int i = 0; i < goods.length; i++) {
            for (int j = Limit; j >= 0 ; j--) {
                int nextid = j + goods[i];
                if(states[j] && (nextid<= initMin)){
                    states[nextid] = true;

                    Set orDefault = map.getOrDefault(nextid, new HashSet());
                    // 加入之前的状态值
                    orDefault.add(j);
                    map.put(nextid, orDefault);
                }
            }
        }
        for (int i = 0; i < states.length; i++) {
            System.out.println("i:[" + i + "]:" + states[i]);
        }
        System.out.println(map.toString());
    }
}
