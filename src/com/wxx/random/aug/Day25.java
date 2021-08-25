package com.wxx.random.aug;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Xinxin.Wang
 * @since 2021/8/25 9:20
 */
public class Day25 {

    List<List<Integer>> ans = new ArrayList<>();
    Deque<Integer> stack = new ArrayDeque<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        stack.offerLast(0);
        dfs(graph, 0, graph.length - 1);
        return ans;
    }

    public void dfs(int[][] graph, int x, int n) {
        if (x == n) {
            ans.add(new ArrayList<>(stack));
            return;
        }
        for (int y : graph[x]) {
            stack.offerLast(y);
            dfs(graph, y, n);
            stack.pollLast();
        }
    }

    public static void main(String[] args) {
        Day25 day25 = new Day25();
        int[][] graph = {{1,2},{3},{3},{}};
        List<List<Integer>> lists = day25.allPathsSourceTarget(graph);

        lists.forEach(l -> {
            l.forEach(System.out::print);
            System.out.println();
        });
    }
}
