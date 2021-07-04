package com.wxx.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangxin
 * @since 2021/7/3
 */
public class Day02One {

    Map<Integer, Integer> map = new HashMap<>();
    public int climbStairs(int n) {
        Integer ii = map.get(n);
        if (ii != null) {
            return ii;
        }

        if (n <= 2) {
            return n;
        }

        int i = climbStairs(n - 1) + climbStairs(n - 2);
        map.put(n, i);
        return i;
    }

    public static void main(String[] args) {
        Day02One day02One = new Day02One();
        System.out.println(day02One.climbStairs(4));
    }

}
