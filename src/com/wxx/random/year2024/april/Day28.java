package com.wxx.random.year2024.april;

/**
 * @author wangxin
 * @since 2024/4/28 11:33
 */
public class Day28 {

    public String baseNeg2(int n) {
        if (n == 0 || n == 1) {
            return String.valueOf(n);
        }
        StringBuilder res = new StringBuilder();
        while (n != 0) {
            int remainder = n & 1;
            res.append(remainder);
            n -= remainder;
            n /= -2;
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        Day28 day28 = new Day28();
        System.out.println(day28.baseNeg2(100));

        System.out.println(1 | 1);
        System.out.println(4 | 1);
    }
}
