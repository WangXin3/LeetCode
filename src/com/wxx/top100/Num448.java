package com.wxx.top100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xinxin.Wang
 * @since 2022/8/4 13:54
 */
public class Num448 {
    public static void main(String[] args) {
        Solution448 solution448 = new Solution448();
        List<Integer> disappearedNumbers = solution448.findDisappearedNumbers1(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        System.out.println(disappearedNumbers);
    }
}

class Solution448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        for (int i = 0; i < n; i++) {
            int finalI = i;
            list.removeIf(ii -> ii.equals(nums[finalI]));
        }

        return list;
    }

    public List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;

        for (int num : nums) {
            int x = (num - 1) % n;
            nums[x] += n;
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                list.add(i + 1);
            }
        }

        return list;
    }
}
