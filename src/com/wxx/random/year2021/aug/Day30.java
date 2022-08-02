package com.wxx.random.year2021.aug;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Xinxin.Wang
 * @since 2021/8/30 9:35
 */
public class Day30 {

    int[] arr;

    public Day30(int[] w) {
        arr = w;
    }

    public int pickIndex() {
        int sum = Arrays.stream(arr).sum();
        Random random = new Random();
        int i = random.nextInt(sum);
        i += 1;

        int n = 0;
        for (int j = 0; j < arr.length; j++) {
            n += arr[j];
            if (n >= i) {
                return j;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] a = {};

        Day30 day30 = new Day30(a);
        System.out.println(day30.pickIndex());
        System.out.println(day30.pickIndex());
        System.out.println(day30.pickIndex());
        System.out.println(day30.pickIndex());
        System.out.println(day30.pickIndex());
        System.out.println(day30.pickIndex());
    }


}
