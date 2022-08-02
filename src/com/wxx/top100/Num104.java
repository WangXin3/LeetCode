package com.wxx.top100;

/**
 * @author Xinxin.Wang
 * @since 2022/8/2 15:22
 */
public class Num104 {
    public static void main(String[] args) {

    }

}

class Solution104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Integer.max(left, right) + 1;
    }
}
