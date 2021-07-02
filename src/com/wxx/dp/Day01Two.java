package com.wxx.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xinxin.Wang
 * @since 2021/7/2 15:08
 */
public class Day01Two {

    Map<Integer, Integer> map = new HashMap<>();
    public int tribonacci(int n) {
        Integer result = map.get(n);
        if (result != null) {
            return result;
        }

        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        int i = tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
        map.put(n, i);
        return i;
    }

    public static void main(String[] args) {
        Day01Two day01Two = new Day01Two();
        System.out.println(day01Two.tribonacci(25));
    }
}
