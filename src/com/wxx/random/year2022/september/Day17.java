package com.wxx.random.year2022.september;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xinxin.Wang
 * @since 2022/9/19 9:56
 */
public class Day17 {
    public static void main(String[] args) {
        Solution17 solution17 = new Solution17();
        System.out.println(solution17.maxLengthBetweenEqualCharacters("cabbac"));
    }
}

class Solution17 {
    public int maxLengthBetweenEqualCharacters(String s) {
        char[] chars = s.toCharArray();
        int max = -1;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            Character c = chars[i];
            Integer beforeIndex = map.get(c);
            if (beforeIndex == null) {
                map.put(c, i);
            } else {
                max = Math.max(max, i - beforeIndex - 1);
            }
        }
        return max;
    }
}
