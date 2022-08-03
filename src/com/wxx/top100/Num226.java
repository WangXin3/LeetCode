package com.wxx.top100;

import com.wxx.util.U;
import com.wxx.util.TreeNode;

/**
 * @author Xinxin.Wang
 * @since 2022/8/3 14:12
 */
public class Num226 {
    public static void main(String[] args) {
        TreeNode treeNode = U.createTree("[1]");
        Solution226 solution226 = new Solution226();
        TreeNode invertTree = solution226.invertTree(treeNode);
        System.out.println(invertTree);

    }
}

class Solution226 {
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return null;
        }

        invertTree(root.left);
        invertTree(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
