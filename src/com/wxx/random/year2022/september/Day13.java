package com.wxx.random.year2022.september;

/**
 * @author Xinxin.Wang
 * @since 2022/9/13 9:08
 */
public class Day13 {
    public static void main(String[] args) {
        // 3 5 2 7
        // 7 7 6 7
        // 7 6 1 7
        Solution13 solution13 = new Solution13();
        System.out.println(solution13.maximumSwap(2736));
    }
}

class Solution13 {
    public int maximumSwap(int num) {
        String strNum = String.valueOf(num);
        char[] chars = strNum.toCharArray();
        int singleNum = Character.digit(chars[0], 10);
        int maxNum = num;

        for (int i = chars.length - 1; i >= 0; i--) {
            int right = Character.digit(chars[i], 10);
            singleNum = Math.max(singleNum, right);

            for (int j = 0; j < i; j++) {
                int left = Character.digit(chars[j], 10);
                if (left < right) {
                    char[] newChar = new char[chars.length];
                    System.arraycopy(chars, 0, newChar, 0, newChar.length);
                    newChar[i] = Character.forDigit(left, 10);
                    newChar[j] = Character.forDigit(right, 10);
                    maxNum = Math.max(maxNum, Integer.parseInt(String.valueOf(newChar)));
                    break;
                }
            }
        }
        return maxNum;
    }
}
