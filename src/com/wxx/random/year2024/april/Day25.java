package com.wxx.random.year2024.april;

/**
 * @author wangxin
 * @since 2024/4/30 14:02
 */
public class Day25 {

    public int distanceTraveled(int mainTank, int additionalTank) {
        return 10 * (mainTank + Math.min(additionalTank, (mainTank - 1) / 4));
    }

    public static void main(String[] args) {
        Day25 day25 = new Day25();
        System.out.println(day25.distanceTraveled(9, 2));
    }
}
