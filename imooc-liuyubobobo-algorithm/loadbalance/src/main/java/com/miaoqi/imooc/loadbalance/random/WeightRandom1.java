package com.miaoqi.imooc.loadbalance.random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 加权随机算法
 *
 * @author miaoqi
 * @date 2020/10/19
 */
public class WeightRandom1 {

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
        List<String> ipList = new ArrayList<String>();
        for (Map.Entry<String, Integer> item : servers.map.entrySet()) {
            for (int i = 0; i < item.getValue(); i++) {
                ipList.add(item.getKey());
            }
        }
        int allWeight = servers.map.values().stream().mapToInt(a -> a).sum();
        int number = random.nextInt(allWeight);
        return ipList.get(number);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 15; i++) {
            System.out.println(go());
        }
    }

}
