package com.wxx.random.year2022.august;

import com.wxx.util.TreeNode;
import com.wxx.util.U;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xinxin.Wang
 * @since 2022/8/30 9:49
 */
public class Day27 {

    public static void main(String[] args) {
        Solution27 solution27 = new Solution27();
        TreeNode tree = U.createTree("[1,3,2,5,3,null,9]");
        System.out.println(solution27.widthOfBinaryTree(tree));
    }
}

class Solution27 {
    public int widthOfBinaryTree(TreeNode root) {
        int res = 1;
        List<Pair<TreeNode, Integer>> arr = new ArrayList<>();
        arr.add(new Pair<>(root, 1));
        while (!arr.isEmpty()) {
            List<Pair<TreeNode, Integer>> tmp = new ArrayList<>();
            for (Pair<TreeNode, Integer> pair : arr) {
                TreeNode node = pair.getKey();
                int index = pair.getValue();
                if (node.left != null) {
                    tmp.add(new Pair<>(node.left, index * 2));
                }
                if (node.right != null) {
                    tmp.add(new Pair<>(node.right, index * 2 + 1));
                }
            }
            res = Math.max(res, arr.get(arr.size() - 1).getValue() - arr.get(0).getValue() + 1);
            arr = tmp;
        }
        return res;
    }
}
