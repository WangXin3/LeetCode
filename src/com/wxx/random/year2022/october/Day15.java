package com.wxx.random.year2022.october;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xinxin.Wang
 * @since 2022/10/17 11:08
 */
public class Day15 {
    public static void main(String[] args) {
        Solution15 solution15 = new Solution15();
        int[] a = {1, 2};
        List<String> list = solution15.buildArray(a, 4);
        list.forEach(System.out::println);
    }
}

class Solution15 {
    public List<String> buildArray(int[] target, int n) {
        List<String> list = new ArrayList<>();
        int j = 0;
        for (int i = 1; i <= n && j < target.length; i++) {
            int val = target[j];
            list.add("Push");
            if (val == i) {
                j++;
            } else {
                list.add("Pop");
            }

        }
        return list;
    }
}
