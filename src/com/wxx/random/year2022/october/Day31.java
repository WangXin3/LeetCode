package com.wxx.random.year2022.october;

/**
 * @author Xinxin.Wang
 * @since 2022/10/31 9:40
 */
public class Day31 {
    public static void main(String[] args) {
        // 1221121221221121122


    }
}

class Solution31 {
    public int magicalString(int n) {
        if (n < 4) {
            return 1;
        }

        char[] s = new char[n];
        s[0] = '1';
        s[1] = '2';
        s[2] = '2';

        int ans = 1;

        int i = 2;
        int j = 3;

        while (j < n) {
            int size = s[i] - '0';
            int num = 3 - (s[j - 1] - '0');
            while (size > 0 && j < n) {
                s[j] = (char) ('0' + num);
                if (num == 1) {
                    ++ans;
                }
                ++j;
                --size;
            }
            ++i;
        }
        return ans;
    }
}
