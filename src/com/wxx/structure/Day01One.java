package com.wxx.structure;

import java.util.Arrays;

/**
 * @author Xinxin.Wang
 * @since 2021/7/19 16:13
 */
public class Day01One {
    public boolean containsDuplicate(int[] nums) {
        return Arrays.stream(nums).distinct().count() != nums.length;
    }

    public static void main(String[] args) {

    }
}
