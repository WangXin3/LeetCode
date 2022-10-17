package com.wxx.random.year2022.october;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xinxin.Wang
 * @since 2022/10/17 9:47
 */
public class Day17 {
    public static void main(String[] args) {
        Solution17 solution17 = new Solution17();
        // 0 1 1 1 2
        int[] a = {3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(solution17.totalFruit(a));
    }
}

class Solution17 {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();

        int left = 0, ans = 0;
        for (int right = 0; right < n; ++right) {
            cnt.put(fruits[right], cnt.getOrDefault(fruits[right], 0) + 1);
            while (cnt.size() > 2) {
                cnt.put(fruits[left], cnt.get(fruits[left]) - 1);
                if (cnt.get(fruits[left]) == 0) {
                    cnt.remove(fruits[left]);
                }
                ++left;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}


