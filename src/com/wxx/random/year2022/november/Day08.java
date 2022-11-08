package com.wxx.random.year2022.november;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Xinxin.Wang
 * @since 2022/11/8 9:22
 */
public class Day08 {

    public static void main(String[] args) {
        Solution08 solution08 = new Solution08();
        String allowed = "cad";
        String[] words = {"cc", "acd", "b", "ba", "bac", "bad", "ac", "d"};
        System.out.println(solution08.countConsistentStrings1(allowed, words));
    }
}

class Solution08 {
    public int countConsistentStrings(String allowed, String[] words) {
        int ans = 0;
        char[] allowedChars = allowed.toCharArray();
        Set<Character> allowedSet = new HashSet<>();
        for (char allowedChar : allowedChars) {
            allowedSet.add(allowedChar);
        }

        for (String word : words) {
            char[] chars = word.toCharArray();
            Set<Character> objects = new HashSet<>();
            for (char aChar : chars) {
                objects.add(aChar);
            }

            if (allowedSet.containsAll(objects)) {
                ans++;
            }

        }

        return ans;
    }

    public int countConsistentStrings1(String allowed, String[] words) {
        int mask = 0;
        for (int i = 0; i < allowed.length(); i++) {
            char c = allowed.charAt(i);
            mask |= 1 << (c - 'a');
        }
        int res = 0;
        for (String word : words) {
            int mask1 = 0;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                mask1 |= 1 << (c - 'a');
            }
            if ((mask1 | mask) == mask) {
                res++;
            }
        }
        return res;
    }
}
