package com.wxx.top100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Xinxin.Wang
 * @since 2022/8/11 15:27
 */
public class Num017 {
    public static void main(String[] args) {
        Solution017 solution017 = new Solution017();
        List<String> list = solution017.letterCombinations("234");
        list.forEach(System.out::println);

    }
}

class Solution017 {

public List<String> letterCombinations(String digits) {
    if (digits.length() == 0) return Collections.emptyList();

    List<String> list = new ArrayList<>();
    char[][] charMap = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
    for (int i = 0; i < digits.length(); i++) {
        int c = digits.charAt(i);
        c -= 48;
        char[] chars = charMap[c - 2];

        boolean empty = list.isEmpty();
        // g h i
        List<String> newList = new ArrayList<>(list);
        list.clear();
        for (char aChar : chars) {
            if (empty) {
                list.add(String.valueOf(aChar));
            } else {
                for (String s : newList) {
                    list.add(s.concat(String.valueOf(aChar)));
                }
            }
        }
    }
    return list;
}
}

