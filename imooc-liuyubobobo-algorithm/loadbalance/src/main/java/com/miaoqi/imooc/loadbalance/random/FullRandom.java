package com.miaoqi.imooc.loadbalance.random;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 完全随机
 *
 * @author miaoqi
 * @date 2020/10/19
 */
public class FullRandom {

    static class Servers {

        public List<String> list = new ArrayList<String>() {
            {
                this.add("192.168.1.1");
                this.add("192.168.1.2");
                this.add("192.168.1.3");
            }
        };

    }

    static Servers servers = new Servers();
    static Random random = new Random();

    public static String go() {
        int number = random.nextInt(servers.list.size());
        return servers.list.get(number);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 15; i++) {
            System.out.println(go());
        }
    }

}
