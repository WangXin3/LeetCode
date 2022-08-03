package com.wxx.structure;

import com.wxx.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xinxin.Wang
 * @since 2021/7/30 14:55
 */
public class Day10Three {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        preorder(root, res);
        return res;
    }

    public void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        preorder(root.left, res);
        preorder(root.right, res);
        res.add(root.val);
    }
}
