package com.wxx.utils;

/**
 * @author Xinxin.Wang
 * @since 2021/7/27 9:57
 */
public class TreeNodeInt {

    /**
     * 当前节点值
     */
    public int val;

    /**
     * 当前节点左子节点
     */
    public TreeNodeInt left;

    /**
     * 当前节点右子节点
     */
    public TreeNodeInt right;

    /**
     * 当前节点的父节点
     */
    public TreeNodeInt parent;

    public TreeNodeInt(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}
