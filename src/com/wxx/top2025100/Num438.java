package com.wxx.top2025100;

import java.util.*;

/**
 * @author wangxin
 * @since 2025/12/11 10:30
 */
public class Num438 {
    public static void main(String[] args) {
        Solution438 solution438 = new Solution438();
        List<Integer> anagrams = solution438.findAnagrams("cbaebabacd", "abc");
        System.out.println(Arrays.toString(anagrams.toArray()));
    }
}

class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        int pLength = p.length();
        int sLength = s.length();
        if (sLength < pLength) {
            return Collections.emptyList();
        }

        List<Integer> ans = new ArrayList<>();
        int[] sArray = new int[26];
        int[] pArray = new int[26];

        for (int i = 0; i < pLength; i++) {
            pArray[p.charAt(i) - 'a']++;
            sArray[s.charAt(i) - 'a']++;
        }

        for (int i = 0, j = i + pLength - 1; j < sLength; i++, j = (i + pLength - 1)) {
            if (Arrays.equals(sArray, pArray)) {
                ans.add(i);
            }

            sArray[s.charAt(i) - 'a']--;
            if (j + 1 < sLength) {
                sArray[s.charAt(j + 1) - 'a']++;
            } else {
                break;
            }
        }

        return ans;
    }
}