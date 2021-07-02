package com.wxx.dp;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * @author Xinxin.Wang
 * @since 2021/7/2 14:44
 */
public class Day01One {

    /**
     * 暴力破解，性能较差
     * @param n /
     * @return /
     */
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        Day01One day01One = new Day01One();
        System.out.println(day01One.fib2(30));
    }

    Map<Integer, Integer> map = new HashMap<>();

    /**
     * 将计算出来的值进行缓存
     * 性能较好
     * @param n /
     * @return /
     */
    public int fib2(int n) {
        Integer result = map.get(n);
        if (result != null) {
            return result;
        }

        if (n <= 1) {
            return n;
        }
        if (n == 2) {
            return 1;
        }

        int i = fib2(n - 1) + fib(n - 2);
        map.put(n, i);
        return i;
    }
}
