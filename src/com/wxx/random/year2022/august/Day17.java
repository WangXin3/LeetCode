package com.wxx.random.year2022.august;

import com.wxx.util.TreeNode;
import com.wxx.util.U;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xinxin.Wang
 * @since 2022/8/17 16:23
 */
public class Day17 {
    public static void main(String[] args) {
        Solution17 solution17 = new Solution17();
        TreeNode tree = U.createTree("[2,1,3]");

        U.printTree(tree);
        System.out.println(solution17.deepestLeavesSum(tree));
    }
}

class Solution17 {
    Map<Integer, Integer> map = new HashMap<>();

    public int deepestLeavesSum(TreeNode root) {
        int n = 1;
        deep(root, n);
        Integer max = map.keySet().stream().max(Integer::compareTo).get();
        return map.get(max);
    }

    public int deep(TreeNode root, int n) {
        int ans = 0;

        if (root.right == null && root.left == null) {
            if (n == 1) {
                map.put(n, root.val);
            }
            return root.val;
        }
        ++n;
        if (root.left != null) {
            ans += deep(root.left, n);
        }
        if (root.right != null) {
            ans += deep(root.right, n);
        }

        map.put(n, map.getOrDefault(n, 0) + ans);
        return ans;
    }
}