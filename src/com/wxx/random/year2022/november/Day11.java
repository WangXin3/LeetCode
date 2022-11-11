package com.wxx.random.year2022.november;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Xinxin.Wang
 * @since 2022/11/11 9:23
 */
public class Day11 {
    public static void main(String[] args) {
        Solution11 solution11 = new Solution11();
        System.out.println(solution11.halvesAreAlike("textbook"));
    }
}

class Solution11 {
    static Set<Character> characterSet = new HashSet<>();
    static {
        characterSet.add('a');
        characterSet.add('e');
        characterSet.add('i');
        characterSet.add('o');
        characterSet.add('u');
        characterSet.add('A');
        characterSet.add('E');
        characterSet.add('I');
        characterSet.add('O');
        characterSet.add('U');
    }

    public boolean halvesAreAlike(String s) {
        String a = s.substring(0, s.length() / 2);
        String b = s.substring(s.length() / 2);

        int countA = 0;
        int countB = 0;
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();
        for (int i = 0; i < charsA.length; i++) {
            char charA = charsA[i];
            char charB = charsB[i];

            if (characterSet.contains(charA)) {
                countA++;
            }
            if (characterSet.contains(charB)) {
                countB++;
            }
        }

        return countA == countB;
    }
}
