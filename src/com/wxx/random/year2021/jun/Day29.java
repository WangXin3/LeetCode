package com.wxx.random.year2021.jun;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Xinxin.Wang
 * @since 2021/6/29 14:46
 */
public class Day29 {


    public int halfQuestions(int[] questions) {
        Integer integer = Arrays.stream(questions).boxed().max(Comparator.comparingInt(o -> o)).orElse(0);
        int[] max = new int[integer];

        for (int question : questions) {
            max[question - 1]++;
        }

        List<Integer> collect = Arrays.stream(max).boxed().sorted((o1, o2) -> o2 - o1).collect(Collectors.toList());

        // 人数
        int person = questions.length / 2;
        int sum = 0;
        for (int i = 0; i < collect.size(); i++) {
            sum += collect.get(i);
            if (sum >= person) {
                return i + 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Day29 day29 = new Day29();
        int[] a = {1,5,1,3,4,5,2,5,3,3,8,6};
        System.out.println(day29.halfQuestions(a));
    }

}
