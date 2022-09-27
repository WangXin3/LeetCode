package com.wxx.random.year2022.september;

import java.util.Arrays;

/**
 * @author Xinxin.Wang
 * @since 2022/9/27 9:44
 */
public class Day27 {
    public static void main(String[] args) {
        // bac   acb
        // aba   abc
        Solution27 solution27 = new Solution27();
        System.out.println(solution27.CheckPermutation("aba", "acb"));
    }
}

class Solution27 {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }

        if (s1.equals(s2)) {
            return true;
        }

        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();
        Arrays.sort(s1Array);
        Arrays.sort(s2Array);

        return Arrays.equals(s1Array, s2Array);
    }
}