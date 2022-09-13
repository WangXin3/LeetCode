package com.wxx.random.year2022.september;

import com.wxx.util.TreeNode;
import com.wxx.util.U;

/**
 * @author Xinxin.Wang
 * @since 2022/9/13 10:52
 */
public class Day10 {
    public static void main(String[] args) {
        Solution10 solution10 = new Solution10();
        TreeNode treeNode = solution10.trimBST(U.createTree("[1,0,2]"), 1, 2);
        U.printTree(treeNode);
    }
}

class Solution10 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val < low) {
            return trimBST(root.right, low, high);
        } else if (root.val > high) {
            return trimBST(root.left, low, high);
        } else {
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
            return root;
        }

    }
}
