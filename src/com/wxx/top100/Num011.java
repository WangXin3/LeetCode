package com.wxx.top100;

/**
 * @author Xinxin.Wang
 * @since 2022/8/11 10:43
 */
public class Num011 {
    public static void main(String[] args) {
        int[] ints = {8, 8, 6, 2, 5, 4, 8, 3, 7};
        Solution011 solution011 = new Solution011();
        System.out.println(solution011.maxArea1(ints));
    }
}

class Solution011 {
    public int maxArea(int[] height) {
        int maxArea = 0;

        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int i1 = height[i];
                int i2 = height[j];

                int minHeight = Math.min(i1, i2);

                maxArea = Math.max(maxArea, minHeight * (j - i));
            }
        }
        return maxArea;
    }

    public int maxArea1(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;


        while (left < height.length) {
            int leftHeight = height[left];
            int rightHeight = height[right];
            maxArea = Math.max(maxArea, (right - left) * Math.min(leftHeight, rightHeight));

            if (leftHeight <= rightHeight) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
