package com.wxx.random.year2022.september;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Xinxin.Wang
 * @since 2022/9/9 15:14
 */
public class Day09 {
    public static void main(String[] args) {
        Solution09 solution09 = new Solution09();
        String[] a = {"d1/","../","../","../"};
        System.out.println(solution09.minOperations(a));
    }
}

class Solution09 {
    public int minOperations(String[] logs) {
        Deque<String> deque = new ArrayDeque<>();
        for (String log : logs) {
            if (log.equals("./")) {
                continue;
            }
            if (log.equals("../")) {
                deque.poll();
            } else {
                deque.push(log);
            }
        }
        return deque.size();
    }
}
