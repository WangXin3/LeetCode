package com.wxx.random.year2022.september;

/**
 * @author Xinxin.Wang
 * @since 2022/9/1 9:27
 */
public class Day01 {

    public static void main(String[] args) {
        int[] prices = {10,1,1,6};
        Solution01 solution01 = new Solution01();
        for (int i : solution01.finalPrices(prices)) {
            System.out.println(i);
        }
    }
}

class Solution01 {
    public int[] finalPrices(int[] prices) {
        int i = 0;
        int j = i;
        while (i < prices.length) {
            j++;
            // 到最后了没找到折扣
            if (j == prices.length) {
                // 原价
                // 开始寻找下一件商品的折扣
                i++;
                j = i;
                continue;
            }

            if (prices[i] >= prices[j]) {
                prices[i] -= prices[j];
                i++;
                j = i;
            }
        }

        return prices;
    }
}
