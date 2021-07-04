package com.wxx.random.jul;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author wangxin
 * @since 2021/7/4
 */
public class Day04 {

    public int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }

        for (int i = 1; i <= nums.length; i++) {
            Integer orDefault = map.getOrDefault(i, 0);

            if (orDefault.equals(2)) {
                result[0] = i;
            }
            if (orDefault.equals(0)) {
                result[1] = i;
            }

            if (result[0] != 0 && result[1] != 0) {
                return result;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        final Day04 day04 = new Day04();

        int[] a = {3, 2, 3, 4, 6, 5};
        for (int errorNum : day04.findErrorNums(a)) {
            System.out.println(errorNum);
        }
    }
}
