package com.wxx.random.year2022.august;

/**
 * @author Xinxin.Wang
 * @since 2022/8/9 9:15
 */
public class Day09 {
    public static void main(String[] args) {
        Solution09 solution09 = new Solution09();
        System.out.println(solution09.minStartValue(new int[]{1,2}));
    }
}

class Solution09 {
    public int minStartValue(int[] nums) {
        int ans = 1;
        int sum = ans;
        for (int num : nums) {
            // 起始值累加数组元素
            sum += num;

            // 累加之后必须大于等于1
            if (sum < 1) {
                // 如果小于1，则需要调整起始值ans，让sum=1 满足题意，每次累加都要大于等于1
                ans += 1 - sum;
                // 将sum调整为1
                sum = 1;
            }
        }
        return ans;
    }
}