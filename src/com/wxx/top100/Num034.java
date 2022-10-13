package com.wxx.top100;

import java.util.Arrays;

/**
 * @author Xinxin.Wang
 * @since 2022/10/13 15:52
 */
public class Num034 {
    public static void main(String[] args) {

        Solution034 solution034 = new Solution034();
        int[] a = {1, 3, 4, 5, 5, 5, 6, 6, 8, 9};
        System.out.println(Arrays.toString(solution034.searchRange1(a, 5)));
    }
}

class Solution034 {
    public int[] searchRange(int[] nums, int target) {
        int[] defaultAns = {-1, -1};
        int length = nums.length;
        if (length == 0) {
            return defaultAns;
        }

        int targetIndex = Arrays.binarySearch(nums, target);
        if (targetIndex >= 0 && targetIndex < length) {
            int left = targetIndex;
            int right = targetIndex;
            while (left > 0) {
                if (nums[left] != target) {
                    left += 1;
                    break;
                } else {
                    left--;
                }
            }

            while (right < length) {
                if (nums[right] != target) {
                    right -= 1;
                    break;
                } else {
                    right++;
                }
            }
            defaultAns[0] = Math.max(left, 0);
            defaultAns[1] = Math.min(right, length - 1);
        }
        return defaultAns;
    }

    public int[] searchRange1(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}