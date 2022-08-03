package com.wxx.top100;

import com.wxx.util.U;
import com.wxx.util.ListNode;

/**
 * @author Xinxin.Wang
 * @since 2022/8/3 11:00
 */
public class Num206 {
    public static void main(String[] args) {
        ListNode list = U.createList("[1,2,3,4,5]");

        Solution206 solution206 = new Solution206();
        ListNode listNode = solution206.reverseList1(list);
        System.out.println(listNode);
    }
}

class Solution206 {
    /**
     * 迭代反转
     *
     * @param head /
     * @return /
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            // 缓存下一节点
            ListNode next = curr.next;
            // 将当前节点的指向改为前一节点
            curr.next = prev;
            // 向后移动，prev节点换为当前节点
            prev = curr;
            // 向后移动，curr节点换为下一节点
            curr = next;
        }

        return prev;
    }

    /**
     * 递归反转
     *
     * @param head /
     * @return /
     */
    public ListNode reverseList1(ListNode head) {
        // 递归退出的条件，也就是最后一个链表元素
        if (head == null || head.next == null) {
            return head;
        }
        // 一直压栈，直到最后一个元素作为新头，记为newHead
        ListNode newHead = reverseList1(head.next);

        // 反转
        head.next.next = head;

        head.next = null;
        return newHead;
    }
}
