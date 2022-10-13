package com.wxx.random.year2022.october;

import java.util.Arrays;

/**
 * @author Xinxin.Wang
 * @since 2022/10/13 9:08
 */
public class Day13 {

    public static void main(String[] args) {
        Solution13 solution13 = new Solution13();
        int[] a = {1, 0, 2, 3, 4, 6, 5, 8, 7, 9};
        System.out.println(solution13.maxChunksToSorted(a));
    }
}

class Solution13 {
    public int maxChunksToSorted(int[] arr) {
        int gap = 1;

        int n = arr.length;
        int gapStartIndex = 0;
        for (int i = 0; i < n - 1; i++) {
            int[] left = Arrays.copyOfRange(arr, gapStartIndex, i + 1);
            int[] right = Arrays.copyOfRange(arr, i + 1, n);
            int leftMax = Arrays.stream(left).max().getAsInt();
            int rightMin = Arrays.stream(right).min().getAsInt();

            if (leftMax < rightMin) {
                gap++;
                gapStartIndex = i + 1;
            }
        }
        return gap;
    }

    public int maxChunksToSorted1(int[] arr) {
        int m = 0;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            m = Math.max(m, arr[i]);
            if (m == i) {
                res++;
            }
        }
        return res;
    }
}
