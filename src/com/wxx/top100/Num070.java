package com.wxx.top100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xinxin.Wang
 * @since 2022/8/4 10:11
 */
public class Num070 {
    public static void main(String[] args) {
        Solution070 solution070 = new Solution070();

        int i = solution070.climbStairs1(2);
        System.out.println("i = " + i);
    }
}

class Solution070 {
    Map<Integer, Integer> map = new HashMap<>();

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        if (map.get(n) != null) {
            return map.get(n);
        }
        int i = climbStairs(n - 2) + climbStairs(n - 1);
        map.put(n, i);
        return i;
    }

    public int climbStairs1(int n) {
        int p = 0;
        int q = 0;
        int r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
