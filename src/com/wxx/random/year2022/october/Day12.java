package com.wxx.random.year2022.october;

import com.wxx.util.ListNode;
import com.wxx.util.U;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Xinxin.Wang
 * @since 2022/10/12 9:19
 */
public class Day12 {
    public static void main(String[] args) {
        Solution12 solution12 = new Solution12();

        ListNode list = U.createList("[0,1,2,3]");
        int[] a = {4};
        System.out.println(solution12.numComponents(list, a));
    }
}

class Solution12 {
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for (int num : nums) {
            numsSet.add(num);
        }
        int count = 0;
        boolean inSet = false;
        while (head != null) {
            if (numsSet.contains(head.val)) {
                if (!inSet) {
                    inSet = true;
                    count++;
                }
            } else {
                inSet = false;
            }

            head = head.next;
        }
        return count;
    }
}
