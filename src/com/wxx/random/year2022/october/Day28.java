package com.wxx.random.year2022.october;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Xinxin.Wang
 * @since 2022/10/28 9:31
 */
public class Day28 {

    public static void main(String[] args) {
        Solution28 solution28 = new Solution28();
        int[] a = {3, 1, 2, 4};
        System.out.println(solution28.sumSubarrayMins(a));
    }
}

class Solution28 {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        Deque<Integer> monoStack = new ArrayDeque<Integer>();
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            while (!monoStack.isEmpty() && arr[i] <= arr[monoStack.peek()]) {
                monoStack.pop();
            }
            left[i] = i - (monoStack.isEmpty() ? -1 : monoStack.peek());
            monoStack.push(i);
        }
        monoStack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!monoStack.isEmpty() && arr[i] < arr[monoStack.peek()]) {
                monoStack.pop();
            }
            right[i] = (monoStack.isEmpty() ? n : monoStack.peek()) - i;
            monoStack.push(i);
        }
        long ans = 0;
        final int MOD = 1000000007;
        for (int i = 0; i < n; i++) {
            ans = (ans + (long) left[i] * right[i] * arr[i]) % MOD;
        }
        return (int) ans;
    }
}
