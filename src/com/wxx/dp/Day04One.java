package com.wxx.dp;

/**
 * @author Xinxin.Wang
 * @since 2021/7/16 14:51
 */
public class Day04One {

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Day04One day04One = new Day04One();
        int[] nums = {1,3,2};
        System.out.println(day04One.canJump(nums));
    }
}
