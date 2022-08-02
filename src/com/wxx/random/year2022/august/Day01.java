package com.wxx.random.year2022.august;

/**
 * @author Xinxin.Wang
 * @since 2022/8/2 14:28
 */
public class Day01 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.generateTheString(500);
        System.out.println(s);
    }
}

class Solution {
    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = n; i > 0; i--) {
            sb.append("a");
        }

        if (n % 2 == 0) {
            // 偶数
            sb.replace(n - 1, n, "b");
        }
        return sb.toString();
    }
}