package com.wxx.random.year2022.september;

import com.wxx.util.U;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Xinxin.Wang
 * @since 2022/9/19 9:20
 */
public class Day19 {
    public static void main(String[] args) {
        Solution19 solution19 = new Solution19();
        int[] a = {-1,1,-6,4,5,-6,1,4,1};
        int[] ints = solution19.frequencySort(a);
        U.printIntArray(ints);
    }
}

class Solution19 {
    public int[] frequencySort(int[] nums) {
        int[] ans = new int[nums.length];

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }

        List<Map.Entry<Integer, Integer>> collect = map.entrySet().stream().sorted((o1, o2) -> {
            if (o1.getValue() - o2.getValue() == 0) {
                return o2.getKey() - o1.getKey();
            } else {
                return o1.getValue() - o2.getValue();
            }
        }).collect(Collectors.toList());

        int ansIndex = 0;
        for (Map.Entry<Integer, Integer> entry : collect) {
            for (int i = 0; i < entry.getValue(); i++, ansIndex++) {
                ans[ansIndex] = entry.getKey();
            }

        }

        return ans;
    }

}
