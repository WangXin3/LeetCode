package com.wxx.random.jul;

import com.wxx.utils.TreeNode;
import com.wxx.utils.TreeNodeInt;

/**
 * @author Xinxin.Wang
 * @since 2021/7/27 9:49
 */
public class Day27 {

    int ans;
    int rootvalue;

    public int findSecondMinimumValue(TreeNodeInt root) {
        ans = -1;
        rootvalue = root.val;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNodeInt node) {
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
