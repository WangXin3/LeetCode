package com.wxx.random.year2022.october;

/**
 * @author Xinxin.Wang
 * @since 2022/10/12 10:31
 */
public class Day03 {
    public static void main(String[] args) {
        Solution03 solution03 = new Solution03();
        System.out.println(solution03.checkOnesSegment1("110110"));
    }
}

class Solution03 {
    public boolean checkOnesSegment(String s) {
        // 0个1
        if (!s.contains("1")) {
            return true;
        }

        int str1Count = 0;
        boolean isOne = false;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                if (!isOne) {
                    isOne = true;
                    str1Count++;
                }
            } else {
                isOne = false;
            }
        }
        return str1Count <= 1;
    }

    public boolean checkOnesSegment1(String s) {
        if (s.length() == 1) {
            return true;
        }
        boolean gapZero = false;
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];
            if (c == '0') {
                gapZero = true;
            }

            if (c == '1' && gapZero) {
                return false;
            }
        }

        return true;
    }
}
