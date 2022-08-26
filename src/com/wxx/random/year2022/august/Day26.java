package com.wxx.random.year2022.august;

import java.util.Arrays;

/**
 * @author Xinxin.Wang
 * @since 2022/8/26 9:32
 */
public class Day26 {

    public static void main(String[] args) {
        Solution26 solution26 = new Solution26();
        int[] a = {3, 7};
        System.out.println(solution26.maxProduct(a));
    }
}

class Solution26 {
    public int maxProduct(int[] nums) {
        if (nums.length == 2) {
            return (nums[0] - 1) * (nums[1] - 1);
        }

        Arrays.sort(nums);

        int j = nums.length - 1;
        int i = j - 1;

        return (nums[i] - 1) * (nums[j] - 1);
    }
}
