package com.wxx.random.year2022.november;

/**
 * @author Xinxin.Wang
 * @since 2022/11/29 16:40
 */
public class Day29 {
    public static void main(String[] args) {

    }
}

class Solution29 {
    public int minOperations(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != (char) ('0' + i % 2)) {
                cnt++;
            }
        }
        return Math.min(cnt, s.length() - cnt);
    }
}
