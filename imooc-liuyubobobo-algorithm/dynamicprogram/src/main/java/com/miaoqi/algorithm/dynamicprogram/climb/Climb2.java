package com.miaoqi.algorithm.dynamicprogram.climb;

import java.util.HashMap;
import java.util.Map;

/**
 * 求解1级到10级台阶, 每次只能1级或者2级台阶公有多少种走法
 * 递归 + 备忘录提高性能
 *
 * @author miaoqi
 * @date 2018/12/10
 */
public class Climb2 {


    public static void main(String[] args){
        Map<Integer, Integer> map = new HashMap<>();
        System.out.println(getClimbingWays(5, map));
    }

    public static int getClimbingWays(int n, Map<Integer, Integer> map) {
        if (n < 1) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int value = getClimbingWays(n - 1, map) + getClimbingWays(n - 2, map);
        map.put(n, value);
        return value;
    }
}
