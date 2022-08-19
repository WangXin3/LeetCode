package com.wxx.top100;

import java.util.Arrays;

/**
 * @author Xinxin.Wang
 * @since 2022/8/18 14:04
 */
public class Num031 {
    public static void main(String[] args) {
        Solution031 solution031 = new Solution031();
        int[] a = {3, 2, 1};
        // 4, 2, 2, 0, 0, 2, 3
        // 4, 2, 0, 3, 0, 2, 2

        solution031.nextPermutation(a);
        for (int i : a) {
            System.out.print(i);
            System.out.print(", ");
        }
    }
}

class Solution031 {
    public void nextPermutation(int[] nums) {
        int p = nums.length - 1;
        int q = p - 1;

        while (q >= 0 && nums[q] >= nums[q + 1]) {
            q--;
        }

        if (q >= 0) {
            while (p >= 0 && nums[p] <= nums[q]) {
                p--;
            }

            // 交换
            int temp = nums[p];
            nums[p] = nums[q];
            nums[q] = temp;
        }

        // q之后的元素升序排序
        // 给后面的排序
        int[] newNums = new int[nums.length - q - 1];
        System.arraycopy(nums, q + 1, newNums, 0, newNums.length);
        Arrays.sort(newNums);
        System.arraycopy(newNums, 0, nums, q + 1, newNums.length);
    }
}
