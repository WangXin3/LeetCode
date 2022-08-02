package com.wxx.random.year2021.sep;

import com.wxx.utils.util.ListNode;

/**
 * @author Xinxin.Wang
 * @since 2021/9/2 9:35
 */
public class Day02 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode nextKNode = head;

        for (int i = 0; i < k; i++) {
            nextKNode = nextKNode.next;
        }

        while (nextKNode != null) {
            nextKNode = nextKNode.next;
            head = head.next;

        }

        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
//        listNode.next.next = new ListNode(3);
//        listNode.next.next.next = new ListNode(4);
//        listNode.next.next.next.next = new ListNode(5);

        Day02 day02 = new Day02();
        System.out.println(day02.getKthFromEnd(listNode, 1));
    }

}
