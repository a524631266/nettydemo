package com.zhangll.algorithm;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * 从 goods {2,2,4,6,3} 中 取出使得数据，不大于这个9的最大值
 */
public class Knapsack1 {
    public static void main(String[] args) {
        int[] goods = {2,2,4,6,3};
        final int Max = 9;
        // 装填变量1
        int weight = 0;
        // 动态规划求解 goods 在限定值内的最大可取值
        boolean[] states = (boolean[]) Array.newInstance(boolean.class, Max + 1);
        states[0] = true;
        for (int i = 0; i < goods.length; i++) {
            states[goods[i]] = true;
        }
        // 设置初始值
        // i 是状态次序，即每一步确定是否装入
        for (int i = 0; i < goods.length; i++) {
//            // 会重复计算
//            for (int j = 0; j <= Max - goods[i]; j++) {
//                if(states[j]) {
//                    states[j + goods[i]] = true;
//                }
//            }
            // 不会重复计算
            for (int j = Max - goods[i]; j >= 0 ; j--) {
                if(states[j]) {
                    states[j + goods[i]] = true;
                }
            }
        }

        for (int i = 0; i < states.length; i++) {
            System.out.println("i:[" + i + "]:" + states[i]);
        }
    }
}
