package com.wxx.random.year2022.september;

import java.util.Arrays;

/**
 * @author Xinxin.Wang
 * @since 2022/9/7 9:27
 */
public class Day07 {
    public static void main(String[] args) {
        Solution07 solution07 = new Solution07();
        System.out.println(solution07.reorderSpaces("a "));
    }
}

class Solution07 {
    public String reorderSpaces(String text) {
        String[] words = text.split("\\s+");

        int length = text.length();

        words = Arrays.stream(words).filter(s -> !s.equals("")).toArray(String[]::new);
        Integer wordsLength = Arrays.stream(words).map(String::length).mapToInt(value -> value).sum();


        int blankLength = length - wordsLength;
        if (blankLength == 0) {
            return text;
        }

        StringBuilder sb = new StringBuilder();
        int blank = (words.length - 1 == 0) ? blankLength : blankLength / (words.length - 1);
        for (int i = 0; i < words.length; i++) {
            sb.append(words[i]);
            for (int j = 0; j < blank && i < words.length - 1; j++) {
                sb.append(" ");
            }
        }

        int lastBlank = (words.length - 1 == 0) ? blankLength : blankLength % (words.length - 1);
        for (int i = 0; i < lastBlank; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}
