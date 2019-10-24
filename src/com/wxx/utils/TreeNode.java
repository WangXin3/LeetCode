package com.wxx.utils;

/**
 * @author 她爱微笑
 * @date 2019/10/15
 * 树节点
 */
public class TreeNode<T> {
	/**
	 * 当前节点值
	 */
	public T val;

	/**
	 * 当前节点左子节点
	 */
	public TreeNode<T> left;

	/**
	 * 当前节点右子节点
	 */
	public TreeNode<T> right;

	/**
	 * 当前节点的父节点
	 */
	public TreeNode<T> parent;

	public TreeNode(T val) {
		this.val = val;
		this.left = null;
		this.right = null;
		this.parent = null;
	}
}
