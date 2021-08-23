package com.wxx.random.aug;

import java.util.Arrays;

/**
 * @author Xinxin.Wang
 * @since 2021/8/23 9:34
 */
public class Day23 {

    public int getMaximumGenerated(int n) {
        /**
         * nums[0] = 0
         * nums[1] = 1
         * 当 2 <= 2 * i <= n 时，nums[2 * i] = nums[i]
         * 当 2 <= 2 * i + 1 <= n 时，nums[2 * i + 1] = nums[i] + nums[i + 1]
         */
        if (n == 0) {
            return 0;
        }
        int[] nums = new int[n + 1];
        nums[1] = 1;
        for (int i = 2; i <= n; ++i) {
            nums[i] = nums[i / 2] + i % 2 * nums[i / 2 + 1];
        }

        return Arrays.stream(nums).max().getAsInt();
    }

    public static void main(String[] args) {
        Day23 day23 = new Day23();
        System.out.println(day23.getMaximumGenerated(11));
    }
}
