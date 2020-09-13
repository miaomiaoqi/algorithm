package com.miaoqi.algorithm.dynamicprogram.climb;

/**
 * 求解1级到10级台阶, 每次只能1级或者2级台阶公有多少种走法
 * 动态规划求解
 *
 * @author miaoqi
 * @date 2018/12/10
 */
public class Climb3 {


    public static void main(String[] args){
        System.out.println(getClimbingWays(5));
    }

    public static int getClimbingWays(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int a = 1;
        int b = 2;
        int temp = 0;
        for (int i = 3; i <= n; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }
        return temp;
    }
}
