package com.wxx.top2025100;

import java.util.*;

/**
 * @author wangxin
 * @since 2025/12/10 9:40
 */
public class Num15 {
    public static void main(String[] args) {
        Solution15 solution15 = new Solution15();
        List<List<Integer>> lists = solution15.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        // [-4, -1, -1, 0, 1, 2]
        System.out.println(lists.toString());
    }
}

class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        for (int a = 0; a < n; a++) {
            // 如果当前位的数和前一位相同，则跳过
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }

            int c = n - 1;
            int target = -nums[a];

            for (int b = a + 1; b < n; b++) {
                // 如果当前位的数和前一位相同，则跳过
                if (b > a + 1 && nums[b] == nums[b - 1]) {
                    continue;
                }

                while (b < c && nums[b] + nums[c] > target) {
                    c--;
                }
                if (b == c) {
                    break;
                }
                if (nums[b] + nums[c] == target) {
                    ans.add(List.of(nums[a], nums[b], nums[c]));
                }
            }
        }
        return ans;
    }
}
