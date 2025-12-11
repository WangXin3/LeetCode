package com.wxx.top2025100;

/**
 * @author wangxin
 * @since 2025/12/10 9:00
 */
public class Num11 {
    public static void main(String[] args) {
        Solution11 solution11 = new Solution11();
        System.out.println(solution11.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}

class Solution11 {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }
}
