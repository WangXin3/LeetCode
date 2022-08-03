package com.wxx.top100;

import com.wxx.util.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Xinxin.Wang
 * @since 2022/8/2 16:39
 */
public class Num141 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(3);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(0);
        listNode.next.next.next = new ListNode(-4);
        listNode.next.next.next.next = listNode.next;

        Solution141 solution141 = new Solution141();
        System.out.println(solution141.hasCycle(listNode));
    }
}

class Solution141 {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        // 如果慢的追上快的，则说明有环
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }
}
