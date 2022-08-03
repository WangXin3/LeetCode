package com.wxx.top100;

import com.wxx.util.U;
import com.wxx.util.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xinxin.Wang
 * @since 2022/8/3 14:44
 */
public class Num234 {

    public static void main(String[] args) {
        ListNode list = U.createList("[1,1,2,3,2,1,1]");
        Solution234 solution234 = new Solution234();
        System.out.println(solution234.isPalindrome1(list));
    }
}

class Solution234 {
    /**
     * 时间复杂度 O(n + n/2) = O(n)
     * 空间复杂度 O(n)
     *
     * @param head /
     * @return /
     */
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
            if (!list.get(i).equals(list.get(j))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 时间复杂度O(n) 空间复杂度O(1)
     *
     * @param head /
     * @return /
     */
    public boolean isPalindrome1(ListNode head) {
        if (head == null) {
            return false;
        }

        // 快慢指针找出前半部分的尾节点
        ListNode slow = head; // 后半部分的链表
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 反转后半部分的链表
        assert slow.next != null;
        ListNode reverseList = reverseList(slow.next);

        // 判断前半部分和后半部分是否相同
        ListNode p1 = head;
        ListNode p2 = reverseList;
        boolean result = true;

        // 以反转后的后半段链表为基准作比较，如果发现有不同，则不是回文链表
        // 如果为奇数个元素，后段链表占(n - 1) / 2个元素
        // 如果为偶数个元素，后段链表占n / 2个元素
        while (p1.next != null && p2.next != null) {
            if (p1.val != p2.val) {
                result = false;
                break;
            }

            p1 = p1.next;
            p2 = p2.next;
        }

        // 将后半部分链表恢复
        slow.next = reverseList(reverseList);

        // 返回结果
        return result;
    }

    public ListNode reverseList(ListNode head) {
        if (head.next == null) {
            return head;
        }

        ListNode newHead = reverseList(head.next);

        head.next.next = head;
        head.next = null;

        return newHead;
    }
}
