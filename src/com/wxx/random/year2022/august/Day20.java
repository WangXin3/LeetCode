package com.wxx.random.year2022.august;

import com.wxx.util.TreeNode;
import com.wxx.util.U;

/**
 * @author Xinxin.Wang
 * @since 2022/8/22 10:42
 */
public class Day20 {
    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();
        int[] a = {3, 2, 1};
        TreeNode treeNode = solution20.constructMaximumBinaryTree(a);
        U.printTree(treeNode);
    }
}

class Solution20 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        int maxValue = nums[0];
        int maxIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (maxValue < nums[i]) {
                maxValue = nums[i];
                maxIndex = i;
            }
        }

        int[] left = new int[maxIndex];
        int[] right = new int[nums.length - maxIndex - 1];

        System.arraycopy(nums, 0, left, 0, left.length);
        System.arraycopy(nums, maxIndex + 1, right, 0, right.length);

        TreeNode root = new TreeNode(maxValue);
        root.left = constructMaximumBinaryTree(left);
        root.right = constructMaximumBinaryTree(right);

        return root;
    }
}