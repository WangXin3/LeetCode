package com.wxx.random.year2021.jul;

/**
 * @author Xinxin.Wang
 * @since 2021/7/30 9:14
 */
public class Day30 {

    public int titleToNumber(String columnTitle) {
        char[] charArray = columnTitle.toCharArray();
        int res = 0;
        for (char c : charArray) {
            res = res * 26 + (c - 'A' + 1);
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
