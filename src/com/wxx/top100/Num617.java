package com.wxx.top100;

import com.wxx.util.TreeNode;
import com.wxx.util.U;

/**
 * @author Xinxin.Wang
 * @since 2022/8/4 16:04
 */
public class Num617 {
    public static void main(String[] args) {
        Solution617 solution617 = new Solution617();
        TreeNode root1 = U.createTree("[1,3,2,5]");
        TreeNode root2 = U.createTree("[2,1,3,null,4,null,7]");

        TreeNode treeNode = solution617.mergeTrees(root1, root2);
        System.out.println(treeNode);

        U.printTree(treeNode);
    }
}

class Solution617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }

        if (root1 != null && root2 == null) {
            return root1;
        }

        if (root1 == null) {
            return root2;
        }

        root1.val += root2.val;

        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);

        return root1;
    }
}
