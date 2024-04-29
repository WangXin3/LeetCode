package com.wxx.random.year2024.april;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author wangxin
 * @since 2024/4/29 9:51
 */
public class Day29 {

    public int[][] diagonalSort(int[][] mat) {
        // 行长度
        int m = mat.length;
        // 列长度
        int n = mat[0].length;

        for (int i = 0; i < m; i++) {
            List<Integer> list = new ArrayList<>();
            int tempI = i;
            for (int j = 0; j < n && tempI < m; j++, tempI++) {
                list.add(mat[tempI][j]);
            }
            list.sort(Comparator.comparingInt(value -> value));

            Queue<Integer> queue = new ArrayDeque<>(list);
            tempI = i;
            for (int j = 0; j < n && tempI < m; j++, tempI++) {
                mat[tempI][j] = queue.poll();
            }
        }

        for (int i = 1; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            int tempI = i;
            for (int j = 0; j < m && tempI < n; j++, tempI++) {
                list.add(mat[j][tempI]);
            }
            list.sort(Comparator.comparingInt(value -> value));

            Queue<Integer> queue = new ArrayDeque<>(list);
            tempI = i;
            for (int j = 0; j < m && tempI < n; j++, tempI++) {
                mat[j][tempI] = queue.poll();
            }
        }
        return mat;
    }

    public int[][] diagonalSort1(int[][] mat) {
        // 行长度
        int m = mat.length;
        // 列长度
        int n = mat[0].length;

        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    String key = i + "_" + j;
                    List<Integer> list = map.getOrDefault(key, new ArrayList<>());
                    list.add(mat[i][j]);
                    map.put(key, list);
                } else {
                    int min = Math.min(i, j);
                    List<Integer> list = map.get((i - min) + "_" + (j - min));
                    list.add(mat[i][j]);
                }
            }
        }


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {

                    String key = i + "_" + j;
                    List<Integer> list = map.get(key);
                    list.sort(Comparator.comparingInt(v -> v));

                    mat[i][j] = list.get(0);
                    list.remove(0);
                } else {
                    int min = Math.min(i, j);
                    List<Integer> list = map.get((i - min) + "_" + (j - min));
                    mat[i][j] = list.get(0);
                    list.remove(0);
                }
            }
        }

        return mat;
    }

    public static void main(String[] args) {
        Day29 day29 = new Day29();

//        int[][] mat = new int[][]{{3, 3, 1, 1}, {2, 2, 1, 2}, {1, 1, 1, 2}};
        int[][] mat = new int[][]{
                {11, 25, 66,  1, 69,  7},
                {23, 55, 17, 45, 15, 52},
                {75, 31, 36, 44, 58,  8},
                {22, 27, 33, 25, 68,  4},
                {84, 28, 14, 11,  5, 50}
        };
        int[][] x = day29.diagonalSort(mat);
        System.out.println(x);

    }
}
