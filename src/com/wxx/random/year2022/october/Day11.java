package com.wxx.random.year2022.october;

import java.util.*;

/**
 * @author Xinxin.Wang
 * @since 2022/10/11 9:27
 */
public class Day11 {

    public static void main(String[] args) {
        Solution11 solution11 = new Solution11();
        // "siyolsdcjthwsiplccjbuceoxmpjgrauocx"
        // "siyolsdcjthwsiplccpbuceoxmjjgrauocx"
        System.out.println(solution11.areAlmostEqual("siyolsdcjthwsiplccjbuceoxmpjgrauocx", "siyolsdcjthwsiplccpbuceoxmjjgrauocx"));
    }
}

class Solution11 {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        Map<Character, List<Integer>> s2IndexMap = new HashMap<>();
        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();
        for (int i = 0; i < s2Chars.length; i++) {
            List<Integer> list = s2IndexMap.get(s2Chars[i]);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(i);
            s2IndexMap.put(s2Chars[i], list);
        }

        for (int i = 0; i < s1Chars.length; i++) {
            if (s1Chars[i] != s2Chars[i]) {
                List<Integer> indexList = s2IndexMap.get(s1Chars[i]);
                if (indexList != null) {
                    for (Integer index : indexList) {
                        char temp = s2Chars[i];
                        s2Chars[i] = s2Chars[index];
                        s2Chars[index] = temp;
                        if (s1.equals(new String(s2Chars))) {
                            return true;
                        } else {
                            // 还原数组
                            s2Chars[index] = s2Chars[i];
                            s2Chars[i] = temp;
                        }
                    }
                }
                return false;
            }
        }
        return true;
    }
}
