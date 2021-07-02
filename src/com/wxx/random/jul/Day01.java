package com.wxx.random.jul;

import com.wxx.utils.ListNode;

import java.util.*;

/**
 * @author Xinxin.Wang
 * @since 2021/7/2 13:48
 */
public class Day01 {


    int ways, n, k;
    Map<Integer, List<Integer>> map = new HashMap<>();


    /**
     * 2 <= n <= 10
     * 1 <= k <= 5
     * 1 <= relation.length <= 90, 且 relation{i}.length == 2
     * 0 <= relation{i}{0},relation{i}{1} < n 且 relation{i}{0} != relation{i}{1}
     *
     * @param n        /
     * @param relation /
     * @param k        /
     * @return /
     */
    public int numWays(int n, int[][] relation, int k) {
        this.n = n;
        this.k = k;
        this.ways = 0;

        for (int[] ints : relation) {
            int form = ints[0];
            int to = ints[1];

            List<Integer> list = map.get(form);
            if (list == null) {
                List<Integer> array = new ArrayList<>();
                array.add(to);
                map.put(form, array);
            } else {
                list.add(to);
            }
        }

        dfs(0, 0);
        return this.ways;
    }

    /**
     * 如果等于k，则满足题干，再去判断index是否到了终点（n-1），如果到了，则路线+1
     * @param index 当前点
     * @param steps 走了几步了，
     */
    public void dfs(int index, int steps) {
        if (steps == k) {
            if (index == n - 1) {
                this.ways++;
            }
            return;
        }
        List<Integer> list = map.get(index);
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int nextIndex : list) {
            dfs(nextIndex, steps + 1);
        }
    }

    public static void main(String[] args) {
        Day01 day01 = new Day01();

        int[][] relation = {{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}};
        System.out.println(day01.numWays(5, relation, 3));
    }

}
