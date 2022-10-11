package com.wxx.random.year2022.october;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Xinxin.Wang
 * @since 2022/10/11 16:39
 */
public class Day07 {
    public static void main(String[] args) {
        Solution07 solution07 = new Solution07();
        int[] a = {6};
        System.out.println(solution07.maxAscendingSum(a));
    }
}

class Solution07 {
    public int maxAscendingSum(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        List<int[]> list = new ArrayList<>();

        int prevIndex = 0;
        int currIndex;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            currIndex = i;
            if (curr <= prev) {
                int[] ints = Arrays.copyOfRange(nums, prevIndex, currIndex);
                list.add(ints);
                prevIndex = currIndex;
            }

            if (i == nums.length - 1) {
                int[] ints = Arrays.copyOfRange(nums, prevIndex, nums.length);
                list.add(ints);
            }
            prev = curr;
        }

        return list.stream().map(ints -> Arrays.stream(ints).sum()).max(Comparator.comparingInt(o -> o)).get();
    }
}
