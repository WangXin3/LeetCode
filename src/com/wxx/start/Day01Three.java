package com.wxx.start;

/**
 * @author Xinxin.Wang
 * @since 2021/7/15 17:11
 */
public class Day01Three {

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        Day01Three day01Three = new Day01Three();
        int[] nums = {1, 3, 5, 6};
        System.out.println(day01Three.searchInsert(nums, 5));
    }
}
