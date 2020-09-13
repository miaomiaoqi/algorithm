package com.miaoqi.algorithm.lru;

import java.util.HashMap;

/**
 *
 * LRU哈希链表, 原本独立的K-V不再是没有关系的了, 而是被一个链条串了起来
 * @author miaoqi
 * @date 2018/12/10
 */
public class LRUCache {

    private Node head;
    private Node end;

    // 缓存存储上限
    private int limit;

    private HashMap<String, Node> hashMap;

    public LRUCache(int limit) {
        this.limit = limit;
        this.hashMap = new HashMap<String, Node>();
    }

    public String get(String key) {
        Node node = hashMap.get(key);
        if (node == null) {
            return null;
        }
        refreshNode(node);
        return node.value;
    }

    public void put(String key, String value) {
        Node node = hashMap.get(key);
        if (node == null) {
            // 如果key不存在, 插入K-V
            if (hashMap.size() >= limit) {
                String oldKey = removeNode(head);
                hashMap.remove(oldKey);
            }
            node = new Node(key, value);
            addNode(node);
            hashMap.put(key, node);
        } else {
            // 如果key存在, 刷新value
            node.value = value;
            refreshNode(node);
        }
    }

    public void remove(String key) {
        Node node = hashMap.get(key);
        this.removeNode(node);
        hashMap.remove(key);
    }

    /**
     * 刷新节点
     *
     * @author miaoqi
     * @date 2018/11/13
     * @param node
     * @return
     */
    private void refreshNode(Node node) {
        // 如果访问的是尾节点, 无需移动节点
        if (node == end) {
            return;
        }
        // 移除节点
        this.removeNode(node);
        // 重新插入节点
        this.addNode(node);
    }

    /**
     * 删除节点
     *
     * @author miaoqi
     * @date 2018/11/13
     * @param node
     * @return
     */
    private String removeNode(Node node) {
        if (node == end) {
            // 移除尾节点
            end = end.pre;
        } else if (node == head) {
            // 移除头结点
            head = head.next;
        } else {
            // 移除中间节点
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        return node.key;
    }

    /**
     * 尾部插入
     *
     * @author miaoqi
     * @date 2018/11/13
     * @param node 要插入的节点
     * @return
     */
    private void addNode(Node node) {
        if (end != null) {
            end.next = node;
            node.pre = end;
            node.next = null;
        }
        end = node;
        if (head == null) {
            head = end;
        }
    }

    /**
     * 数据节点
     *
     * @author miaoqi
     * @date 2018/11/13
     */
    class Node {
        public String key;

        public String value;

        public Node pre;

        public Node next;

        Node(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(5);
        lruCache.put("001", "用户1信息");
        lruCache.put("002", "用户2信息");
        lruCache.put("003", "用户3信息");
        lruCache.put("004", "用户4信息");
        lruCache.put("005", "用户5信息");
        lruCache.get("002");
        lruCache.put("004", "用户4更新信息");
        lruCache.put("006", "用户6信息");
        System.out.println(lruCache.get("001"));
        System.out.println(lruCache.get("006"));
    }
}
