package com.wxx.top2025100;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wangxin
 * @since 2025/12/9 10:30
 */
public class Num49 {
    public static void main(String[] args) {
        Solution49 solution49 = new Solution49();
        List<List<String>> lists = solution49.groupAnagrams(new String[]{"cab","tin","pew","duh","may","ill","buy","bar","max","doc"});
        System.out.println(Arrays.toString(lists.toArray()));
    }
}

class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = Arrays.toString(charArray);
            List<String> strings = map.getOrDefault(key, new ArrayList<>());
            strings.add(str);
            map.put(key, strings);
        }

        return new ArrayList<>(map.values());
    }
}