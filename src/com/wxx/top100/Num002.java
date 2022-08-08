package com.wxx.top100;

import com.wxx.util.ListNode;
import com.wxx.util.U;

/**
 * @author Xinxin.Wang
 * @since 2022/8/8 10:36
 */
public class Num002 {
    public static void main(String[] args) {
        Solution002 solution002 = new Solution002();
        System.out.println(solution002.addTwoNumbers(U.createList("[9,9,9,9,9,9,9]"), U.createList("[9,9,9,9]")));
    }
}

class Solution002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode ansNode = null;
        int next = 0;
        while (l1 != null || l2 != null) {
            int dd1 = 0;
            int dd2 = 0;
            if (l1 != null) {
                dd1 = l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                dd2 = l2.val;
                l2 = l2.next;
            }

            int i = dd1 + dd2 + next;
            if (i >= 10) {
                next = i / 10;
            } else {
                next = 0;
            }

            int e = i % 10;
            if (ansNode == null) {
                ansNode = new ListNode(e);
                head = ansNode;
            } else {
                ansNode.next = new ListNode(e);
                ansNode = ansNode.next;
            }
        }

        if (next != 0) {
            ansNode.next = new ListNode(next);
        }

        return head;
    }
}
