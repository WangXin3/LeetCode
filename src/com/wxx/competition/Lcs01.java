package com.wxx.competition;

/**
 * @author Xinxin.Wang
 * @since 2021/7/16 15:53
 */
public class Lcs01 {

    public int leastMinutes(int n) {
        if (n <= 2) {
            return n;
        }

        int i = n + 1 >> 1;

        int count = 0;
        for (int x = 1; x < i; x *= 2) {
            count++;
        }

        return count + 2;
    }

    public static void main(String[] args) {
        Lcs01 lcs01 = new Lcs01();
        System.out.println(lcs01.leastMinutes(1000));
    }
}
