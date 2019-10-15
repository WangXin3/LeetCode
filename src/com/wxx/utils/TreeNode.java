package com.wxx.utils;

/**
 * @author 她爱微笑
 * @date 2019/10/15
 * 树节点
 */
public class TreeNode<T> {
	public T val;
	public TreeNode<T> left;
	public TreeNode<T> right;

	public TreeNode(T val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}
}
