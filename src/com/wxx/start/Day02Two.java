package com.wxx.start;

/**
 * @author Xinxin.Wang
 * @since 2021/7/15 17:46
 */
public class Day02Two {

    public void rotate(int[] nums, int k) {

        int n = nums.length;
        k = k % n;
        int count = gcd(k, n);
        for (int start = 0; start < count; ++start) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
            } while (start != current);
        }

    }

    public int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }

    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5,6,7};
        Day02Two day02Two = new Day02Two();
        day02Two.rotate(nums, 3);

        System.out.println(nums[0]);
    }
}
