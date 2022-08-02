package com.wxx.random.year2021.aug;

import java.util.Arrays;

/**
 * @author Xinxin.Wang
 * @since 2021/8/31 9:23
 */
public class Day31 {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] result = new int[n];

        for (int[] booking : bookings) {
            int first = booking[0];
            int last = booking[1];
            int seats = booking[2];
            for (int j = first - 1; j < last; j++) {
                result[j] += seats;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Day31 day31 = new Day31();

        int[][] bookings = {{1,2,10},{2,2,15}};

        Arrays.stream(day31.corpFlightBookings(bookings, 2)).forEach(System.out::println);
    }
}
