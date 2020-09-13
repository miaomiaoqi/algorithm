package com.miaoqi.algorithm.dynamicprogram.mostgold;


import java.util.Arrays;

/**
 * 动态规划实现挖矿问题
 *
 * @author miaoqi
 * @date 2018/12/12
 */
public class MostGold3 {

    public static void main(String[] args) {
        System.out.println(getMostGold(5, 10, new int[]{400, 500, 200, 300, 350}, new int[]{5, 5, 3, 4, 3}));
    }

    /**
     * 动态规划获取最优解
     *
     * @author miaoqi
     * @date 2018/12/12
     * @param n 金矿数量
     * @param w 工人数量
     * @param g 没做金矿的金矿数
     * @param p 挖矿所需的工人数
     * @return
     */
    static int getMostGold(int n, int w, int[] g, int[] p) {
        int[] preResults = new int[w + 1];
        int[] results = new int[w + 1];
        // 填充边界格子即第一行数据
        for (int i = 1; i <= w; i++) {
            if (i < p[0]) {
                // 工人数小于挖矿所需人数, 所以挖到0
                preResults[i] = 0;
            } else {
                // 工人数大于等于挖矿所需人数, 所以是矿的含金数量
                preResults[i] = g[0];
            }
        }
        // 填充其余格子的值, 外层循环是金矿数量, 内层循环是工人数量
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= w; j++) {
                if (j < p[i]) {
                    results[j] = preResults[j];
                } else {
                    results[j] = Math.max(preResults[j], preResults[j - p[i]] + g[i]);
                }
            }
            preResults = Arrays.copyOf(results, results.length);
        }
        return results[w];
    }

}
