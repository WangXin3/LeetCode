package com.wxx.random.year2022.september;

import com.wxx.util.U;

/**
 * @author Xinxin.Wang
 * @since 2022/9/8 9:40
 */
public class Day08 {
    public static void main(String[] args) {
        Solution08 solution08 = new Solution08();
        int[] x = solution08.constructArray(7, 6);
        U.printIntArray(x);
    }
}

class Solution08 {
    public int[] constructArray(int n, int k) {
        int[] answer = new int[n];
        int idx = 0;
        for (int i = 1; i < n - k; ++i) {
            answer[idx] = i;
            ++idx;
        }
        for (int i = n - k, j = n; i <= j; ++i, --j) {
            answer[idx] = i;
            ++idx;
            if (i != j) {
                answer[idx] = j;
                ++idx;
            }
        }
        return answer;
    }
}
