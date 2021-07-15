package com.wxx.start;

/**
 * @author Xinxin.Wang
 * @since 2021/7/15 17:28
 */
public class Day02One {

    public int[] sortedSquares(int[] nums) {
        int n = nums.length;

        int[] ans = new int[n];

        for (int i = 0, j = n - 1, pos = n - 1; i <= j; ) {
            int i1 = nums[i] * nums[i];
            int j2 = nums[j] * nums[j];
            if (i1 > j2) {
                ans[pos] = i1;
                i++;
            } else {
                ans[pos] = j2;
                j--;
            }
            pos--;
        }


        return ans;
    }

    public static void main(String[] args) {

    }
}
