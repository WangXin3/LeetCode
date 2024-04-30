package com.wxx.random.year2024.april;

/**
 * @author wangxin
 * @since 2024/4/29 16:04
 */
public class Day27 {

    public int[] findColumnWidth(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < n; i++) { // 列
            grid[0][i] = this.length(grid[0][i]);
            for (int j = 1; j < m; j++) { // 行
                grid[0][i] = Math.max(this.length(grid[j][i]), grid[0][i]);
            }
        }
        return grid[0];
    }

    private int length(int num) {
        int len = num <= 0 ? 1 : 0;
        while (num != 0) {
            num /= 10;
            len++;
        }
        return len;
    }

    public static void main(String[] args) {
        Day27 day27 = new Day27();
//        int[][] grid = new int[][]{{-15, 1, 3}, {15, 7, 12}, {5, 6, -2}};
        int[][] grid = new int[][]{{-15}};
        int[] columnWidth = day27.findColumnWidth(grid);
        System.out.println(columnWidth);

    }
}
