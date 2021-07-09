package com.wxx.dp;

/**
 * @author Xinxin.Wang
 * @since 2021/7/9 16:02
 */
public class Day03One {


    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int size = nums.length;
        if (size == 1) {
            return nums[0];
        }

        int[] dp = new int[size];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        for (int i : dp) {
            System.out.println(i);
        }
        return dp[size - 1];
    }


    public static void main(String[] args) {

        Day03One day03One = new Day03One();
        int[] a = {2,7,9,3,1};
        System.out.println(day03One.rob(a));
    }
}
