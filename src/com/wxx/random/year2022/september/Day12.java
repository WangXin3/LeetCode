package com.wxx.random.year2022.september;

import java.util.Arrays;

/**
 * @author Xinxin.Wang
 * @since 2022/9/13 9:54
 */
public class Day12 {
    public static void main(String[] args) {
        Solution12 solution12 = new Solution12();
        int[] a = {3,5};


        // 从后遍历 x 不能大于末尾值，
        // 2,5, 345, 5123, 51233, 51235123
        System.out.println(solution12.specialArray(a));
    }
}

class Solution12 {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);

        int length = nums.length;

        int x = Math.min(length, nums[length - 1]);
        int geXCount = 0;
        for (int i = length - 1; i >= 0; i--) {
            for (int num : nums) {
                if (num >= x) {
                    geXCount++;
                }
            }

            if (geXCount == x) {
                return x;
            } else {
                x--;
                geXCount = 0;
            }
        }

        return -1;
    }
}
