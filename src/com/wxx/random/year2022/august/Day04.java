package com.wxx.random.year2022.august;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Xinxin.Wang
 * @since 2022/8/4 9:53
 */
public class Day04 {
    public static void main(String[] args) {
        int[] a = {6};
        Solution04 solution04 = new Solution04();
        System.out.println(solution04.minSubsequence(a));
    }
}

class Solution04 {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum();
        int result = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            result += nums[i];
            list.add(nums[i]);
            if (result > sum - result) {
                break;
            }
        }
        return list;
    }
}
