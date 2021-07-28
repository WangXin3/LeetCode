package com.wxx.random.jul;

import com.wxx.utils.util.TreeNode;

/**
 * @author Xinxin.Wang
 * @since 2021/7/27 9:49
 */
public class Day27 {

    int ans;
    int rootvalue;

    public int findSecondMinimumValue(TreeNode root) {
        ans = -1;
        rootvalue = root.val;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        if (ans != -1 && node.val >= ans) {
            return;
        }
        if (node.val > rootvalue) {
            ans = node.val;
        }
        dfs(node.left);
        dfs(node.right);
    }
}
