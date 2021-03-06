package com.wxx.dp;

/**
 * @author Xinxin.Wang
 * @since 2021/7/14 13:42
 */
public class Day03Three {


    public int deleteAndEarn(int[] nums) {
        int maxVal = 0;
        for (int val : nums) {
            maxVal = Math.max(maxVal, val);
        }
        int[] sum = new int[maxVal + 1];
        for (int val : nums) {
            sum[val] += val;
        }
        return rob(sum);
    }

    public int rob(int[] nums) {
        int size = nums.length;
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < size; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }


    public static void main(String[] args) {
        Day03Three day03Three = new Day03Three();

        int[] nums = {2,2,3,3,3,4,4,5,5,101,101};
        System.out.println(day03Three.deleteAndEarn(nums));

    }
}
