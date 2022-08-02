package com.wxx.random.year2021.jul;

/**
 * @author Xinxin.Wang
 * @since 2021/7/16 9:25
 */
public class Day16 {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int count = 0;

        int firstIndex = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > target) {
                right = mid - 1;

            } else if (nums[mid] < target) {
                left = mid + 1;

            } else {
                firstIndex = mid;
                count++;
                break;
            }
        }


        for (int l = firstIndex - 1, r = firstIndex + 1; l >= left || r <= right; ) {
            if (l >= 0 && nums[l] == target) {
                l--;
                count++;
            } else {
                l--;
            }

            if (r <= nums.length && nums[r] == target) {
                r++;
                count++;
            } else {
                r++;
            }
        }


        return count;
    }

    public static void main(String[] args) {
        Day16 day16 = new Day16();
        int[] nums = {2, 2};

        System.out.println(day16.search(nums, 2));
    }
}
