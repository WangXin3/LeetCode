package com.wxx.random.jul;

import java.util.Arrays;

/**
 * @author Xinxin.Wang
 * @since 2021/7/2 13:29
 */
public class Day02 {

    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);

        int count = 0;
        for (int i : costs) {
            coins -= i;
            if (coins >= 0) {
                count++;
            } else {
                // 在coins小于0时退出循环，以免继续执行循环
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Day02 day02 = new Day02();
        int[] costs = {1,6,3,1,2,5};
        System.out.println(day02.maxIceCream(costs, 20));
    }
}
