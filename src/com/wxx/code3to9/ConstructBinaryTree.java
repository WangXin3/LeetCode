package com.wxx.code3to9;

import com.wxx.util.TreeNode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author 她爱微笑
 * @date 2019/10/18
 * 重建二叉树
 */
public class ConstructBinaryTree {

	/**
	 * 缓存中序遍历数组每个值对应的索引
	 */
	private Map<Integer, Integer> indexForInOrders = new LinkedHashMap<>();

	/**
	 * 重建二叉树
	 * @param pre 前序遍历数组
	 * @param in 中序遍历数组
	 * @return
	 */
	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		for (int i = 0; i < in.length; i++) {
			indexForInOrders.put(in[i], i);
		}

		return reConstructBinaryTree(pre, 0, pre.length - 1, 0);
	}

	/**
	 *
	 * @param pre 前序数组
	 * @param preL 前序左子树长度
	 * @param preR 前序右子树长度
	 * @param inL
	 * @return
	 */
	private TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
		if (preL > preR) {
			return null;
		}

		TreeNode root = new TreeNode(pre[preL]);
		int inIndex = indexForInOrders.get(root.val);
		int leftTreeSize = inIndex - inL;
		root.left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inL);
		root.right = reConstructBinaryTree(pre, preL + leftTreeSize + 1, preR, inL + leftTreeSize + 1);
		return root;
	}

	/**
	 * 					  3
	 * 				   /    \
	 * 				  9	    20
	 * 				  \	   /  \
	 * 		           8  15   7
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * 前序遍历 = [3, 9, 8, 20, 15, 7]
		 * 中序遍历 = [9, 8, 3, 15, 20, 7]
		 */
		int[] pre = {3, 9, 8, 20, 15, 7};
		int[] in = {9, 8, 3, 15, 20, 7};

		ConstructBinaryTree constructBinaryTree = new ConstructBinaryTree();
		TreeNode treeNode = constructBinaryTree.reConstructBinaryTree(pre, in);
		System.out.println("treeNode = " + treeNode);

	}

}
