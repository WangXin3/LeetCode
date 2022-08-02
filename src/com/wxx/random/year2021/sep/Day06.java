package com.wxx.random.year2021.sep;

/**
 * @author Xinxin.Wang
 * @since 2021/9/6 9:12
 */
public class Day06 {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

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
        Day06 day06 = new Day06();
        int[] a = {1,2,3,4,5};

        System.out.println(day06.search(a, 4));
    }
}
