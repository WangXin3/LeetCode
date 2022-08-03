package com.wxx.top100;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/**
 * @author Xinxin.Wang
 * @since 2022/8/3 16:34
 */
public class Num020 {

    public static void main(String[] args) {
        Solution020 solution020 = new Solution020();
        System.out.println(solution020.isValid("{}([(])([])"));
    }
}

class Solution020 {
    private static final HashMap<Character, Character> map;
    static {
        map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
    }

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                char close = map.getOrDefault(stack.peek(), '*');
                if (close == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }

        return stack.isEmpty();
    }



}
