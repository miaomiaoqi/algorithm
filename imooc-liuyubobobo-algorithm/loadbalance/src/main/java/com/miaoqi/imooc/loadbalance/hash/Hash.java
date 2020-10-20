package com.miaoqi.imooc.loadbalance.hash;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class Hash {

    static class Servers {

        public List<String> list = new ArrayList<String>() {
            {
                this.add("192.168.1.1");
                this.add("192.168.1.2");
                this.add("192.168.1.3");
            }
        };

    }

    private static String go(String client) {
        int nodeCount = 20;
        TreeMap<Integer, String> treeMap = new TreeMap();
        for (String s : new Servers().list) {
            for (int i = 0; i < nodeCount; i++) {
                treeMap.put((s + "--服务器---" + i).hashCode(), s);
            }
        }
        int clientHash = client.hashCode();
        SortedMap<Integer, String> subMap = treeMap.tailMap(clientHash);
        Integer firstHash;
        if (subMap.size() > 0) {
            firstHash = subMap.firstKey();
        } else {
            firstHash = treeMap.firstKey();
        }
        String s = treeMap.get(firstHash);
        return s;
    }

    public static void main(String[] args) {
        System.out.println(go("今天天气不错啊"));
        System.out.println(go("192.168.5.258"));
        System.out.println(go("0"));
        System.out.println(go("-110000"));
        System.out.println(go("风雨交加"));
    }

}
