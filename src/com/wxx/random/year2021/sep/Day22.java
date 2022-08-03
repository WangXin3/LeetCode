package com.wxx.random.year2021.sep;

import com.wxx.util.ListNode;

/**
 * @author Xinxin.Wang
 * @since 2021/9/22 9:19
 */
public class Day22 {

    public ListNode[] splitListToParts(ListNode head, int k) {
        int n = 0;
        // 计算链表长度
        ListNode temp = head;
        while (temp != null) {
            n++;
            temp = temp.next;
        }

        // quotient每组平分多少， remainder平分之后剩余的个数，不能平分，则分给前remainder个部分的链表各加一个，即quotient + 1
        int quotient = n / k, remainder = n % k;

        // 分组
        ListNode[] parts = new ListNode[k];

        ListNode curr = head;
        for (int i = 0; i < k && curr != null; i++) {

            parts[i] = curr;
            int partSize = quotient + (i < remainder ? 1 : 0);
            for (int j = 1; j < partSize; j++) {
                curr = curr.next;
            }
            // 切分，保存当前节点的下一个节点
            ListNode next = curr.next;
            // 将下一个节点置为null
            curr.next = null;

            curr = next;
        }
        return parts;
    }

    public static void main(String[] args) {
        Day22 day22 = new Day22();

        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        ListNode nextNode = node.next.next.next.next;
        nextNode.next = new ListNode(6);
        nextNode.next.next = new ListNode(7);
        nextNode.next.next.next = new ListNode(8);
        nextNode.next.next.next.next = new ListNode(9);
        nextNode.next.next.next.next.next = new ListNode(10);


        for (ListNode listNode : day22.splitListToParts(node, 3)) {
            System.out.println(listNode);
        }
    }
}
