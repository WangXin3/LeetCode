package com.wxx.top2025100;

import java.util.Arrays;

/**
 * TODO 未完成
 * @author lenovo
 * @since 2025/12/19 15:33
 */
public class Num239 {
    public static void main(String[] args) {
        Solution239 solution239 = new Solution239();
        System.out.println(Arrays.toString(solution239.maxSlidingWindow(new int[]{1, -1}, 1)));
    }
}

class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        System.arraycopy(nums, 0, ans, 0, ans.length);

        for (int i = 0; i < k; i++) {
            ans[0] = Math.max(nums[i], ans[0]);
        }

        for (int i = 1, j = i + k - 1; j < nums.length; i++, j++) {
            if (ans[i - 1] <= nums[j]) {
                ans[i] = nums[j];
            } else {
                for (int ii = i; ii <= j; ii++) {
                    ans[i] = Math.max(nums[ii], ans[i]);
                }
            }
        }
        return ans;
    }
}
