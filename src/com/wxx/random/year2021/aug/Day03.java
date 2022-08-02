package com.wxx.random.year2021.aug;

import java.util.Arrays;

/**
 * @author Xinxin.Wang
 * @since 2021/8/3 9:29
 */
public class Day03 {

    public int findUnsortedSubarray(int[] nums) {
        if (isSorted(nums)) {
            return 0;
        }

        int[] temp = new int[nums.length];

        System.arraycopy(nums, 0, temp, 0, nums.length);

        Arrays.sort(temp);

        int left = 0;
        while (nums[left] == temp[left]) {
            left++;
        }

        int right = nums.length - 1;
        while (nums[right] == temp[right]) {
            right--;
        }


        return right - left + 1;
    }

    public boolean isSorted(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
