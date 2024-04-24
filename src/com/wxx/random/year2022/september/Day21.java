package com.wxx.random.year2022.september;


import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * @author Xinxin.Wang
 * @since 2022/9/21 15:05
 */
public class Day21 {
    public static void main(String[] args) {
        Solution21 solution21 = new Solution21();
        System.out.println(solution21.kSimilarity("acbcd", "dabcc"));
    }
}

class Solution21 {
    public int kSimilarity(String s1, String s2) {

        return 0;
    }

    public String swap(String cur, int i, int j) {
        char[] arr = cur.toCharArray();
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
        return new String(arr);
    }
}
