package com.wxx.random.year2022.september;

/**
 * @author Xinxin.Wang
 * @since 2022/9/29 9:08
 */
public class Day29 {
    public static void main(String[] args) {
        Solution29 solution29 = new Solution29();

        System.out.println(solution29.isFlipedString("aba", "aa"));
    }
}

class Solution29 {
    public boolean isFlipedString(String s1, String s2) {
        return s1.length() == s2.length() && (s1 + s1).contains(s2);
    }
}
