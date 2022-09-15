package com.wxx.random.year2022.september;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Xinxin.Wang
 * @since 2022/9/15 9:21
 */
public class Day15 {
    public static void main(String[] args) {
        Solution15 solution15 = new Solution15();
        System.out.println(solution15.flipLights(3, 2));
    }
}


class Solution15 {
    public int flipLights(int n, int presses) {
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < 16; i++) {
            int[] pressArr = new int[4];
            for (int j = 0; j < 4; j++) {
                pressArr[j] = (i >> j) & 1;
            }
            int sum = Arrays.stream(pressArr).sum();
            if (sum % 2 == presses % 2 && sum <= presses) {
                int status = pressArr[0] ^ pressArr[1] ^ pressArr[3];
                if (n >= 2) {
                    status |= (pressArr[0] ^ pressArr[1]) << 1;
                }
                if (n >= 3) {
                    status |= (pressArr[0] ^ pressArr[2]) << 2;
                }
                if (n >= 4) {
                    status |= (pressArr[0] ^ pressArr[1] ^ pressArr[3]) << 3;
                }
                seen.add(status);
            }
        }
        return seen.size();
    }
}
