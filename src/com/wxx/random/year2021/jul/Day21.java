package com.wxx.random.year2021.jul;

import com.wxx.utils.Util;
import com.wxx.utils.ListNode;

/**
 * @author Xinxin.Wang
 * @since 2021/7/21 9:21
 */
public class Day21 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode h1 = headA, h2 = headB;
        while (h1 != h2) {

            h1 = h1 == null ? headB : h1.next;
            h2 = h2 == null ? headA : h2.next;
        }

        return h1;
    }

    public static void main(String[] args) {
        int[] a = {4, 1, 8, 4, 5};
        int[] b = {5, 0, 1, 8, 4, 5};
        ListNode<Integer> nodeA = Util.createList(a);
        ListNode<Integer> nodeB = Util.createList(b);
        Day21 day21 = new Day21();
        ListNode intersectionNode = day21.getIntersectionNode(nodeA, nodeB);
        System.out.println(intersectionNode);
    }
}
