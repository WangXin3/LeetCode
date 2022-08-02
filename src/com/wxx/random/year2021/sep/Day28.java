package com.wxx.random.year2021.sep;

import com.wxx.utils.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xinxin.Wang
 * @since 2021/9/28 9:09
 */
public class Day28 {

    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Integer, Integer> prefix = new HashMap<>();
        prefix.put(0, 1);
        return dfs(root, prefix, 0, targetSum);
    }

    public int dfs(TreeNode root, Map<Integer, Integer> prefix, int curr, int targetSum) {
        if (root == null) {
            return 0;
        }

        int ret = 0;
        curr += root.val;

        ret = prefix.getOrDefault(curr - targetSum, 0);
        prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);
        ret += dfs(root.left, prefix, curr, targetSum);
        ret += dfs(root.right, prefix, curr, targetSum);
        prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);

        return ret;
    }
}
