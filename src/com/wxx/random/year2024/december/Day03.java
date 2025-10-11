package com.wxx.random.year2024.december;

/**
 * @author wangxin
 * @since 2024/12/3 8:53
 */
public class Day03 {
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        return (coordinate1.charAt(0) % 2 == coordinate1.charAt(1) % 2)
                == (coordinate2.charAt(0) % 2 == coordinate2.charAt(1) % 2);

        // 1 1 = 1
        // 1 0 = 0
        // 0 1 = 0
        // 0 0 = 1

        /**
         * 0 1 0 1 0 1 0 1
         * 1 0 1 0 1 0 1 0
         * 0 1 0 1 0 1 0 1
         * 1 0 1 0 1 0 1 0
         * 0 1 0 1 0 1 0 1
         * 1 0 1 0 1 0 1 0
         * 0 1 0 1 0 1 0 1
         * 1 0 1 0 1 0 1 0
         */
    }

    public static void main(String[] args) {
        Day03 day03 = new Day03();
        System.out.println(day03.checkTwoChessboards("c2", "g4"));
    }
}
