package com.wxx.random.jul;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author wangxin
 * @since 2021/7/11
 */
public class Day11 {

    public int hIndex(int[] citations) {
        Arrays.sort(citations);

        int h = 0, i = citations.length - 1;
        while (i >= 0 && citations[i] > h) {
            h++;
            i--;
        }
        return h;
    }

    public static void main(String[] args) {

        final Day11 day11 = new Day11();
        int[] a = {3,0,6,1,5};
        System.out.println(day11.hIndex(a));
    }
}
