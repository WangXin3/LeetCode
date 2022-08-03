package com.wxx.util;

/**
 * @author Xinxin.Wang
 * @since 2021/7/27 9:57
 */
public class TreeNode {

    /**
     * 当前节点值
     */
    public int val;

    /**
     * 当前节点左子节点
     */
    public TreeNode left;

    /**
     * 当前节点右子节点
     */
    public TreeNode right;

    /**
     * 当前节点的父节点
     */
    public TreeNode parent;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}
