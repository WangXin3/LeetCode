package com.wxx.random.year2022.august;

import java.util.*;

/**
 * @author Xinxin.Wang
 * @since 2022/8/15 10:19
 */
public class Day12 {
    public static void main(String[] args) {
        int[] a = {2, 1, 3, 3, 3, 2};
        Solution12 solution12 = new Solution12();
        solution12.groupThePeople(a).forEach(System.out::println);
    }
}

class Solution12 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        // n个人
        int n = groupSizes.length;

        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int groupSize = groupSizes[i];
            List<Integer> list = map.get(groupSize);
            if (list == null || list.size() == groupSize) {
                list = new ArrayList<>();
            }
            if (list.size() < groupSize) {
                list.add(i);
            }
            map.put(groupSize, list);

            if (list.size() == groupSize) {
                ans.add(list);
            }
        }

        return ans;
    }
}
