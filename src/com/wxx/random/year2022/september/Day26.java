package com.wxx.random.year2022.september;

import com.wxx.util.U;

/**
 * @author Xinxin.Wang
 * @since 2022/9/26 9:38
 */
public class Day26 {
    public static void main(String[] args) {
        Solution26 solution26 = new Solution26();
        int[] ints = solution26.missingTwo(new int[]{1});
        U.printIntArray(ints);
    }
}

class Solution26 {
    public int[] missingTwo(int[] nums) {
        int xorSum = 0;
        int n = nums.length + 2;
        for (int num : nums) {
            xorSum ^= num;
        }
        for (int i = 1; i <= n; i++) {
            xorSum ^= i;
        }
        // 防止溢出
        int lsb = (xorSum == Integer.MIN_VALUE ? xorSum : xorSum & (-xorSum));
        int type1 = 0;
        int type2 = 0;
        for (int num : nums) {
            if ((num & lsb) != 0) {
                type1 ^= num;
            } else {
                type2 ^= num;
            }
        }
        for (int i = 1; i <= n; i++) {
            if ((i & lsb) != 0) {
                type1 ^= i;
            } else {
                type2 ^= i;
            }
        }
        return new int[]{type1, type2};
    }
}

