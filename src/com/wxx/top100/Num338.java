package com.wxx.top100;

/**
 * @author Xinxin.Wang
 * @since 2022/8/4 11:00
 */
public class Num338 {
    public static void main(String[] args) {
        Solution338 solution338 = new Solution338();

        int[] ints = solution338.countBits1(10);
        for (int anInt : ints) {
            System.out.print(anInt);
            System.out.print(", ");
        }
    }
}

class Solution338 {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            String s = Integer.toBinaryString(i);
            ans[i] = s.replace("0", "").length();
        }
        return ans;
    }

    public int[] countBits1(int n) {
        int[] ans = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            ans[i] = Integer.bitCount(i);
        }

        return ans;
    }
}