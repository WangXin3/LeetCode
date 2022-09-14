package com.wxx.random.year2022.september;

import java.util.Arrays;

/**
 * @author Xinxin.Wang
 * @since 2022/9/14 9:09
 */
public class Day14 {
    public static void main(String[] args) {
        Solution14 solution14 = new Solution14();
        int[] a = {9,7,8,7,7,8,4,4,6,8,8,7,6,8,8,9,2,6,0,0,1,10,8,6,3,3,5,1,10,9,0,7,10,0,10,4,1,10,6,9,3,6,0,0,2,7,0,6,7,2,9,7,7,3,0,1,6,1,10,3};
        System.out.println(solution14.trimMean(a));
    }
}

class Solution14 {
    public double trimMean(int[] arr) {
        int length = arr.length;
        Arrays.sort(arr);
        int v = (int) (length * 0.05);

        int sum = 0;
        for (int i = v; i < length - v; i++) {
            sum += arr[i];
        }

        return (double) sum / (length - (2 * v));
    }
}

