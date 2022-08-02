package com.wxx.random.year2021.aug;

/**
 * @author Xinxin.Wang
 * @since 2021/8/13 9:25
 */
public class Day13 {

    public int countDigitOne(int n) {
        long mulk = 1;
        int ans = 0;

        while (n >= mulk) {
            ans += (n / (mulk * 10)) * mulk + Math.min(Math.max(n % (mulk * 10) - mulk + 1, 0), mulk);
            mulk *= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        Day13 day13 = new Day13();
        System.out.println(day13.countDigitOne(1115551));
    }
}
