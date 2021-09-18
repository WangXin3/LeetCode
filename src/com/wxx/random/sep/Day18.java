package com.wxx.random.sep;

/**
 * @author Xinxin.Wang
 * @since 2021/9/18 9:16
 */
public class Day18 {

    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }

    public static void main(String[] args) {
        Day18 day18 = new Day18();
        System.out.println(day18.canWinNim(9));
    }
}
