package com.wxx.random.year2022.november;

/**
 * @author Xinxin.Wang
 * @since 2022/11/3 9:20
 */
public class Day03 {

    public static void main(String[] args) {
        // cababcabababab
        // ab
        Solution03 solution03 = new Solution03();
        System.out.println(solution03.maxRepeating("cababcabababab", "cab"));
    }
}

class Solution03 {
    public int maxRepeating(String sequence, String word) {
        StringBuilder sb = new StringBuilder(word);
        while (sequence.length() >= word.length()) {
            if (sequence.contains(sb.toString())) {
                sb.append(word);
            } else {
                return (sb.length() - word.length()) / word.length();
            }
        }


        return (sb.length() - word.length()) / word.length();
    }
}
