package com.wxx.start;

/**
 * @author Xinxin.Wang
 * @since 2021/7/15 16:32
 */
public class Day01Two {

    public int firstBadVersion(int n) {
        if (n == 1) return 1;

        int left = 1;
        int right = n;

        while (left < right) { // 循环直至区间左右端点相同
            int mid = left + (right - left) / 2; // 防止计算时溢出
            if (isBadVersion(mid)) {
                right = mid; // 答案在区间 [left, mid] 中
            } else {
                left = mid + 1; // 答案在区间 [mid+1, right] 中
            }
        }
        // 此时有 left == right，区间缩为一个点，即为答案
        return left;
    }

    /**
     * version 是否在单元测试中出错
     * @param n /
     * @return /
     */
    public boolean isBadVersion(int n) {
        if (n > 2) {
            return true;
        } else return n == 2;
    }

    public static void main(String[] args) {
        // 1,2,3,4,5,6,7,8,9,10,11,12,13

        Day01Two day01Two = new Day01Two();
        System.out.println(day01Two.firstBadVersion(13));
    }
}
