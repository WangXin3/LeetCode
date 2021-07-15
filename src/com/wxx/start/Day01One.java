package com.wxx.start;

/**
 * @author Xinxin.Wang
 * @since 2021/7/15 16:18
 */
public class Day01One {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (right + left) / 2;

            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Day01One day01One = new Day01One();

        int[] nums = {-1, 0, 3, 5, 9, 12};

        System.out.println(day01One.search(nums, 9));
    }


}
