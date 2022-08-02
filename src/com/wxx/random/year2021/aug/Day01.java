package com.wxx.random.year2021.aug;

import java.util.Arrays;

/**
 * @author wangxin
 * @since 2021/8/1
 */
public class Day01 {

    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        int[][] all = new int[m][1];
        for (int i = 0; i < m; i++) {
            int cur = 0;
            for (int j = 0; j < n; j++) cur += mat[i][j];
            all[i] = new int[]{cur, i};
        }
        Arrays.sort(all, (a, b)->{
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) ans[i] = all[i][1];
        return ans;
    }

    public static void main(String[] args) {

        final Day01 day01 = new Day01();

        int[][] mat = {{1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}};
        final int[] ints = day01.kWeakestRows(mat, 3);
        for (int i : ints) {
            System.out.println(i);
        }
    }
}
