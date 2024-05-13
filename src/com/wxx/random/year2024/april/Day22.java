package com.wxx.random.year2024.april;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangxin
 * @since 2024/4/30 16:28
 */
public class Day22 {
    public int combinationSum4(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        // 可能性
        for (int num : nums) {
            int i = target - num;
            Integer c = map.get(i);
            if (c == null) {

            }
        }


        return 0;
    }


    public static void main(String[] args) {

    }
}
