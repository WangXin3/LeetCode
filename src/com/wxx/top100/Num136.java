package com.wxx.top100;

/**
 * @author Xinxin.Wang
 * @since 2022/8/2 16:07
 */
public class Num136 {

    public static void main(String[] args) {
        System.out.println(~10);
    }
}

class Solution136 {
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
