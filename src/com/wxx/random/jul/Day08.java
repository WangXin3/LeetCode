package com.wxx.random.jul;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xinxin.Wang
 * @since 2021/7/8 9:18
 */
public class Day08 {

    public int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        for (int num : nums) {
            map.merge(sum, 1, Integer::sum);
            sum += num;
            count += map.getOrDefault(sum - goal, 0);
        }


        return count;
    }

    public static void main(String[] args) {

    }
}
