package com.wxx.random.year2022.august;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Xinxin.Wang
 * @since 2022/8/8 9:25
 */
public class Day08 {
    public static void main(String[] args) {
        Solution08 solution08 = new Solution08();

        System.out.println(solution08.makeLargestSpecial("11011000"));
    }
}

class Solution08 {
    public String makeLargestSpecial(String s) {
        if (s.length() <= 2) {
            return s;
        }

        int cnt = 0;
        int left = 0;
        List<String> subs = new ArrayList<>();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '1') {
                ++cnt;
            } else {
                --cnt;
                if (cnt == 0) {
                    subs.add("1" + makeLargestSpecial(s.substring(left + 1, i)) + "0");
                    left = i + 1;
                }
            }
        }

        subs.sort(Comparator.reverseOrder());
        StringBuilder ans = new StringBuilder();
        for (String sub : subs) {
            ans.append(sub);
        }
        return ans.toString();
    }
}

