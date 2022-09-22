package com.wxx.random.year2022.september;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xinxin.Wang
 * @since 2022/9/22 9:27
 */
public class Day22 {
    public static void main(String[] args) {
        Solution22 solution22 = new Solution22();
        int[] arr = {15,88};
        int[][] pieces = {{88}, {15}};

        System.out.println(solution22.canFormArray(arr, pieces));
    }
}

class Solution22 {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int[] piece : pieces) {
            map.put(piece[0], piece);
        }

        for (int i = 0; i < arr.length;) {
            int a = arr[i];
            int[] ints = map.get(a);
            if (ints == null) {
                return false;
            }
            for (int anInt : ints) {
                if (arr[i] != anInt) {
                    return false;
                }
                i++;
            }
        }

        return true;
    }
}
