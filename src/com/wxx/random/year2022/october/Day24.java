package com.wxx.random.year2022.october;

/**
 * @author Xinxin.Wang
 * @since 2022/10/24 9:45
 */
public class Day24 {
    public static void main(String[] args) {
        Solution24 solution24 = new Solution24();
        int[] a = {1, 9, 2, 8, 3, 7, 7, 8, 9};
        System.out.println(solution24.partitionDisjoint(a));
    }
}

class Solution24 {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] rightMinArray = new int[n];
        rightMinArray[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            // 储存每个下标到数组结尾的最小值
            rightMinArray[i] = Math.min(nums[i], rightMinArray[i + 1]);
        }

        int leftMaxValue = nums[0];
        for (int i = 0; i < n - 1; i++) {
            leftMaxValue = Math.max(leftMaxValue, nums[i]);
            if (leftMaxValue <= rightMinArray[i + 1]) {
                return i + 1;
            }
        }

        return 0;
    }
}
