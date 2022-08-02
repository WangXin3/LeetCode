package com.wxx.top100;

/**
 * @author Xinxin.Wang
 * @since 2022/8/2 15:38
 */
public class Num121 {

    public static void main(String[] args) {
        Solution121 solution121 = new Solution121();
        int[] a = {7, 0, 5, 3, 6, 4, 88};
        System.out.println(solution121.maxProfit(a));
    }
}

class Solution121 {

    public int maxProfit(int[] prices) {
        int max = 0;
        if (prices.length <= 1) {
            return max;
        }
        for (int left = 0; left < prices.length; left++) {
            for (int right = left + 1; right < prices.length; right++) {
                int i = prices[right] - prices[left];
                max = Integer.max(max, i);
            }
        }

        return max;
    }

    public int maxProfit1(int prices[]) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
}
