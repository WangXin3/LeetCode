package com.wxx.random.aug;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author Xinxin.Wang
 * @since 2021/8/9 9:23
 */
public class Day09 {

    public int nthSuperUglyNumber(int n, int[] primes) {
        Set<Long> seen = new HashSet<>();
        PriorityQueue<Long> heap = new PriorityQueue<>();
        seen.add(1L);
        heap.offer(1L);
        int ugly = 0;
        for (int i = 0; i < n; i++) {
            long curr = heap.poll();
            ugly = (int) curr;
            for (int prime : primes) {
                long next = curr * prime;
                if (seen.add(next)) {
                    heap.offer(next);
                }
            }
        }
        return ugly;
    }

    public static void main(String[] args) {

    }
}
