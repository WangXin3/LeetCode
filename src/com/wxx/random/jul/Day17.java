package com.wxx.random.jul;

/**
 * @author wangxin
 * @since 2021/7/17
 */
public class Day17 {

    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

    public static void main(String[] args) {

    }
}
