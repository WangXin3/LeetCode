package com.wxx.random.year2022.september;

/**
 * @author Xinxin.Wang
 * @since 2022/9/5 15:53
 */
public class Day04 {
    public static void main(String[] args) {
        // 1 0 1 0
        // 0 1 0 0
        // 0 0 0 1

    }
}

class Solution04 {
    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] rowsSum = new int[m];
        int[] colsSum = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowsSum[i] += mat[i][j];
                colsSum[j] += mat[i][j];
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1 && rowsSum[i] == 1 && colsSum[j] == 1) {
                    res++;
                }
            }
        }
        return res;
    }
}
