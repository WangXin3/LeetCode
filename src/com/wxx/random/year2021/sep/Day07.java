package com.wxx.random.year2021.sep;

import java.util.Stack;

/**
 * @author Xinxin.Wang
 * @since 2021/9/7 9:25
 */
public class Day07 {

    public int balancedStringSplit1(String s) {
        char[] chars = s.toCharArray();
        int count = 0;

        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (stack.empty()) {
                stack.push(c);
            } else {
                Character peek = stack.peek();
                if (peek != c) {
                    stack.pop();
                    if (stack.empty()) {
                        count++;
                    }
                } else {
                    stack.push(c);
                }

            }
        }
        return count;
    }

    public int balancedStringSplit(String s) {
        char[] chars = s.toCharArray();
        int count = 0, result = 0;


        for (char c : chars) {
            if(c == 'L') count++; else count--;
            if (count == 0) result++;
        }
        return result;
    }

    public static void main(String[] args) {
        Day07 day07 = new Day07();
        System.out.println(day07.balancedStringSplit("RLRRRLLRLL"));
    }
}
