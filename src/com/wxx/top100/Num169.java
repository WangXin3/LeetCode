package com.wxx.top100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xinxin.Wang
 * @since 2022/8/3 10:01
 */
public class Num169 {

    public static void main(String[] args) {
        System.out.println(1 / 2);
    }
}

class Solution169 {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return nums[0];
        } else {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.merge(num, 1, Integer::sum);
            }

            Map.Entry<Integer, Integer> result = null;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (result == null || entry.getValue() > result.getValue()) {
                    result = entry;
                }
            }
            return result.getKey();
        }
    }
}
