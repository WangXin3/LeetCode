package com.wxx.random.year2022.september;

import com.wxx.util.TreeNode;
import com.wxx.util.U;

import java.util.*;

/**
 * @author Xinxin.Wang
 * @since 2022/9/5 13:58
 */
public class Day05 {
    public static void main(String[] args) {
        TreeNode tree = U.createTree("[1,2,3,4,null,2,4,null,null,4]");
        Solution05 solution05 = new Solution05();
        for (TreeNode duplicateSubtree : solution05.findDuplicateSubtrees(tree)) {
            U.printTree(duplicateSubtree);
        }
    }
}

class Solution05 {
    Map<String, TreeNode> seen = new HashMap<>();
    Set<TreeNode> repeat = new HashSet<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return new ArrayList<>(repeat);
    }

    public String dfs(TreeNode node) {
        if (node == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(node.val);
        sb.append("(");
        sb.append(dfs(node.left));
        sb.append(")(");
        sb.append(dfs(node.right));
        sb.append(")");
        String serial = sb.toString();
        if (seen.containsKey(serial)) {
            repeat.add(seen.get(serial));
        } else {
            seen.put(serial, node);
        }
        return serial;
    }

}
