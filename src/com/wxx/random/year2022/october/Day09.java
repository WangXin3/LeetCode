package com.wxx.random.year2022.october;

/**
 * @author Xinxin.Wang
 * @since 2022/10/9 9:07
 */
public class Day09 {

    public static void main(String[] args) {
        Solution09 solution09 = new Solution09();
        System.out.println(solution09.scoreOfParentheses("()()()()"));
    }
}

class Solution09 {
    public int scoreOfParentheses(String s) {
        int n = s.length();
        if (n == 2) {
            return 1;
        }

        int bal = 0;
        int len = 0;
        for (int i = 0; i < n; i++) {
            bal += (s.charAt(i) == '(' ? 1 : -1);
            if (bal == 0) {
                len = i + 1;
                break;
            }
        }

        if (len == n) {
            return 2 * scoreOfParentheses(s.substring(1, n - 1));
        } else {
            return scoreOfParentheses(s.substring(0, len)) + scoreOfParentheses(s.substring(len));
        }
    }
}