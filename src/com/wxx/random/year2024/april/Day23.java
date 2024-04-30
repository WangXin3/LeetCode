package com.wxx.random.year2024.april;

import java.util.Arrays;

/**
 * @author wangxin
 * @since 2024/4/30 14:36
 */
public class Day23 {

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int max = 0;
        int allCustomer = 0;
        for (int i = 0; i < customers.length; i++) {
            allCustomer += grumpy[i] == 0 ? customers[i] : 0;
        }

        for (int i = 0, j = i + minutes - 1; i <= customers.length - minutes; i++, j++) {
            int sum = allCustomer;
            for (int jj = j; jj >= i; jj--) {
                sum += grumpy[jj] == 1 ? customers[jj] : 0;
            }
            max = Math.max(max, sum);
        }

        return max;
    }

    public static void main(String[] args) {
        Day23 day23 = new Day23();
        int[] customers = new int[]{1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = new int[]{0, 1, 0, 1, 0, 1, 0, 1};
        int minutes = 3;

//        int[] customers = new int[]{1};
//        int[] grumpy = new int[]{0};
//        int minutes = 1;

        System.out.println(day23.maxSatisfied(customers, grumpy, minutes));
    }
}
