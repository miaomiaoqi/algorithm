package com.miaoqi.imooc.loadbalance.round;

import java.util.HashMap;
import java.util.Map;

/**
 * 平滑加权轮询
 *
 * @author miaoqi
 * @date 2020/10/21
 */
public class SmoothWeightRound {

    static class Server {

        public Server(int weight, int currentWeight, String ip) {
            this.weight = weight;
            this.currentWeight = currentWeight;
            this.ip = ip;
        }

        private int weight;

        private int currentWeight;

        private String ip;

        public int getWeight() {
            return this.weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public int getCurrentWeight() {
            return this.currentWeight;
        }

        public void setCurrentWeight(int currentWeight) {
            this.currentWeight = currentWeight;
        }

        public String getIp() {
            return this.ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

    }

    static class Servers {

        public HashMap<String, Server> serverMap = new HashMap<String, Server>() {
            {
                this.put("192.168.1.1", new Server(5, 5, "192.168.1.1"));
                this.put("192.168.1.2", new Server(1, 1, "192.168.1.2"));
                this.put("192.168.1.3", new Server(1, 1, "192.168.1.3"));
            }
        };

    }


    private static Servers servers = new Servers();

    public static String go() {
        Server maxWeightServer = null;

        int allWeight = servers.serverMap.values().stream().mapToInt(Server::getWeight).sum();

        for (Map.Entry<String, Server> item : servers.serverMap.entrySet()) {
            Server currentServer = item.getValue();
            if (maxWeightServer == null || currentServer.getCurrentWeight() > maxWeightServer.getCurrentWeight()) {
                maxWeightServer = currentServer;
            }
        }
        assert maxWeightServer != null;
        maxWeightServer.setCurrentWeight(maxWeightServer.getCurrentWeight() - allWeight);

        for (Map.Entry<String, Server> item : servers.serverMap.entrySet()) {
            Server currentServer = item.getValue();
            currentServer.setCurrentWeight(currentServer.getCurrentWeight() + currentServer.getWeight());
        }
        return maxWeightServer.getIp();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 15; i++) {
            System.out.println(go());
        }
    }

}