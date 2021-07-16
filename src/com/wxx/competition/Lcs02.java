package com.wxx.competition;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Xinxin.Wang
 * @since 2021/7/16 16:17
 */
public class Lcs02 {
    public int halfQuestions(int[] questions) {
        int n = questions.length / 2;

        Map<Integer, Integer> map = new HashMap<>();
        for (int question : questions) {
            map.merge(question, 1, Integer::sum);
        }

        List<Integer> collect = map.values().stream().sorted((o1, o2) -> o2 - o1).collect(Collectors.toList());

        int sum = 0;

        for (int i = 0; i < collect.size(); i++) {
            sum += collect.get(i);
            if (sum >= n) {
                return i + 1;
            }
        }

        return 0;
    }


    public static void main(String[] args) {
        Lcs02 lcs02 = new Lcs02();
        int[] nums = {1,5,1,3,4,5,2,5,3,3,8,6};
        System.out.println(lcs02.halfQuestions(nums));
    }
}
