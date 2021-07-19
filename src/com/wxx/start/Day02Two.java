package com.wxx.start;

import java.util.Arrays;

/**
 * @author Xinxin.Wang
 * @since 2021/7/15 17:46
 */
public class Day02Two {

    public void rotate(int[] nums, int k) {

        // 移动次数 mod 数组长度，因为超过数组长度一倍的移动是对结果无影响的
        k %= nums.length;
        // 首先整个数组反转
        reverse(nums, 0, nums.length - 1);
        // 反转 0 到 k - 1
        reverse(nums, 0, k - 1);
        // 反转 k 到 结尾
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }

    }


    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5,6,7};
        Day02Two day02Two = new Day02Two();
        day02Two.rotate(nums, 9);

        for (int num : nums) {
            System.out.print(num + ",");
        }
    }
}
