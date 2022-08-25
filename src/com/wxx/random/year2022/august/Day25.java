package com.wxx.random.year2022.august;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Xinxin.Wang
 * @since 2022/8/25 9:14
 */
public class Day25 {
    public static void main(String[] args) {
        Solution25 solution25 = new Solution25();
        // [1,1,1,10,10,10]
        //1
        //9
        int[] a = {1, 1, 1, 10, 10, 10};
        System.out.println(solution25.findClosestElements(a, 1, 9));
    }
}


class Solution25 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // 两数相减的绝对值 代表距离
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }
        list.sort((a, b) -> {
            if (Math.abs(a - x) != Math.abs(b - x)) {
                return Math.abs(a - x) - Math.abs(b - x);
            } else {
                return a - b;
            }
        });
        List<Integer> ans = list.subList(0, k);
        Collections.sort(ans);
        return ans;
    }
}