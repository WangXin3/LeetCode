package com.wxx.random.year2022.november;

/**
 * @author Xinxin.Wang
 * @since 2022/11/16 9:28
 */
public class Day16 {

    public static void main(String[] args) {
        // 2 4 3 1
    }
}

class Solution16 {
    public boolean isIdealPermutation(int[] nums) {
        int n = nums.length, minSuff = nums[n - 1];
        for (int i = n - 3; i >= 0; i--) {
            if (nums[i] > minSuff) {
                return false;
            }
            minSuff = Math.min(minSuff, nums[i + 1]);
        }
        return true;
    }
}
