package com.wxx.random.jul;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xinxin.Wang
 * @since 2021/7/7 9:29
 */
public class Day07 {

    public int countPairs1(int[] deliciousness) {
        int count = 0;

        for (int i = 0; i < deliciousness.length; i++) {
            for (int j = i + 1; j < deliciousness.length; j++) {
                int n = deliciousness[i] + deliciousness[j];
                if (n > 0 && (n & (n - 1)) == 0) {
                    count++;
                }
            }
        }
        return count % 1000000007;
    }

    public int countPairs(int[] deliciousness) {
        final int MOD = 1000000007;
        int maxVal = 0;
        for (int val : deliciousness) {
            maxVal = Math.max(maxVal, val);
        }
        int maxSum = maxVal * 2;
        int pairs = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int val : deliciousness) {
            // 不超过maxVal * 2
            for (int sum = 1; sum <= maxSum; sum <<= 1) {
                // 获取和当前值可以组成sum 的个数

                // 由于遍历数组时，哈希表中已有的元素的下标一定小于当前元素的下标，因此任意一对元素之和等于2的幂的元素都不会被重复计算。
                int count = map.getOrDefault(sum - val, 0);
                pairs = (pairs + count) % MOD;
            }

            // 每个数字的个数
            map.merge(val, 1, Integer::sum);
        }
        return pairs;
    }

    public static void main(String[] args) {
        Day07 day07 = new Day07();

        int[] a = {1, 1, 1, 3, 3, 3, 7};
        System.out.println(day07.countPairs(a));


    }
}
