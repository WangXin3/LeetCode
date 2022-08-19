package com.wxx.random.year2022.august;

/**
 * @author Xinxin.Wang
 * @since 2022/8/19 9:48
 */
public class Day19 {
    public static void main(String[] args) {
        Solution19 solution19 = new Solution19();
        int[] a = {4};
        int[] b = {4};
        System.out.println(solution19.busyStudent(a, b, 4));
    }
}

class Solution19 {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int ans = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] <= queryTime && endTime[i] >= queryTime) {
                ans++;
            }
        }
        return ans;
    }
}