package com.wxx.random.year2022.august;

import java.util.Arrays;

/**
 * @author Xinxin.Wang
 * @since 2022/8/3 9:28
 */
public class Day03 {
    public static void main(String[] args) {
        Solution03 solution03 = new Solution03();

        System.out.println(solution03.orderlyQueue("cba", 1));
    }

}

class Solution03 {
    public String orderlyQueue(String s, int k) {
        String smallEst = s;

        StringBuilder sb = new StringBuilder(s);
        // 每次如果只能移动第一个字母，则遍历求最小字符串
        if (k == 1) {
            for (int i = 0; i < sb.length() - 1; i++) {
                char c = sb.charAt(0);
                sb.deleteCharAt(0);
                sb.append(c);

                String temp = sb.toString();
                if (temp.compareTo(smallEst) < 0) {
                    smallEst = temp;
                }
            }

        } else {
            // 每次可以移动 >1 个字母，且可移动n次时，总是可以得到升序字符串，即最小字符串，所以这里直接排序即可
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            smallEst = new String(chars);
        }

        return smallEst;
    }
}