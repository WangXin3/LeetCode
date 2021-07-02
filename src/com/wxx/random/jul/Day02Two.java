package com.wxx.random.jul;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xinxin.Wang
 * @since 2021/7/2 15:25
 */
public class Day02Two {

    Map<Integer, Integer> map = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        Integer ii = map.get(amount);
        if (ii != null) return ii;

        if (amount == 0) return 0;
        if (amount < 0) return -1;

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int sub = coinChange(coins, amount - coin);
            if (sub == -1) {
                continue;
            }
            res = Math.min(res, sub + 1);
        }
        int i = res == Integer.MAX_VALUE ? -1 : res;
        map.put(amount, i);
        return i;
    }

    public static void main(String[] args) {
        Day02Two day02Two = new Day02Two();
        int[] coins = {1, 3, 5};
        System.out.println(day02Two.coinChange(coins, 11));
    }
}
