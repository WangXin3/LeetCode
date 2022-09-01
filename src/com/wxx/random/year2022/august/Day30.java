package com.wxx.random.year2022.august;

import com.wxx.util.TreeNode;

/**
 * @author Xinxin.Wang
 * @since 2022/8/30 9:30
 */
public class Day30 {
    public static void main(String[] args) {

    }
}

class Solution30 {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        TreeNode parent = null;
        TreeNode cur = root;
        while (cur != null) {
            if (val > cur.val) {
                if (parent == null) {
                    return new TreeNode(val, root, null);
                }
                TreeNode node = new TreeNode(val, cur, null);
                parent.right = node;
                return root;
            } else {
                parent = cur;
                cur = cur.right;
            }
        }
        parent.right = new TreeNode(val);
        return root;
    }
}
