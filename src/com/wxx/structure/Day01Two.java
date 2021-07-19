package com.wxx.structure;

/**
 * @author Xinxin.Wang
 * @since 2021/7/19 16:17
 */
public class Day01Two {

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        // 初始化当前子序列元素的和 、最大子序列的和
        int currSum = nums[0], maxSum = nums[0];

        // 遍历数据
        for(int i = 1; i < n; ++i) {
            // 判断当前子序列的和，和当前元素比较，
            // 如果当前元素更大，则子序列重新开始，初始值为当前元素
            // 否则子序列和 + 当前元素 成为新子序列
            currSum = Math.max(nums[i], currSum + nums[i]);
            // 记录每个子序列和的最大值
            maxSum = Math.max(maxSum, currSum);
        }
        // 返回最大子序列的和
        return maxSum;
    }

    public static void main(String[] args) {

    }
}
