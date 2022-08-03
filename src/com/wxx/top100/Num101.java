package com.wxx.top100;

import com.wxx.util.TreeNode;

/**
 * @author Xinxin.Wang
 * @since 2022/8/2 15:02
 */
public class Num101 {

    public static void main(String[] args) {

    }
}

class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        return isEq(root, root);
    }

    public boolean isEq(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        return p.val == q.val && isEq(p.left, q.right) && isEq(p.right, q.left);

    }
}
