package com.wxx.random.year2022.october;

import com.wxx.util.U;

import java.util.*;

/**
 * @author Xinxin.Wang
 * @since 2022/10/8 9:16
 */
public class Day08 {
    public static void main(String[] args) {
        Solution08 solution08 = new Solution08();
        // [5621,1743,5532,3549,9581]
        //[913,9787,4121,5039,1481]
        int[] nums1 = {5621, 1743, 5532, 3549, 9581};
        int[] nums2 = {913, 9787, 4121, 5039, 1481};
        int[] ints = solution08.advantageCount(nums1, nums2);
        U.printIntArray(ints);
    }
}

class Solution08 {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Integer[] idx1 = new Integer[n];
        Integer[] idx2 = new Integer[n];
        for (int i = 0; i < n; ++i) {
            idx1[i] = i;
            idx2[i] = i;
        }
        Arrays.sort(idx1, (i, j) -> nums1[i] - nums1[j]);
        Arrays.sort(idx2, (i, j) -> nums2[i] - nums2[j]);

        int[] ans = new int[n];
        int left = 0;
        int right = n - 1;
        for (int i = 0; i < n; ++i) {
            if (nums1[idx1[i]] > nums2[idx2[left]]) {
                ans[idx2[left]] = nums1[idx1[i]];
                ++left;
            } else {
                ans[idx2[right]] = nums1[idx1[i]];
                --right;
            }
        }
        return ans;
    }
}
