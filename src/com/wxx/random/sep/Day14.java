package com.wxx.random.sep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Xinxin.Wang
 * @since 2021/9/14 9:27
 */
public class Day14 {

    public String findLongestWord(String s, List<String> dictionary) {
        String res = "";
        for (String t : dictionary) {
            int i = 0, j = 0;
            while (i < t.length() && j < s.length()) {
                if (t.charAt(i) == s.charAt(j)) {
                    ++i;
                }
                ++j;
            }
            if (i == t.length()) {
                if (t.length() > res.length() || (t.length() == res.length() && t.compareTo(res) < 0)) {
                    res = t;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Day14 day14 = new Day14();

        List<String> list = new ArrayList<>();
        list.add("ale");
        list.add("apple");
        list.add("monkey");
        list.add("abpcple");

        System.out.println(day14.findLongestWord("abpcplea", list));
    }
}
