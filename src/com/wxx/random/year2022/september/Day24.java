package com.wxx.random.year2022.september;

import com.wxx.util.U;

/**
 * @author Xinxin.Wang
 * @since 2022/9/26 10:18
 */
public class Day24 {
    public static void main(String[] args) {
        Solution24 solution24 = new Solution24();
        U.printIntArray(solution24.decrypt(new int[]{5, 7, 1, 4}, 3));
    }
}

class Solution24 {
    public int[] decrypt(int[] code, int k) {
        int len = code.length;
        int[] ans = new int[len];
        int e = Integer.compare(k, 0);  //e取值为：[0,1,-1]
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = e; j != k + e; j += e) {
                sum += code[(i + j + len) % len];
            }
            ans[i] = sum;
        }
        return ans;
    }
}
