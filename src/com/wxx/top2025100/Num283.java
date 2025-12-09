package com.wxx.top2025100;

import java.util.Arrays;

/**
 * @author wangxin
 * @since 2025/12/9 14:52
 */
public class Num283 {
    public static void main(String[] args) {
        Solution283 solution283 = new Solution283();
        int[] nums = {12, 0, 0, 0, 12};
        solution283.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}

class Solution283 {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int start = 0;
        while (i < nums.length && start < nums.length) {
            if (nums[i] != 0) {
                if (nums[i] != nums[start]) {
                    nums[start] = nums[i];
                    nums[i] = 0;
                }
                start++;
            }
            i++;
        }
    }
}
