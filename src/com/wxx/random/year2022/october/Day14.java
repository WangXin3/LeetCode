package com.wxx.random.year2022.october;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Xinxin.Wang
 * @since 2022/10/14 9:17
 */
public class Day14 {

    public static void main(String[] args) {
        // abcd
        // a、ab、ac、ad、abc、abd、abcd、b、bc、bd、bcd、c、cd、d

        // abc
        Solution14 solution14 = new Solution14();
        System.out.println(solution14.distinctSubseqII1("asdfasdgasdgasdfwefasdfasdgas"));
    }
}

class Solution14 {

    /**
     * 太慢了 虽然实现了功能
     *
     * @param s
     * @return
     */
    public int distinctSubseqII(String s) {
        Set<String> sub = getSub(s);
        return sub.size() % (10 ^ 9 + 7);
    }


    public Set<String> getSub(String s) {
        Set<String> set = new HashSet<>();
        if (s.length() == 1) {
            set.add(s);
            return set;
        } else {
            String first = s.substring(0, 1);
            Set<String> sub = getSub(s.substring(1));
            set.addAll(sub);
            set.add(first);
            for (String s1 : sub) {
                set.add(first.concat(s1));
            }
        }
        return set;
    }

    public int distinctSubseqII1(String s) {
        final int MOD = 1000000007;
        int[] last = new int[26];
        Arrays.fill(last, -1);

        int n = s.length();
        int[] f = new int[n];
        Arrays.fill(f, 1);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < 26; ++j) {
                if (last[j] != -1) {
                    f[i] = (f[i] + f[last[j]]) % MOD;
                }
            }
            last[s.charAt(i) - 'a'] = i;
        }

        int ans = 0;
        for (int i = 0; i < 26; ++i) {
            if (last[i] != -1) {
                ans = (ans + f[last[i]]) % MOD;
            }
        }
        return ans;
    }
}
