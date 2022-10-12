package com.wxx.random.year2022.october;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Xinxin.Wang
 * @since 2022/10/12 10:05
 */
public class Day04 {

    public static void main(String[] args) {
        Solution04 solution04 = new Solution04();
        System.out.println(solution04.minAddToMakeValid("()))(("));
    }
}

class Solution04 {
    public int minAddToMakeValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.offerLast(c);
            } else {
                Character peek = stack.peekLast();
                if (peek == '(' && c == ')') {
                    stack.removeLast();
                } else {
                    stack.offerLast(c);
                }
            }
        }
        return stack.size();
    }
}