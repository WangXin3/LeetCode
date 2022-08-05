package com.wxx.random.year2022.august;

import com.wxx.util.TreeNode;
import com.wxx.util.U;

/**
 * @author Xinxin.Wang
 * @since 2022/8/5 16:50
 */
public class Day05 {

    public static void main(String[] args) {
        Solution05 solution05 = new Solution05();

        TreeNode root = U.createTree("[4,2,6,3,1,5]");
        TreeNode treeNode = solution05.addOneRow(root, 1, 2);
        U.printTree(treeNode);
    }
}


class Solution05 {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode leftNode = new TreeNode(val);
            leftNode.left = root;
            return leftNode;
        }

        root.left = add(root.left, val, depth - 1, "left");
        root.right = add(root.right, val, depth - 1, "right");

        return root;
    }


    public TreeNode add(TreeNode root, int val, int depth, String f) {
        if (depth == 1) {
            TreeNode node = new TreeNode(val);
            if (f.equals("left")) {
                node.left = root;
            } else {
                node.right = root;
            }
            return node;
        }
        if (root == null) {
            return null;
        }

        root.left = add(root.left, val, depth - 1, "left");
        root.right = add(root.right, val, depth - 1, "right");
        return root;
    }
}