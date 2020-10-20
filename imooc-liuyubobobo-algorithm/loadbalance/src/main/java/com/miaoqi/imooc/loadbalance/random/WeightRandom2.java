package com.miaoqi.imooc.loadbalance.random;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 加权随机算法
 *
 * @author miaoqi
 * @date 2020/10/19
 */
public class WeightRandom2 {

    static class Servers {

        public HashMap<String, Integer> map = new HashMap<String, Integer>() {
            {
                this.put("192.168.1.1", 2);
                this.put("192.168.1.2", 7);
                this.put("192.168.1.3", 1);
            }
        };

    }

    static Servers servers = new Servers();
    static Random random = new Random();

    public static String go() {
        int allWeight = servers.map.values().stream().mapToInt(a -> a).sum();
        int number = random.nextInt(allWeight);
        for (Map.Entry<String, Integer> item : servers.map.entrySet()) {
            // 如果不在当前的范围区间就减去当前的 value, value 相当于偏移量, 然后继续判断下一个区间
            // 2 7 1
            // 1 2 3 4 5 6 7 8 9 10
            // 1 就是第一个区间
            // 2-8 相当于 7 在 1 的基础上偏移的
            // 9-10 相当于 2 在 7 + 1 的基础上偏移的
            // 此处不太好理解, 多想几遍就可以明白, 不涉及排序问题
            if (item.getValue() >= number) {
                return item.getKey();
            }
            number -= item.getValue();
        }
        return "";
    }

    public static void main(String[] args) {
        for (int i = 0; i < 15; i++) {
            System.out.println(go());
        }
    }

}
