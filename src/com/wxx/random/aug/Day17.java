package com.wxx.random.aug;

/**
 * @author Xinxin.Wang
 * @since 2021/8/17 9:16
 */
public class Day17 {

    public boolean checkRecord(String s) {
        int aCount = 0;
        int lContinuousMax = 0;
        int lCount = 0;

        char c0 = s.charAt(0);
        if (c0 == 'A') aCount++;
        if (c0 == 'L') lCount++;

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == 'A') {
                aCount++;
            }

            if (c == 'L') {
                if (c == c0) {
                    lCount++;
                } else {
                    lCount = 1;
                }
            } else {
                lCount = 0;
            }
            lContinuousMax = Math.max(lContinuousMax, lCount);
            c0 = c;
        }


        return aCount < 2 && lContinuousMax < 3;
    }

    /**
     * 一行，牛逼
     * @param s /
     * @return /
     */
    public boolean checkRecord1(String s) {
        return s.indexOf("A") == s.lastIndexOf("A") && !s.contains("LLL");
    }

    public static void main(String[] args) {
        Day17 day17 = new Day17();
        System.out.println(day17.checkRecord("LLLALL"));
    }
}
