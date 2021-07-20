package com.wxx.random.jul;

import java.util.Arrays;

/**
 * @author Xinxin.Wang
 * @since 2021/7/20 13:54
 */
public class Day20 {


    public int minPairSum(int[] nums) {
        Arrays.sort(nums);

        int ans = 0;
        for (int i = 0, j = nums.length - 1; i < nums.length && j > 0; i++, j--) {
            ans = Math.max(ans, nums[i] + nums[j]);
        }

        return ans;
    }

    public static void main(String[] args) {

        Day20 day20 = new Day20();
        int[] nums = {4,1,5,1,2,5,1,5,5,4};
        System.out.println(day20.minPairSum(nums));
    }
}
