package com.wxx.random.year2024.aug;

import java.util.Arrays;

/**
 * @author wangxin
 * @since 2024/8/9 9:19
 */
public class Day09 {

    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for (int i: new int[]{2, 1, 0}) {
            int left = i + 1, right = 1;
            while (left < m && right < n) {
                if (nums1[left] - nums2[right] == nums1[i] - nums2[0]) {
                    ++right;
                }
                ++left;
            }
            if (right == n) {
                return nums2[0] - nums1[i];
            }
        }
        // 本题不会有无解的情况
        return 0;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 20, 16, 12, 8};
        // 04 08 12 16 20
        int[] nums2 = {14, 18, 10};
        // 10 14 18
        Day09 d = new Day09();

    }
}
