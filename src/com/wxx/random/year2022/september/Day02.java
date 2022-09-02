package com.wxx.random.year2022.september;

import com.wxx.util.TreeNode;
import com.wxx.util.U;

/**
 * @author Xinxin.Wang
 * @since 2022/9/2 9:43
 */
public class Day02 {
    public static void main(String[] args) {
        Solution02 solution02 = new Solution02();
        System.out.println(solution02.longestUnivaluePath(U.createTree("[5,4,5,1,1,5]")));
    }

}

class Solution02 {
    int res;

    public int longestUnivaluePath(TreeNode root) {
        res = 0;
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        int left1 = 0;
        int right1 = 0;

        if (root.left != null && root.left.val == root.val) {
            left1 = left + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            right1 = right + 1;
        }
        res = Math.max(res, left1 + right1);
        return Math.max(left1, right1);
    }

}