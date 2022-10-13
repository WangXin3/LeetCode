package com.wxx.random.year2022.september;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Xinxin.Wang
 * @since 2022/10/13 15:17
 */
public class Day30 {
    public static void main(String[] args) {
        int[][] m = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        Solution30 solution30 = new Solution30();
        solution30.setZeroes(m);
        System.out.println(m.length);
    }
}

class Solution30 {
    public void setZeroes(int[][] matrix) {
        int x = matrix.length;
        int y = matrix[0].length;

        Set<Integer> xSet = new HashSet<>();
        Set<Integer> ySet = new HashSet<>();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (matrix[i][j] == 0) {
                    xSet.add(i);
                    ySet.add(j);
                }
            }
        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (xSet.contains(i)) {
                    matrix[i][j] = 0;
                }
                if (ySet.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
