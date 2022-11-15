package com.wxx.random.year2022.november;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Xinxin.Wang
 * @since 2022/11/15 9:19
 */
public class Day15 {

    public static void main(String[] args) {
        Solution15 solution15 = new Solution15();
        int[][] a = {{5, 10}, {2, 5}, {4, 7}, {3, 9}};
        System.out.println(solution15.maximumUnits(a, 10));
    }
}

class Solution15 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int ans = 0;
        List<int[]> list = Arrays.stream(boxTypes).sorted((o1, o2) -> o2[1] - o1[1]).collect(Collectors.toList());

        for (int[] ints : list) {
            int typeNum = ints[0];
            int count = ints[1];

            if (truckSize <= typeNum) {
                ans += truckSize * count;
                return ans;
            } else {
                truckSize -= typeNum;
                ans += typeNum * count;
            }
        }

        return ans;
    }
}
