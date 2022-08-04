package com.wxx.top100;

import com.wxx.util.TreeNode;
import com.wxx.util.U;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xinxin.Wang
 * @since 2022/8/4 10:29
 */
public class Num094 {

    public static void main(String[] args) {
        TreeNode tree = U.createTree("[1, 1, 2, null, 5, 3]");

        Solution094 solution094 = new Solution094();
        List<Integer> list = solution094.inorderTraversal(tree);
        System.out.println("list = " + list);
    }
}

class Solution094 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        // 左根右
        list.addAll(inorderTraversal(root.left));
        list.add(root.val);
        list.addAll(inorderTraversal(root.right));

        return list;
    }
}
