package com.wxx.start;

/**
 * @author Xinxin.Wang
 * @since 2021/7/19 15:32
 */
public class Day04Two {

    public String reverseWords1(String s) {
        String[] strings = s.split(" ");

        StringBuilder sb = new StringBuilder();
        for (String string : strings) {
            char[] chars = string.toCharArray();
            reverseString(chars);

            sb.append(chars);
            sb.append(" ");
        }

        return sb.substring(0, sb.length() - 1);
    }

    public void reverseString(char[] s) {

        int left = 0, right = s.length - 1;

        while (left < right) {
            int temp = s[left];
            s[left++] = s[right];
            s[right--] = (char) temp;
        }
    }

    public String reverseWords(String s) {
        StringBuffer ret = new StringBuffer();
        int length = s.length();
        int i = 0;
        while (i < length) {
            int start = i;
            while (i < length && s.charAt(i) != ' ') {
                i++;
            }
            for (int p = start; p < i; p++) {
                ret.append(s.charAt(start + i - 1 - p));
            }
            while (i < length && s.charAt(i) == ' ') {
                i++;
                ret.append(' ');
            }
        }
        return ret.toString();
    }


    public static void main(String[] args) {
        Day04Two day04Two = new Day04Two();
        String s = day04Two.reverseWords("Let's take LeetCode contest");
        System.out.println(s);
    }
}
