package com.wxx.top2025100;

import java.util.*;

/**
 * @author wangxin
 * @since 2025/12/9 10:52
 */
public class Num128 {
    public static void main(String[] args) {
        Solution128 solution128 = new Solution128();
        System.out.println(solution128.longestConsecutive(new int[]{0}));
    }
}

class Solution128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int max = 0;
        for (Integer num : numSet) {
            if (!numSet.contains(num - 1)) {
                int cur = num;
                int curMax = 1;
                while (numSet.contains(cur + 1)) {
                    cur = cur + 1;
                    curMax = curMax + 1;

                }
                max = Math.max(max, curMax);
            }
        }

        return max;
    }
}
