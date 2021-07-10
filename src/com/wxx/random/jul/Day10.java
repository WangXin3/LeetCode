package com.wxx.random.jul;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangxin
 * @since 2021/7/10
 */
public class Day10 {

    class Node {
        String k, v;
        int t;

        Node(String k, String v, int t) {
            this.k = k;
            this.v = v;
            this.t = t;
        }
    }


    Map<String, List<Node>> map;

    /**
     * Initialize your data structure here.
     */
    public Day10() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        List<Node> nodes = map.getOrDefault(key, new ArrayList<>());
        nodes.add(new Node(key, value, timestamp));
        map.put(key, nodes);
    }

    public String get(String key, int timestamp) {
        List<Node> nodes = map.get(key);
        if (nodes == null || nodes.isEmpty()) {
            return "";
        }

        int size = nodes.size();
        int i = 0, j = size - 1;

        while (i < j) {
            int mid = i + j + 1 >> 1;

            if (nodes.get(mid).t <= timestamp) {
                i = mid;
            } else {
                j = mid - 1;
            }
        }

        return nodes.get(i).t <= timestamp ? nodes.get(j).v : "";
    }

    public static void main(String[] args) {
        final Day10 kv = new Day10();
        kv.set("love", "high", 10);
        kv.set("love", "low", 20);
        System.out.println(kv.get("love", 5));
        System.out.println(kv.get("love", 10));
        System.out.println(kv.get("love", 15));
        System.out.println(kv.get("love", 20));
        System.out.println(kv.get("love", 25));
    }
}
