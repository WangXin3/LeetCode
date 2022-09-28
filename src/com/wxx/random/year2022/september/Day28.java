package com.wxx.random.year2022.september;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author Xinxin.Wang
 * @since 2022/9/28 9:09
 */
public class Day28 {
    public static void main(String[] args) {
        Solution28 solution28 = new Solution28();
        System.out.println(solution28.getKthMagicNumber(10));

    }
}

class Solution28 {
    public int getKthMagicNumber(int k) {
        int[] factors = {3, 5, 7};
        Set<Long> seen = new HashSet<>();
        PriorityQueue<Long> heap = new PriorityQueue<>();
        seen.add(1L);
        heap.offer(1L);
        int ugly = 0;
        for (int i = 0; i < k; i++) {
            long curr = heap.poll();
            ugly = (int) curr;
            for (int factor : factors) {
                long next = curr * factor;
                if (seen.add(next)) {
                    heap.offer(next);
                }
            }
        }
        return ugly;
    }
}
