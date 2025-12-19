package com.wxx.top2025100;

import java.util.HashMap;

/**
 * @author wangxin
 * @since 2025/12/15 16:02
 */
public class Num560 {
    public static void main(String[] args) {
        Solution560 solution560 = new Solution560();
        //  1 2
        //sum[i...j] =  pre[i] - pre[j - 1]  =  1  - 1  = 0
        // k = pre[i] - pre[j - 1]
        // pre[i] - k = pre[j - 1]
        System.out.println(solution560.subarraySum(new int[]{1, 1, -1, 1, -1}, 1));
    }
}

class Solution560 {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int pre = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for (int num : nums) {
            pre += num;
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
