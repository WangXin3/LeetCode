package com.wxx.top100;

/**
 * @author Xinxin.Wang
 * @since 2022/8/8 16:37
 */
public class Num005 {
    public static void main(String[] args) {
        Solution005 solution005 = new Solution005();
        System.out.println(solution005.longestPalindrome1("1234432123123124124123123123"));
    }
}

class Solution005 {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度
        for (int length = 2; length <= len; length++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 length 和 i 可以确定右边界，即 j - i + 1 = length 得
                int j = length + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][length] == true 成立，就表示子串 s[i..length] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public String longestPalindrome1(String s) {
        int length = s.length();
        if (length <= 1) {
            return s;
        }

        boolean[][] dp = new boolean[length][length];

        // 一位字符串就是回文串
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }

        int maxLen = 1;
        int begin = 0;

        // 从子串长度=2开始遍历
        for (int len = 2; len <= length; len++) {
            for (int i = 0; i < length; i++) {
                int j = len + i - 1;

                if (j >= length) {
                    break;
                }

                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (j - i >= 3) {
                        dp[i][j] = dp[i + 1][j - 1];
                    } else {
                        dp[i][j] = true;
                    }
                }


                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }
}
