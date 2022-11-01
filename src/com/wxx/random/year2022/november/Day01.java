package com.wxx.random.year2022.november;

/**
 * @author Xinxin.Wang
 * @since 2022/11/1 9:23
 */
public class Day01 {
    public static void main(String[] args) {
        Solution01 solution01 = new Solution01();
        String[] a = {"ab", "c"};
        String[] b = {"a", "bc"};

        System.out.println(solution01.arrayStringsAreEqual(a, b));
    }
}

class Solution01 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        return String.join("", word1).equals(String.join("", word2));
    }
}
