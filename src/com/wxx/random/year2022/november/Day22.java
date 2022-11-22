package com.wxx.random.year2022.november;

/**
 * @author Xinxin.Wang
 * @since 2022/11/22 9:34
 */
public class Day22 {
    public static void main(String[] args) {

    }
}

class Solution22 {
    static final int MOD = 1000000007;

    public int nthMagicalNumber(int n, int a, int b) {
        int c = lcm(a, b);
        int m = c / a + c / b - 1;
        int r = n % m;
        int res = (int) ((long) c * (n / m) % MOD);
        if (r == 0) {
            return res;
        }
        int addA = a, addB = b;
        for (int i = 0; i < r - 1; ++i) {
            if (addA < addB) {
                addA += a;
            } else {
                addB += b;
            }
        }
        return (res + Math.min(addA, addB) % MOD) % MOD;
    }

    public int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }
}