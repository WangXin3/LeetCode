package com.wxx.top2025100;


/**
 * @author wangxin
 * @since 2025/12/10 14:14
 */
public class Num42 {
    public static void main(String[] args) {
        Solution42 solution42 = new Solution42();
        System.out.println(solution42.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        // 1 2 1 3
        // 0 1 0 1
        // 3 0 1 0
        // 100 0 1 0 10
        // 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1
        /*


           |                      *
           |          *           *  *     *
           | _  *  _  *  *  _  *  *  *  *  *  *


           |
           |          *           *  *     *
           | _  *  _  *  *  _  *  *  *  *  *  *
         */

        // (f - s - 1) * min(nums[f], nums[s]) - (num[f + 1] + ... + num[s - 1])
    }
}

class Solution42 {
    public int trap(int[] height) {
        int maxPos = 0;
        int max = height[0];
        int ans = 0;

        for (int i = 0; i < height.length; i++) {
            if (height[i] > max) {
                maxPos = i;
                max = height[i];
            }
        }

        int leftMax = 0;
        int rightMax = 0;
        int leftPos = 0;
        int rightPos = height.length - 1;
        while (true) {
            if (leftPos < maxPos) {
                if (height[leftPos] > leftMax) {
                    leftMax = height[leftPos];
                }
                ans += leftMax - height[leftPos];
                leftPos++;
            }

            if (rightPos > maxPos) {
                if (height[rightPos] > rightMax) {
                    rightMax = height[rightPos];
                }
                ans += rightMax - height[rightPos];
                rightPos--;
            }

            if (leftPos == maxPos && rightPos == maxPos) return ans;
        }
    }
}
