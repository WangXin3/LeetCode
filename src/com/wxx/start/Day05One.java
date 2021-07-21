package com.wxx.start;

import com.wxx.utils.ListNode;

/**
 * @author Xinxin.Wang
 * @since 2021/7/20 17:40
 */
public class Day05One {

    public ListNode middleNode(ListNode head) {

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
