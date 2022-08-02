package com.wxx.random.year2021.aug;

/**
 * @author Xinxin.Wang
 * @since 2021/8/20 9:19
 */
public class Day20 {

    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; i += 2 * k) {
            // 每隔k个翻转一次，k个翻转，k个不翻转，k个翻转，k个不翻转,......
            reverseArray(i, Math.min(i + k, n) - 1, arr);
        }
        return new String(arr);
    }


    public char[] reverseArray(int start, int end, char[] chars) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }

        return chars;
    }

    public static void main(String[] args) {
        Day20 day20 = new Day20();
        System.out.println(day20.reverseStr("abcdefg", 2));
    }
}
