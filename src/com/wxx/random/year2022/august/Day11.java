package com.wxx.random.year2022.august;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Xinxin.Wang
 * @since 2022/8/11 8:57
 */
public class Day11 {
    public static void main(String[] args) {
        Solution11 solution11 = new Solution11();
        System.out.println(solution11.reformat1("ab123"));
    }
}

class Solution11 {
    public String reformat(String s) {
        int length = s.length();
        if (length == 1) {
            return s;
        }

        List<Character> number = new ArrayList<>();
        List<Character> letter = new ArrayList<>();

        // 0-9 48-57
        // a-z 97 122
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                number.add(c);
            }

            if (Character.isLowerCase(c)) {
                letter.add(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        if (number.size() == letter.size() - 1) {
            // 字母多
            for (int i = 0; i < letter.size(); i++) {
                sb.append(letter.get(i));
                if (i < number.size()) {
                    sb.append(number.get(i));
                }
            }
        }

        if (number.size() - 1 == letter.size()) {
            // 数字多
            for (int i = 0; i < number.size(); i++) {
                sb.append(number.get(i));

                if (i < letter.size()) {
                    sb.append(letter.get(i));
                }
            }
        }

        if (number.size() == letter.size()) {
            for (int i = 0; i < number.size(); i++) {
                sb.append(number.get(i)).append(letter.get(i));
            }
        }
        return sb.toString();
    }

    public String reformat1(String s) {
        int length = s.length();
        if (length <= 1) {
            return s;
        }

        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        // 如果是奇数个字符，如果满足题意，则中间的类型的字符数肯定是多余不是中间类型字符数的
        // 如果是偶数个字符，如果满足题意，则中间的类型和不是中间类型的字符数是相同的
        // 所以直接用mid下标的字符开头即可
        int mid = chars.length / 2;

        int left = 0;
        int right = length - 1;
        StringBuilder sb = new StringBuilder();
        while (left <= mid && right >= mid) {
            char leftC = chars[left];
            char rightC = chars[right];
            boolean midIsDigit = Character.isDigit(chars[mid]);

            if (left == right && leftC == rightC) {
                sb.append(leftC);
                return sb.toString();
            }
            left++;
            right--;

            if ((Character.isDigit(leftC) && Character.isLowerCase(rightC))) {
                // 左边数字 右边字母
                if (midIsDigit) {
                    sb.append(leftC).append(rightC);
                } else {
                    sb.append(rightC).append(leftC);
                }
            } else if (Character.isDigit(rightC) && Character.isLowerCase(leftC)) {
                // 左边字母 右边数字
                if (midIsDigit) {
                    sb.append(rightC).append(leftC);
                } else {
                    sb.append(leftC).append(rightC);
                }
            } else {
                return "";
            }
        }

        return sb.toString();
    }
}