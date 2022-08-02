package com.wxx.random.year2021.jul;

import java.util.Arrays;

/**
 * @author Xinxin.Wang
 * @since 2021/7/19 9:30
 */
public class Day19 {

    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        // 操作数
        long total = 0;

        // 左边界为0，结果默认为1，因为只要数组又一个元素，频数最起码为1
        int left = 0, res = 1;
        // 遍历数组，使用滑动窗口
        for (int i = 1; i < nums.length; i++) {
            // total是操作数，要把(i - 1)下标对应的值变为i下表对应的值需要的操作数，操作数不能大于k
            // 要把i下标到left下标的所有元素都变为i下标的元素，需要的操作数
            total += (long) (nums[i] - nums[i - 1]) * (i - left);
            // 如果操作数超过了k，则收缩left
            while (total > k) {
                // 减去需要从left变为i的操作数
                total -= nums[i] - nums[left];
                // 左边界收缩
                left++;
            }
            // 取出最大频数
            res = Math.max(res, i - left + 1);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
