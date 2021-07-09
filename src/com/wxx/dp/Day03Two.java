package com.wxx.dp;

/**
 * @author Xinxin.Wang
 * @since 2021/7/9 16:24
 */
public class Day03Two {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int length = nums.length;
        if (length == 1) {
            return nums[0];
        } else if (length == 2) {
            return Math.max(nums[0], nums[1]);
        } else {
            return Math.max(robRange(nums, 0, length - 2), robRange(nums, 1, length - 1));
        }


    }

    public int robRange(int[] nums, int start, int end) {
        // first为第一个元素， second为第二个元素
        int first = nums[start], second = Math.max(nums[start], nums[start + 1]);
        //从start + 2开始
        for (int i = start + 2; i <= end; i++) {
            // 因为只需要缓存两个元素
            int temp = second;
            // 取出 （当前元素 + 当前下标-2的值）与 当前下标-1 作比较之后的最大值
            second = Math.max(first + nums[i], second);
            // 将second旧值替换到first上面
            first = temp;
        }
        return second;
    }


    public static void main(String[] args) {
        Day03Two day03Two = new Day03Two();
        int[] a = {2, 3, 2};
        System.out.println(day03Two.rob(a));
    }
}
