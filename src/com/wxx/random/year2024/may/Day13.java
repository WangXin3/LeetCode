package com.wxx.random.year2024.may;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * @author wangxin
 * @since 2024/5/13 11:05
 */
public class Day13 {

    int[] dr = new int[]{-1, 0, 1, 0};
    int[] dc = new int[]{0, -1, 0, 1};

    public int orangesRotting(int[][] grid) {
        int rr = grid.length, cc = grid[0].length;
        Queue<Integer> queue = new ArrayDeque<>();
        Map<Integer, Integer> depth = new HashMap<>();
        for (int r = 0; r < rr; ++r) {
            for (int c = 0; c < cc; ++c) {
                if (grid[r][c] == 2) {
                    int code = r * cc + c;
                    queue.add(code);
                    depth.put(code, 0);
                }
            }
        }
        int ans = 0;
        while (!queue.isEmpty()) {
            int code = queue.remove();
            int r = code / cc, c = code % cc;
            for (int k = 0; k < 4; ++k) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (0 <= nr && nr < rr && 0 <= nc && nc < cc && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2;
                    int nCode = nr * cc + nc;
                    queue.add(nCode);
                    depth.put(nCode, depth.get(code) + 1);
                    ans = depth.get(nCode);
                }
            }
        }
        for (int[] row : grid) {
            for (int v : row) {
                if (v == 1) {
                    return -1;
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {

    }
}
