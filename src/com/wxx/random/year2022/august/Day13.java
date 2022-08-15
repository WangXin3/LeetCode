package com.wxx.random.year2022.august;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Xinxin.Wang
 * @since 2022/8/15 10:40
 */
public class Day13 {
    public static void main(String[] args) {
        Solution13 solution13 = new Solution13();
        int[] a = {2, 1, 3, 4, 4};
        System.out.println(solution13.maxChunksToSorted(a));
    }
}

class Solution13 {
    public int maxChunksToSorted(int[] arr) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int res = 0;
        int[] sortedArr = new int[arr.length];
        System.arraycopy(arr, 0, sortedArr, 0, arr.length);
        Arrays.sort(sortedArr);
        for (int i = 0; i < sortedArr.length; i++) {
            int x = arr[i];
            int y = sortedArr[i];
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
            if (cnt.get(x) == 0) {
                cnt.remove(x);
            }
            cnt.put(y, cnt.getOrDefault(y, 0) - 1);
            if (cnt.get(y) == 0) {
                cnt.remove(y);
            }
            if (cnt.isEmpty()) {
                res++;
            }
        }
        return res;
    }
}
