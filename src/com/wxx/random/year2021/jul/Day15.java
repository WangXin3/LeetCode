package com.wxx.random.year2021.jul;

import java.util.Arrays;

/**
 * @author Xinxin.Wang
 * @since 2021/7/15 9:22
 */
public class Day15 {

    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);

        int max = 1;
        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(max - arr[i]) <= 1) {
                max = arr[i];
            } else {
                max++;
            }
        }

        return max;
    }


    public static void main(String[] args) {

        Day15 day15 = new Day15();

        int[] a = {3,4,5,6,7,8,9};
        System.out.println(day15.maximumElementAfterDecrementingAndRearranging(a));
    }

}
