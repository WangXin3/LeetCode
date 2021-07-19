package com.wxx.start;

/**
 * @author Xinxin.Wang
 * @since 2021/7/19 15:25
 */
public class Day04One {

    public void reverseString(char[] s) {

        int left = 0, right = s.length - 1;

        while (left < right) {
            int temp = s[left];
            s[left++] = s[right];
            s[right--] = (char) temp;
        }
    }



    public static void main(String[] args) {

        Day04One day04One = new Day04One();
        char[] a = {'H','a','n','n','a','h'};
        day04One.reverseString(a);
        for (char c : a) {
            System.out.print("'" + c + "', ");
        }
    }
}
