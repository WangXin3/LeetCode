package com.wxx.start;

/**
 * @author Xinxin.Wang
 * @since 2021/7/19 14:09
 */
public class Day03One {

    public void moveZeroes1(int[] nums) {
        /**
         * 输入: [0,1,0,3,12,4,0,5]
         * right = 0， left = 0
         * left遇到0，翻转left到right，right--
         * [5,0,4,12,3,0,1,0]
         * 翻转left到right, left++
         * [1,0,3,12,4,0,5,0]
         * left遇到0，翻转left到right， right--
         * [1,5,0,4,12,3,0,0]
         * 翻转left到right
         * [1,3,12,4,0,5,0,0]
         * left遇到0，翻转left到right，right--
         * [1,3,12,4,5,0,0,0]
         * left==right 不用翻转，return
         *
         * 输出: [1,3,12,4,5,0,0,0]
         */

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int num = nums[left];
            if (num == 0) {
                reverse(nums, left, right--);

                if (left != right) {
                    reverse(nums, left, right);
                } else {
                    return;
                }
            } else {
                left++;
            }
        }
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }

    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }



    public static void main(String[] args) {
        Day03One day03One = new Day03One();
        int[] nums = {0,0,1};
        day03One.moveZeroes(nums);

        for (int num : nums) {
            System.out.print(num + ",");
        }
    }

}
