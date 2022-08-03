package com.wxx.random.year2021.jul;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xinxin.Wang
 * @since 2021/7/22 9:25
 */
public class Day22 {

    Map<Node, Node> cachedNode = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node p = head;

        Map<Node, Node> map = new HashMap<>();
        // 给每个旧节点生成新节点，并用hash表一一对应
        while (p != null) {
            Node newNode = new Node(p.val);
            map.put(p, newNode);
            p = p.next;
        }

        p = head;

        while (p != null) {
            Node newNode = map.get(p);
            if (p.next != null) {
                newNode.next = map.get(p.next);
            }

            if (p.random != null) {
                newNode.random = map.get(p.random);
            }

            p = p.next;
        }


        return map.get(head);
    }


    public static void main(String[] args) {

    }
}

class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
