package com.wxx.random.year2022.august;

import com.wxx.util.TreeNode;
import com.wxx.util.U;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xinxin.Wang
 * @since 2022/8/22 9:19
 */
public class Day22 {
    public static void main(String[] args) {
        TreeNode tree = U.createTree("[1,2,3,4,5,1,2,3,4]");
        Solution22 solution22 = new Solution22();
        List<List<String>> lists = solution22.printTree(tree);
        U.printTree(tree);

        lists.forEach(System.out::println);
    }
}

class Solution22 {
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> res = new ArrayList<>();

        // 计算树高
        int height = this.getHeight(root);

        int n = ((int) (Math.pow(2, height) - 1));

        // 初始化 res.length = height res[0].length = 2^height - 1
        for (int i = 0; i < height; i++) {
            ArrayList<String> e = new ArrayList<>(n);
            for (int j = 0; j < n; j++) {
                e.add(null);
            }
            res.add(e);
        }


        int c = (n - 1) / 2;
        // 填入节点
        this.fillNode(root, res, 0, c, height, n);


        return res;
    }

    private void fillNode(TreeNode root, List<List<String>> res, int r, int c, int height, int n) {
        if (root != null) {
            List<String> list = res.get(r);
            for (int i = 0; i < n; i++) {
                String s = list.get(i);
                if (i == c) {
                    list.set(i, String.valueOf(root.val));
                } else {
                    if (s == null) {
                        list.set(i, "");
                    }
                }
            }


            if (root.left != null) {
                int rr = r + 1;
                int cc = ((int) (c - Math.pow(2, height - r - 2d)));

                fillNode(root.left, res, rr, cc, height, n);
            }

            if (root.right != null) {
                int rr = r + 1;
                int cc = ((int) (c + Math.pow(2, height - r - 2d)));

                fillNode(root.right, res, rr, cc, height, n);
            }
        }
    }

    public int getHeight(TreeNode root) {
        int height = 1;

        if (root.left == null && root.right == null) {
            return height;
        }
        int leftHeight = 0;
        if (root.left != null) {
            leftHeight = getHeight(root.left);
        }

        int rightHeight = 0;
        if (root.right != null) {
            rightHeight = getHeight(root.right);
        }

        height += Math.max(leftHeight, rightHeight);

        return height;
    }
}
