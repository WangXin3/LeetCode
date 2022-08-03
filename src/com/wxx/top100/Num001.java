package com.wxx.top100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xinxin.Wang
 * @since 2022/8/3 16:13
 */
public class Num001 {

    public static void main(String[] args) {
        Solution001 solution001 = new Solution001();
        int[] x = solution001.twoSum1(new int[]{1, 2, 3}, 4);
        for (int i : x) {
            System.out.print(i);
        }
    }
}

class Solution001 {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }

        return result;
    }

    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            Integer j = map.get(target - nums[i]);
            if (j != null) {
                return new int[]{i, j};
            }
        }

        return new int[0];
    }
}
