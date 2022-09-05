package com.wxx.random.year2022.september;

import java.util.Arrays;

/**
 * @author Xinxin.Wang
 * @since 2022/9/5 14:10
 */
public class Day03 {
    public static void main(String[] args) {
//        [[7,9],[4,5],[7,9],[-7,-1],[0,10],[3,10],[3,6],[2,3]]
        // [[-7, -1], [0, 10], [2, 3], [3, 10], [3, 6], [4, 5], [7, 9], [7, 9]]
//        int[][] a = {{7, 9}, {4, 5}, {7, 9}, {-7, -1}, {0, 10}, {3, 10}, {3, 6}, {2, 3}};
        int[][] a = {{1, 1000}, {2, 3}, {4, 5}, {6, 7}};
        Solution03 solution03 = new Solution03();
        System.out.println(solution03.findLongestChain(a));
    }
}

class Solution03 {
    public int findLongestChain(int[][] pairs) {
        int curr = Integer.MIN_VALUE, res = 0;
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        for (int[] p : pairs) {
            if (curr < p[0]) {
                curr = p[1];
                res++;
            }
        }
        return res;
    }
}
