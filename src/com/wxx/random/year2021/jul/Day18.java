package com.wxx.random.year2021.jul;

import java.util.*;

/**
 * @author wangxin
 * @since 2021/7/18
 */
public class Day18 {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            String mapKey = Arrays.toString(chars);
            List<String> mapList = map.getOrDefault(mapKey, new ArrayList<>());
            mapList.add(str);
            map.put(mapKey, mapList);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {

        final Day18 day18 = new Day18();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        // [["doc"],["max"],["bar"],["tin"],["buy"],["cab"],["ill"],["duh"],["pew"],["may"]]
        day18.groupAnagrams(strs);
    }
}
