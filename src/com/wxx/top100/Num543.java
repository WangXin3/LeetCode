package com.wxx.top100;

import com.wxx.util.TreeNode;
import com.wxx.util.U;

/**
 * @author Xinxin.Wang
 * @since 2022/8/4 14:54
 */
public class Num543 {
    public static void main(String[] args) {
        Solution543 solution543 = new Solution543();
        TreeNode tree = U.createTree("[1,2,3,4,5,6,7]");
        System.out.println(solution543.diameterOfBinaryTree(tree));
    }
}

class Solution543 {

    int max;

    public int diameterOfBinaryTree(TreeNode root) {
        max = 1;
        depth(root);
        return max - 1;
    }

    public int depth(TreeNode node) {
        if (node == null) {
            return 0; // 访问到空节点了，返回0
        }
        int l = depth(node.left); // 左儿子为根的子树的深度
        int r = depth(node.right); // 右儿子为根的子树的深度
        max = Math.max(max, l + r + 1); // 计算d_node即L+R+1 并更新ans
        return Math.max(l, r) + 1; // 返回该节点为根的子树的深度
    }
}
