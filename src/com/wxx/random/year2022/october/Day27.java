package com.wxx.random.year2022.october;

/**
 * @author Xinxin.Wang
 * @since 2022/10/27 16:13
 */
public class Day27 {
    public static void main(String[] args) {
        Solution27 solution27 = new Solution27();
        int[] a = {1, 5, 0, 2, -3};
        System.out.println(solution27.arraySign(a));
    }
}

class Solution27 {
    public int arraySign(int[] nums) {
        boolean ans = true;
        for (int num : nums) {
            if (num == 0) {
                return 0;
            }

            if (num < 0) {
                ans = !ans;
            }
        }
        return ans ? 1 : -1;
    }
}
