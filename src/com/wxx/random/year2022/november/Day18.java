package com.wxx.random.year2022.november;

import java.util.Arrays;

/**
 * @author Xinxin.Wang
 * @since 2022/11/18 9:37
 */
public class Day18 {
    public static void main(String[] args) {

    }
}

class Solution18 {
    public int sumSubseqWidths(int[] nums) {
        final int MOD = 1000000007;
        Arrays.sort(nums);
        long res = 0;
        long x = nums[0], y = 2;
        for (int j = 1; j < nums.length; j++) {
            res = (res + nums[j] * (y - 1) - x) % MOD;
            x = (x * 2 + nums[j]) % MOD;
            y = y * 2 % MOD;
        }
        return (int) ((res + MOD) % MOD);
    }
}
