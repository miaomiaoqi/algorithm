package com.miaoqi.imooc.loadbalance.round;

import java.util.ArrayList;
import java.util.List;

/**
 * 完全轮询
 *
 * @author miaoqi
 * @date 2020/10/19
 */
public class FullRound {

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
    static int index;

    public static String go() {
        if (index == servers.list.size()) {
            index = 0;
        }
        return servers.list.get(index++);
    }


    public static void main(String[] args) {
        for (int i = 0; i < 15; i++) {
            System.out.println(go());
        }
    }

}
