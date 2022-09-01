package com.wxx.random.year2022.august;

import java.util.Arrays;

/**
 * @author Xinxin.Wang
 * @since 2022/8/29 9:31
 */
public class Day29 {
    public static void main(String[] args) {
        Solution29 solution29 = new Solution29();
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        // 1, 2, 3, 4, 5, 6, 7, 8
        // 1, 5, 3, 4, 2, 6, 7, 8
        // 1, 5, 2, 4, 3, 6, 7, 8
        // 1, 5, 2, 6, 3, 4, 7, 8

        Arrays.stream(solution29.shuffle(a, 1)).forEach(System.out::print);
    }
}

class Solution29 {
    public int[] shuffle(int[] nums, int n) {
        int[] newNums = new int[2 * n];
        int x = 0;
        int y = n;
        for (int i = 0; i < newNums.length; i++) {
            newNums[i] = i % 2 == 0 ? nums[x++] : nums[y++];
        }
        return newNums;
    }
}
