package com.miaoqi.imooc.loadbalance.round;

import java.util.HashMap;
import java.util.Map;

/**
 * 加权轮询
 *
 * @author miaoqi
 * @date 2020/10/19
 */
public class WeightRound {

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

    static int index;

    public static String go() {
        int allWeight = servers.map.values().stream().mapToInt(a -> a).sum();
        if (index == allWeight) {
            index = 0;
        }
        int number = (index++) % allWeight;
        for (Map.Entry<String, Integer> item : servers.map.entrySet()) {
            if (item.getValue() > number) {
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