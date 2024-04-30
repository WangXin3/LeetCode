package com.wxx.random.year2024.april;

import java.util.Arrays;

/**
 * @author wangxin
 * @since 2024/4/30 8:55
 */
public class Day30 {

    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int i = 0 ;
        for (int hour : hours) {
            i += hour >= target ? 1 : 0;
        }
        return i;
    }

    public int numberOfEmployeesWhoMetTarget1(int[] hours, int target) {
        return (int) Arrays.stream(hours).filter(h -> h >= target).count();
    }

    public static void main(String[] args) {

    }
}
