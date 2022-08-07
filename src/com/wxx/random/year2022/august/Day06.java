package com.wxx.random.year2022.august;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author wangxin
 * @since 2022/8/7
 */
public class Day06 {

    public static void main(String[] args) {
        Solution06 solution06 = new Solution06();
        System.out.println(solution06.stringMatching(new String[]{"blue","green","bu"}));
    }
}

class Solution06 {
    public List<String> stringMatching(String[] words) {
        Set<String> ans = new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                String first = words[i];
                String second = words[j];
                if (first.contains(second)) {
                    ans.add(second);
                }

                if (second.contains(first)) {
                    ans.add(first);
                }
            }
        }
        return new ArrayList<>(ans);
    }
}
