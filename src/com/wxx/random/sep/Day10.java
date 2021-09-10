package com.wxx.random.sep;

import java.util.Arrays;

/**
 * @author Xinxin.Wang
 * @since 2021/9/10 9:16
 */
public class Day10 {

    public int chalkReplacer(int[] chalk, int k) {
        // 一轮需要多少粉笔
        long sum = 0;
        for (int i : chalk) {
            sum += i;
        }

        // 取余，让在chalk一轮遍历中，便可以得到结果
        k %= sum;

        for (int i = 0; i < chalk.length; i++) {
            if (chalk[i] > k) {
                return i;
            }

            k -= chalk[i];
        }
        return 0;
    }

    public static void main(String[] args) {
        Day10 day10 = new Day10();

        int[] chalk = {1};
//        System.out.println(day10.chalkReplacer(chalk, 1000000));


    }
}
