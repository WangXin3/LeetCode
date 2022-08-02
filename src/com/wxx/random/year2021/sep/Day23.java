package com.wxx.random.year2021.sep;

/**
 * @author Xinxin.Wang
 * @since 2021/9/23 9:17
 */
public class Day23 {

    public boolean isPowerOfThree(int n) {
        while (n != 0 && n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    public static void main(String[] args) {

    }
}
