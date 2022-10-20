package com.wxx.random.year2022.october;

/**
 * @author Xinxin.Wang
 * @since 2022/10/20 9:10
 */
public class Day20 {
    public static void main(String[] args) {
        // 0
        // 01
        // 0110
        // 01101001
        // 0110100110010110
        // 01101001100101101001011001101001
        Solution20 solution20 = new Solution20();

        System.out.println(solution20.kthGrammar(30, 5));
    }
}

class Solution20 {
    public int kthGrammar(int n, int k) {
        if (n == 1) {
            return 0;
        }
        return (k & 1) ^ 1 ^ kthGrammar(n - 1, (k + 1) / 2);
    }
}
