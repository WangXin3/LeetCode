package com.wxx.random.year2021.jul;

/**
 * @author Xinxin.Wang
 * @since 2021/7/12 9:10
 */
public class Day12 {

    public int hIndex(int[] citations) {

        int n = citations.length;
        int left = 0, right = n - 1;

        // 0,1,3,4,5,6,7,8,9,10
        while (left <= right) {
            int mid = (right + left) / 2;
            if (citations[mid] >= n - mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return n - left;
    }

    public static void main(String[] args) {
        final Day12 day12 = new Day12();
        int[] a = {0,1,2,3,4,5,6,7,8,9};
        System.out.println(day12.hIndex(a));
    }
}
