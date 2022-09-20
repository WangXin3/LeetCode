package com.wxx.random.year2022.september;

import java.util.Arrays;

/**
 * @author Xinxin.Wang
 * @since 2022/9/20 9:23
 */
public class Day20 {
    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();
        int[] a = {1, 1, 1, 1, 2, 2, 2, 2};
        System.out.println(solution20.canPartitionKSubsets(a, 2));
    }
}

class Solution20 {
    int[] nums;
    int per;
    int n;
    boolean[] dp;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        this.nums = nums;
        int all = Arrays.stream(nums).sum();
        if (all % k != 0) {
            return false;
        }
        per = all / k;
        Arrays.sort(nums);
        n = nums.length;
        if (nums[n - 1] > per) {
            return false;
        }
        dp = new boolean[1 << n];
        Arrays.fill(dp, true);
        return dfs((1 << n) - 1, 0);
    }

    public boolean dfs(int s, int p) {
        if (s == 0) {
            return true;
        }
        if (!dp[s]) {
            return dp[s];
        }
        dp[s] = false;
        for (int i = 0; i < n; i++) {
            if (nums[i] + p > per) {
                break;
            }
            if (((s >> i) & 1) != 0) {
                if (dfs(s ^ (1 << i), (p + nums[i]) % per)) {
                    return true;
                }
            }
        }
        return false;
    }
}