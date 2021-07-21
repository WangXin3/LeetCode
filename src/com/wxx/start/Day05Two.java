package com.wxx.start;

import com.wxx.utils.ListNode;

/**
 * @author Xinxin.Wang
 * @since 2021/7/20 17:47
 */
public class Day05Two {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    public static void main(String[] args) {
        ListNode<Integer> node = new ListNode<>(1);



        Day05Two day05Two = new Day05Two();
        day05Two.removeNthFromEnd(node, 1);

        System.out.println(node);
    }


}
