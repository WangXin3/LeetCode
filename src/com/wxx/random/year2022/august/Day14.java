package com.wxx.random.year2022.august;

/**
 * @author Xinxin.Wang
 * @since 2022/8/15 11:22
 */
public class Day14 {
    public static void main(String[] args) {
        Solution14 solution14 = new Solution14();
        System.out.println(solution14.maxScore("1110011010111001001010101011010110100000010100001111001000001101000"));
    }
}

class Solution14 {
public int maxScore(String s) {
    int max = 0;
    char[] chars = s.toCharArray();
    int zero = 0;
    // 把i当作分割线，之前记录的0的数量不要扔，裹上面包糠，油炸，隔壁小孩都馋哭了。
    for (int i = 0; i < chars.length - 1; i++) {
        if (chars[i] == '0') {
            zero++;
        }

        int one = 0;
        for (int j = i + 1; j < chars.length; j++) {
            if (chars[j] == '1') {
                one++;
            }
        }

        max = Math.max(max, zero + one);
    }
    return max;
}
}
