package com.wxx.random.sep;

/**
 * @author Xinxin.Wang
 * @since 2021/9/15 9:15
 */
public class Day15 {

    public int findPeakElement(int[] nums) {
        int idx = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > nums[idx]) {
                idx = i;
            }
        }
        return idx;
    }

    public static void main(String[] args) {

    }
}
