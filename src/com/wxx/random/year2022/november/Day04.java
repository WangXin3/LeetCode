package com.wxx.random.year2022.november;

/**
 * @author Xinxin.Wang
 * @since 2022/11/4 9:15
 */
public class Day04 {
    public static void main(String[] args) {
        Solution04 solution04 = new Solution04();
        System.out.println(solution04.reachNumber(2));
    }
}

class Solution04 {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int k = 0;
        while (target > 0) {
            k++;
            target -= k;
        }
        return target % 2 == 0 ? k : k + 1 + k % 2;
    }
}
