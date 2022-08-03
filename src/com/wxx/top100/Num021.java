package com.wxx.top100;

import com.wxx.util.ListNode;
import com.wxx.util.U;

/**
 * @author Xinxin.Wang
 * @since 2022/8/3 17:02
 */
public class Num021 {
    public static void main(String[] args) {
        ListNode l1 = U.createList("[]");
        ListNode l2 = U.createList("[]");

        Solution021 solution021 = new Solution021();
        System.out.println(solution021.mergeTwoLists(l1, l2));
    }
}

class Solution021 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        } else if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        ListNode l1Head = list1;
        ListNode l2Head = list2;

        ListNode newListNode = new ListNode();
        ListNode temp = newListNode;
        while (l1Head != null || l2Head != null) {
            ListNode next;
            if (l1Head != null && l2Head != null) {
                next = new ListNode(Math.min(l1Head.val, l2Head.val));
                if (l1Head.val < l2Head.val) {
                    l1Head = l1Head.next;
                } else {
                    l2Head = l2Head.next;
                }
            } else if (l1Head == null) {
                next = new ListNode(l2Head.val);
                l2Head = l2Head.next;
            } else {
                next = new ListNode(l1Head.val);
                l1Head = l1Head.next;
            }
            temp.next = next;
            temp = next;
        }
        return newListNode.next;
    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        }
    }
}
