package com.wxx.top100;

import com.wxx.util.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Xinxin.Wang
 * @since 2022/8/2 17:25
 */
public class Num160 {

    public static void main(String[] args) {
        Solution160 solution160 = new Solution160();

        ListNode headA = new ListNode(1);
        headA.next = new ListNode(2);
        headA.next.next = new ListNode(3);
        headA.next.next.next = new ListNode(4);

        ListNode headB = new ListNode(8);
        headB.next = new ListNode(7);
        headB.next.next =  new ListNode(6);
        headB.next.next.next =  new ListNode(5);
        headB.next.next.next.next =  headA.next.next.next;

        System.out.println(solution160.getIntersectionNode(headA, headB));
    }
}

class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();

        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (!set.add(headB)) {
                return headB;
            }

            headB = headB.next;
        }

        return null;
    }
}
