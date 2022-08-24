package com.wxx.random.year2022.august;

import java.util.Arrays;

/**
 * @author Xinxin.Wang
 * @since 2022/8/24 9:44
 */
public class Day24 {
    public static void main(String[] args) {
        Solution24 solution24 = new Solution24();
        int[] a = {3, 7, 9};
        int[] b = {3, 7, 11};
        System.out.println(solution24.canBeEqual(a, b));
    }
}

class Solution24 {
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        return Arrays.equals(target, arr);
    }
}
