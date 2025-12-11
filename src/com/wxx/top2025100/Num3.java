package com.wxx.top2025100;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wangxin
 * @since 2025/12/11 9:12
 */
public class Num3 {
    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.lengthOfLongestSubstring("bbbb"));
    }
}

class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }

        Set<Character> set = new HashSet<>();
        char[] charArray = s.toCharArray();
        int length = charArray.length;
        int sp = 0;
        int fp = sp + 1;
        set.add(charArray[sp]);
        int ans = set.size();
        while (fp < length) {
            if (set.add(charArray[fp])) {
                ans = Math.max(ans, fp - sp + 1);
                fp++;
            } else {
                set.clear();
                sp++;
                set.add(charArray[sp]);
                fp = sp + 1;
            }
        }
        return ans;
    }
}
