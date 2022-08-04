package com.wxx.top100;

/**
 * @author Xinxin.Wang
 * @since 2022/8/4 14:40
 */
public class Num461 {
    public static void main(String[] args) {
        Solution461 solution461 = new Solution461();
        System.out.println(solution461.hammingDistance1(3, 1));
    }
}

class Solution461 {
    public int hammingDistance(int x, int y) {
        // 异或两个数字 二进制每个位 相同为0，相异为1，则在两个数字异或之后的二进制中1的个数就是
        int i = x ^ y;

        // Brian Kernighan 算法：
        // 对于任意整数 x，令 x = x & (x-1)，该运算将 x 的二进制表示的最后一个 1 变成 0。因此，对 x 重复该操作，
        // 直到 x 变成 0，则操作次数即为 x 的「一比特数」。
        int ans = 0;
        while (i != 0) {
            i &= (i - 1);
            ans++;
        }

        return ans;
    }

    public int hammingDistance1(int x, int y) {
        // 异或两个数字 二进制每个位 相同为0，相异为1，则在两个数字异或之后的二进制中1的个数就是
        int i = x ^ y;
        return Integer.bitCount(i);
    }
}
