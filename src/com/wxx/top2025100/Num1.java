package com.wxx.top2025100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangxin
 * @since 2025/12/9 10:16
 */
public class Num1 {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(Arrays.toString(solution1.twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}

class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Integer ii = map.get(num);
            if (ii != null) {
                return new int[]{ii, i};
            } else {
                map.put(target - num, i);
            }
        }
        return null;
    }
}
