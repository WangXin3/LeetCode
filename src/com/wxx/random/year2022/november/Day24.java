package com.wxx.random.year2022.november;

/**
 * @author Xinxin.Wang
 * @since 2022/11/24 8:59
 */
public class Day24 {

    public static void main(String[] args) {
        Solution24 solution24 = new Solution24();
        int[] a = {2, 1, 4, 3};
        System.out.println(solution24.numSubarrayBoundedMax(a, 2, 3));
    }
}


class Solution24 {


    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int res = 0, last2 = -1, last1 = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= left && nums[i] <= right) {
                last1 = i;
            } else if (nums[i] > right) {
                last2 = i;
                last1 = -1;
            }
            if (last1 != -1) {
                res += last1 - last2;
            }
        }
        return res;
    }

}