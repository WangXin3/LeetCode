package com.wxx.random.year2025.april;

/**
 * @author wangxin
 * @since 2025/4/1 10:42
 */
public class Day01 {

    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1]; // 解决每道题及以后题目的最高分数
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], questions[i][0] + dp[Math.min(n, i + questions[i][1] + 1)]);
        }
        return dp[0];
    }

    public static void main(String[] args) {
        Day01 d = new Day01();
        int[][] questions = new int[][]{{21,5}, {92,3}, {74,2}, {39,4}, {58,2}, {5,5}, {49,4}, {65,3}};
        System.out.println(d.mostPoints(questions));
    }
}
