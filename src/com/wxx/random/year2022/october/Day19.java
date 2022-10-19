package com.wxx.random.year2022.october;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Xinxin.Wang
 * @since 2022/10/19 9:10
 */
public class Day19 {
    public static void main(String[] args) {
        Solution19 solution19 = new Solution19();
        int[] a = {1, 1, 1, 0, 0, 1};
        int[] b = {1, 0, 0, 0, 1, 1};
        System.out.println(solution19.countStudents(a, b));
    }
}

class Solution19 {
    public int countStudents(int[] students, int[] sandwiches) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int student : students) {
            deque.addLast(student);
        }

        for (int i = 0; i < sandwiches.length; i++) {
            int sandwich = sandwiches[i];

            Integer studentLike = deque.pollFirst();
            if (studentLike == null) {
                return 0;
            }
            int dislikeCount = 0;
            while (studentLike != sandwich) {
                dislikeCount++;
                deque.addLast(studentLike);
                studentLike = deque.pollFirst();

                if (studentLike == null) {
                    return 0;
                }

                if (dislikeCount > deque.size()) {
                    return deque.size() + 1;
                }
            }
        }
        return 0;
    }
}